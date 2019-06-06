package hr.factory.app_location_gallery.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import hr.factory.app_location_gallery.R
import hr.factory.app_location_gallery.presenter.LocationGalleryCategoryPresenter
import hr.factory.app_location_gallery.view.LocationGalleryCategoryView
import hr.factory.app_location_gallery.view_holder.GalleryViewHolder
import hr.factory.base_module.adapter.AdapterDataWrapper
import hr.factory.base_module.adapter.RecyclerViewAdapter
import hr.factory.base_module.constants.ITEM_SPACING_3
import hr.factory.base_module.custom_view.SpaceItemDecorator
import hr.factory.base_module.fragment.BaseFragment
import hr.factory.base_module.models.location_raw_item.GalleryRaw
import hr.factory.base_module.navigation.NavCommand
import hr.factory.base_module.utils.asDp
import hr.factory.base_module.view.BaseViewHolder
import kotlinx.android.synthetic.main.fragment_location_gallery.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class LocationGalleryFragment:BaseFragment<LocationGalleryCategoryPresenter> (),
    LocationGalleryCategoryView,
    View.OnClickListener,
    RecyclerViewAdapter.Factory,
    GalleryViewHolder.OnImageSelectListener{

    override val presenter: LocationGalleryCategoryPresenter by inject{ parametersOf(this)}

    override val viewId: Int = R.layout.fragment_location_gallery

    private val args:LocationGalleryFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initRecycler()
        presenter.setLocationId(args.locationId)
    }

    override fun onClick(v: View) {
        presenter.handleClick(v.id)
    }

    override fun showLocationImages(imageList: List<AdapterDataWrapper<GalleryRaw>>) {
        gallery.adapter = RecyclerViewAdapter(imageList,this)
    }

    override fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): BaseViewHolder =
            GalleryViewHolder(inflater.inflate(R.layout.item_gallery,parent,false), this)

    override fun onImageSelect(galleryItem: GalleryRaw) {
        presenter.imageSelected(galleryItem)
    }

    override fun openSingleImageGallery(locationId: Int, imageUrl: String) {
        val direction = LocationGalleryFragmentDirections.actionOpenSingleImageGallery(locationId,imageUrl)
        navigate(NavCommand.To(direction))
    }

    private fun initToolbar(){
        toolbar.setNavIcon(R.drawable.ic_arrow_back_white)
        toolbar.setToolbarLogo(R.drawable.ic_toolbar_logo_light)
        toolbar.setOnNavIconListener(this)
    }
    private fun initRecycler(){
        gallery.layoutManager = GridLayoutManager(context,3)
        gallery.addItemDecoration(SpaceItemDecorator(ITEM_SPACING_3.asDp()))
        gallery.addItemDecoration(SpaceItemDecorator(ITEM_SPACING_3.asDp(), false))
    }
}