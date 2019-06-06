package hr.factory.locations_single.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import hr.factory.base_module.adapter.AdapterDataWrapper
import hr.factory.base_module.adapter.RecyclerViewAdapter
import hr.factory.base_module.constants.MAPS_PACKAGE
import hr.factory.base_module.fragment.BaseFragment
import hr.factory.base_module.navigation.NavCommand
import hr.factory.base_module.view.BaseViewHolder
import hr.factory.locations_single.R
import hr.factory.locations_single.presenter.SingleLocationPresenter
import hr.factory.locations_single.view.SingleLocationView
import hr.factory.locations_single.view_holder.*
import kotlinx.android.synthetic.main.fragment_single_location.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SingleLocationFragment:BaseFragment<SingleLocationPresenter> (), SingleLocationView, View.OnClickListener,RecyclerViewAdapter.Factory,
    PostcardViewHolder.OnSendPostcardClickListener {

    override val presenter: SingleLocationPresenter by inject {parametersOf(this)}

    override val viewId: Int = R.layout.fragment_single_location

    private val args:SingleLocationFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbarSingle.setNavIcon(R.drawable.ic_arrow_back)
        toolbarSingle.setOnNavIconListener(this)
        toolbarSingle.setOnShareClickListener(this)
        presenter.setLocationId(args.locationId)
    }

    override fun showLocationInfo(locationData: List<AdapterDataWrapper<Any>>) {
        val adapter = RecyclerViewAdapter(locationData,this)
        locationContent.adapter = adapter
    }

    override fun onClick(v: View) {
        presenter.handleClick(v.id)
    }

    override fun onShareClick(message:String, imageLink:String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        val content = getString(R.string.mail_content_link, imageLink)
        val extraText = "$message ${System.lineSeparator()} $content"
        intent.putExtra(Intent.EXTRA_TEXT,extraText)
        startActivity(Intent.createChooser(intent,"Share option"))
    }

    override fun openLocationGallery(locationId: Int) {
        val direction = SingleLocationFragmentDirections.actionOpenLocationGallery(locationId)
        navigate(NavCommand.To(direction))
    }

    override fun openSingleLocationGallery(locationId: Int, selectedImageUrl: String) {
        val direction = SingleLocationFragmentDirections.actionOpenLocationSingleGallery(
            locationId,
            selectedImageUrl
        )
        navigate(NavCommand.To(direction))
    }

    override fun onSendPostcardClickListener(imageUrl: String) {
        val direction = SingleLocationFragmentDirections.actionSendPostcard(imageUrl)
        navigate(NavCommand.To(direction))
    }

    override fun openNavigationIntent(lat: Double, long: Double, mode: String?) {
        val query = "q=$lat,$long"
        Intent(Intent.ACTION_VIEW).apply {
            //TODO Refactor const
            data = Uri.parse("google.navigation:$query")
            setPackage(MAPS_PACKAGE)
            startActivity(this)
        }
    }

    override fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = inflater.inflate(viewType,parent, false)
        return when(viewType){
            R.layout.item_now_and_then->NowAndThenViewHolder(view)

            R.layout.item_about -> AboutViewHolder(view)

            R.layout.item_post_card-> PostcardViewHolder(view,this)

            R.layout.item_location_single -> LocationViewHolder(view, this)

            R.layout.view_postcard -> PostcardItemViewHolder(view)

            else ->  LibraryViewHolder(view, this)
        }
    }
}