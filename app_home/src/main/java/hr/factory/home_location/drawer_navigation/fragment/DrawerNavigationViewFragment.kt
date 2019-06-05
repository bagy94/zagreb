package hr.factory.home_location.drawer_navigation.fragment

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import hr.factory.base_module.fragment.BaseFragment
import hr.factory.base_module.models.location_raw_item.LocationRawItem
import hr.factory.base_module.navigation.NavCommand
import hr.factory.base_module.utils.SupportedLanguage
import hr.factory.base_module.view.toggleSelectWith
import hr.factory.home_location.R
import hr.factory.home_location.drawer_navigation.presenter.DrawerNavigationPresenter
import hr.factory.home_location.drawer_navigation.view.DrawerNavigationView
import hr.factory.home_location.location_list.fragment.LocationsFragmentDirections
import hr.factory.home_location.maps.fragment.MapFragment
import hr.factory.home_location.maps.fragment.MapFragmentDirections
import kotlinx.android.synthetic.main.fragment_drawer.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class DrawerNavigationViewFragment: BaseFragment<DrawerNavigationPresenter>(),View.OnClickListener,
    DrawerNavigationView, CompoundButton.OnCheckedChangeListener,
    BottomNavigationView.OnNavigationItemSelectedListener, MapFragment.PostcardButtonDelegate{
    override val viewId: Int = R.layout.fragment_drawer

    override val presenter: DrawerNavigationPresenter by inject{ parametersOf(this)}

    val mNavController: NavController by lazy {  childFragmentManager.findFragmentById(R.id.nav_host_fragment)!!.findNavController()}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        presenter.onStart()
        val navHost = childFragmentManager.findFragmentById(R.id.nav_host_fragment)!! as NavHostFragment
        navHost.childFragmentManager.addOnBackStackChangedListener {
            val frag = navHost.childFragmentManager.findFragmentById(R.id.mapFragment)
            if(frag != null && frag is MapFragment){
                Toast.makeText(context!!,"Jep",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onClick(v: View) {
        presenter.handleClick(v.id)
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }
    }

    /*override fun onChangeLanguageToEng() {
        if(!actionEng.isSelected){
            actionEng.toggleSelectWith(actionCro)
            drawer.closeDrawer(GravityCompat.START)
            presenter.changeLanguage(SupportedLanguage.EN)
        }
    }

    override fun onChangeLanguageToCroatian() {
        if(!actionCro.isSelected){
            actionCro.toggleSelectWith(actionEng)
            drawer.closeDrawer(GravityCompat.START)
            presenter.changeLanguage(SupportedLanguage.CRO)
        }
    }*/

    override fun showButton(markerData: LocationRawItem) {
        sendPostcard.visibility = View.VISIBLE
        sendPostcard.bringToFront()
        sendPostcard.setOnClickListener{
            val direction =
                DrawerNavigationViewFragmentDirections.actionSendPostcardFromMap(markerData.imageAfterUrl)
            navigate(NavCommand.To(direction))
        }
    }

    override fun hideButton() {
        sendPostcard.visibility = View.GONE
    }

    override fun onActionAbout() {

    }

    override fun onPostcard() {
        sendPostcard.visibility = View.GONE
        bottomBar.selectedItemId = R.id.locationsFragment
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if(item.isChecked) return false
        presenter.handleClick(item.itemId)
        return true
    }


    override fun onLanguageChanged(lang: SupportedLanguage, reload:Boolean) {
        when(lang){
            SupportedLanguage.CRO -> actionCro.toggleSelectWith(actionEng)
            else ->{actionEng.toggleSelectWith(actionCro)}
        }
        if(reload){
            activity?.recreate()
            drawer.closeDrawer(GravityCompat.START)
        }
    }


    override fun onActionTeam() {
        //TODO open fragment
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        //TODO ?
    }

    override fun openMapView() {
        val direction =  MapFragmentDirections.actionOpenMapFragment()
        navigate(NavCommand.To(direction), mNavController)
    }

    override fun openLocationsView() {
        sendPostcard.visibility = View.GONE
        val direction =  LocationsFragmentDirections.actionOpenLocationFragment()
        navigate(NavCommand.To(direction), mNavController)
    }

    private fun initViews(){
        toolbar.bindDrawer(drawer)
        bottomBar.setOnNavigationItemSelectedListener(this)
        actionCro.setOnClickListener(this)
        actionEng.setOnClickListener(this)
        drawerActionPostcards.setOnClickListener(this)
        drawerActionAbout.setOnClickListener(this)
        drawerActionTeam.setOnClickListener(this)
        //drawerHistoricalWalk.setOnCheckedChangeListener(this)
    }
}