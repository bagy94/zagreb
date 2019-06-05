package hr.factory.home_location.location_list.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import hr.factory.base_module.adapter.AdapterDataWrapper
import hr.factory.base_module.adapter.RecyclerViewAdapter
import hr.factory.base_module.constants.ITEM_SPACING_10
import hr.factory.base_module.custom_view.SpaceItemDecorator
import hr.factory.base_module.fragment.BaseFragment
import hr.factory.base_module.models.location_raw_item.LocationRawItem
import hr.factory.base_module.utils.SupportedLanguage
import hr.factory.base_module.utils.asDp
import hr.factory.base_module.view.BaseViewHolder
import hr.factory.home_location.R
import hr.factory.home_location.drawer_navigation.fragment.DrawerNavigationViewFragmentDirections
import hr.factory.home_location.location_list.presenter.LocationsPresenter
import hr.factory.home_location.location_list.view.LocationsView
import hr.factory.home_location.location_list.view_holder.LocationViewHolder
import kotlinx.android.synthetic.main.fragment_locations.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class LocationsFragment: BaseFragment<LocationsPresenter>(), LocationsView, LocationViewHolder.OnLocationClickListener, RecyclerViewAdapter.Factory{

    override val viewId: Int = R.layout.fragment_locations

    override val presenter: LocationsPresenter by inject{ parametersOf(this)}

    private val mCurrentLanguage:SupportedLanguage by inject()

    private val mAdapter:RecyclerViewAdapter<LocationRawItem> by lazy { RecyclerViewAdapter<LocationRawItem>(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        presenter.onStart()
    }

    override fun onLocationSelected(location: LocationRawItem) {
        presenter.locationSelected(location)
    }

    override fun openLocationSingle(locationId: Int) {
        val directions = DrawerNavigationViewFragmentDirections.actionOpenSingleLocation(locationId)
        Navigation.findNavController(activity!!,R.id.drawer).navigate(directions)
    }

    override fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = inflater.inflate(viewType, parent, false)
        return LocationViewHolder(view, this, mCurrentLanguage)
    }

    override fun showLocations(locationList: List<AdapterDataWrapper<LocationRawItem>>) {
        mAdapter.setNewData(locationList)
    }

    private fun initRecycler(){
        locationsList.addItemDecoration(SpaceItemDecorator(ITEM_SPACING_10.asDp(),false))
        locationsList.adapter = mAdapter
    }


}