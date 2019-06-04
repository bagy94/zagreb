package hr.factory.app_location_gallery.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import hr.factory.app_location_gallery.R
import hr.factory.app_location_gallery.presenter.SingleImageGalleryPresenter
import hr.factory.app_location_gallery.view.SingleImageGalleryView
import hr.factory.app_location_gallery.view_holder.SingleImageViewHolder
import hr.factory.base_module.adapter.AdapterDataWrapper
import hr.factory.base_module.adapter.RecyclerViewAdapter
import hr.factory.base_module.constants.ITEM_SPACING_5
import hr.factory.base_module.custom_view.SpaceItemDecorator
import hr.factory.base_module.fragment.BaseFragment
import hr.factory.base_module.models.location_raw_item.GalleryRaw
import hr.factory.base_module.utils.asDp
import hr.factory.base_module.view.BaseViewHolder
import kotlinx.android.synthetic.main.fragment_single_image_gallery.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SingleImageGalleryFragment:BaseFragment<SingleImageGalleryPresenter> (), SingleImageGalleryView, View.OnClickListener,RecyclerViewAdapter.Factory{

    override val presenter: SingleImageGalleryPresenter by inject { parametersOf(this)}

    override val viewId: Int = R.layout.fragment_single_image_gallery

    private val args:SingleImageGalleryFragmentArgs by navArgs()

    private val mAdapter:RecyclerViewAdapter<GalleryRaw> by lazy {  RecyclerViewAdapter<GalleryRaw>(this)}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initRecycler()
        presenter.setLocationId(args.locationId)
        args.openedImage?.let { presenter.setSelectedImageUrl(it) }
        openInDigitalLibrary.setOnClickListener(this)
    }

    override fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): BaseViewHolder =
            SingleImageViewHolder(inflater.inflate(R.layout.item_single_gallery,parent,false))

    override fun onClick(v: View) {
        val position = (gallery.layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
        presenter.handleClick(v.id,position)
    }

    override fun showLocationGallery(gallery: List<AdapterDataWrapper<GalleryRaw>>) {
        mAdapter.setNewData(gallery)
    }

    override fun showSelectedImage(selectedImagePosition: Int) {
        mAdapter.notifyItemChanged(selectedImagePosition)
    }

    override fun showLocationName(locationTitle: String) {
        locationName.text = locationTitle
    }

    override fun showCurrentImageOnWeb(imageUrl:String) {
        val ii = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(imageUrl)
        }
        startActivity(ii)
    }

    private fun initToolbar(){
        toolbar.setNavIcon(R.drawable.ic_arrow_back_white)
        toolbar.setToolbarLogo(R.drawable.ic_toolbar_logo_light)
        toolbar.setOnNavIconListener(this)
    }
    private fun initRecycler(){
        gallery.addItemDecoration(SpaceItemDecorator(ITEM_SPACING_5.asDp(),false))
        gallery.adapter = mAdapter
    }
}