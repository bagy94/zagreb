package hr.factory.app_send_postcard.fragment

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.jakewharton.rxbinding3.widget.textChangeEvents
import hr.factory.app_send_postcard.R
import hr.factory.app_send_postcard.model.MailDataWrapper
import hr.factory.app_send_postcard.presenter.SendPostcardPresenter
import hr.factory.app_send_postcard.utils.GlideDrawableImageTarget
import hr.factory.app_send_postcard.view.SendPostcardView
import hr.factory.base_module.constants.PERMISSION_WRITE_EXTERNAL
import hr.factory.base_module.fragment.BaseFragment
import hr.factory.base_module.utils.hasWriteExternalStoragePermission
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_send_postcard.*
import kotlinx.android.synthetic.main.view_postcard.view.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import java.io.File

class SendPostcardFragment:BaseFragment<SendPostcardPresenter>(), SendPostcardView,
    View.OnClickListener {
    override val presenter:SendPostcardPresenter by inject { parametersOf(this)}

    override val viewId: Int = R.layout.fragment_send_postcard

    private val args:SendPostcardFragmentArgs by navArgs()

    private lateinit var mDisposable:Disposable

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        loadPostcard(view,args.imageUrl)
        toggleEnableSendPostcardButton(false)
        bindToRx()
        sendPostcard.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        presenter.handleClick(v.id,yourName.text.toString(),friendsName.text.toString(),yourMessage.text.toString())
    }

    override fun setEnabledSubmitButton(isEnabled: Boolean) {
        if(isEnabled){
            sendPostcard.setBackgroundResource(R.drawable.rounded_vivid_blue)
            send.setTextColor(resources.getColor(android.R.color.white))
            imgMailLogo.isEnabled = true
        }else{
            sendPostcard.setBackgroundResource(R.drawable.rounded_vivid_blue_disabled)
            send.setTextColor(resources.getColor(R.color.hint_color_inactive))
            imgMailLogo.isEnabled = false
        }
    }

    override fun makePostcard(mailDataWrapper: MailDataWrapper) {
        if(!hasWriteExternalStoragePermission(context!!)){
            requestPermissions(arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), PERMISSION_WRITE_EXTERNAL)
        }else{
            progress.visibility = View.VISIBLE
            progress.bringToFront()
            mDisposable = Observable.just(mailDataWrapper)
                .subscribeOn(Schedulers.newThread())
                .map {
                    val view = createPostcardView(it.friendName,it.message,it.message)
                    createPostcardImageFile(view)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    progress.visibility = View.GONE
                    sendMailIntent(it)
                }
        }
    }

    private fun sendMailIntent(imageFile:File){
        //val uri = FileProvider.getUriForFile(context!!,activity!!.applicationContext.packageName,imageFile)
        val intent = Intent(Intent.ACTION_SEND)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        intent.type = "images/png"
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(imageFile))
        intent.putExtra(Intent.EXTRA_SUBJECT,getString(R.string.mail_subject))
        startActivity(Intent.createChooser(intent,"Share option"))
    }

    private fun loadPostcard(view: View,imageUrl:String){
        val target = GlideDrawableImageTarget(postcard)
        target.setOnResourceSetListener { startPostcardAnimation(it) }
        Glide.with(view)
            .load(imageUrl)
            .into(target)
    }
    private fun initToolbar(){
        toolbar.setNavIcon(R.drawable.ic_arrow_back_white)
        toolbar.setToolbarLogo(R.drawable.ic_toolbar_logo_light)
        toolbar.setOnNavIconListener(this)
    }

    private fun startPostcardAnimation(imageView: ImageView){
        val animUp = AnimationUtils.loadAnimation(context,R.anim.postcard_up)
        val animDown = AnimationUtils.loadAnimation(context,R.anim.postcard_down)
        animUp.setAnimationListener(object:Animation.AnimationListener{
            override fun onAnimationEnd(animation: Animation?) {
                envelopeFront.bringToFront()
                imageView.startAnimation(animDown)
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationStart(animation: Animation?) {

            }
        })
        imageView.startAnimation(animUp)
    }

    private fun toggleEnableSendPostcardButton(isEnabled:Boolean){
        if(isEnabled){
            sendPostcard.setBackgroundResource(R.drawable.rounded_vivid_blue)
            send.setTextColor(resources.getColor(android.R.color.white))
            imgMailLogo.isEnabled = true
        }else{
            sendPostcard.setBackgroundResource(R.drawable.rounded_vivid_blue_disabled)
            send.setTextColor(resources.getColor(R.color.hint_color_inactive))
            imgMailLogo.isEnabled = false
        }
    }

    private fun bindToRx(){
        val observableName = yourName.textChangeEvents()
        val observableFriendName = friendsName.textChangeEvents()
        val observableMessage = yourMessage.textChangeEvents()
        presenter.bindToUserInput(observableName,observableFriendName,observableMessage)
    }
    private fun createPostcardImageFile(view:View):File{
        val bitmap = Bitmap.createBitmap(view.width,view.height,Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        view.draw(canvas)
        val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        val cache = File(path,getString(R.string.image_directory))
        cache.mkdirs()
        val file = File (cache,"/IMG_${System.currentTimeMillis()}.png")
        if(file.createNewFile()){
            file.outputStream().use {
                bitmap.compress(Bitmap.CompressFormat.PNG,100,it)
                it.flush()
            }
        }
        return file
    }
    private fun createPostcardView(friendName: String,message: String,yourName: String?):View{
        val inflater = LayoutInflater.from(context)
        return inflater.inflate(R.layout.view_postcard,null).apply {
            postcardFront.setImageDrawable(postcard.drawable)
            postcardFront.scaleType = ImageView.ScaleType.FIT_XY
            val width = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED)
            measure(width,width)
            layout(0,0,measuredWidth,measuredHeight)
            postcardContainer.postcardContent.apply {
                text = message
            }
            postcardContainer.postcardFor.apply {
                text = friendName
            }

        }
    }
}