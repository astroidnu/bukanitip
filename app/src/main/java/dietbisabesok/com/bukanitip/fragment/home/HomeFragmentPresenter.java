package dietbisabesok.com.bukanitip.fragment.home;

import java.util.ArrayList;
import java.util.List;

import dietbisabesok.com.bukanitip.data.Address;
import dietbisabesok.com.bukanitip.data.Country;
import dietbisabesok.com.bukanitip.data.SectionDataModel;
import dietbisabesok.com.bukanitip.data.SectionSecondDataModel;
import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */

public class HomeFragmentPresenter extends ViewPresenter<HomeFragmentView> {
    private HomeFragment mFragment;
    ArrayList<SectionDataModel> allSampleData;
    ArrayList<SectionSecondDataModel> allSampleData2;

    public HomeFragmentPresenter(HomeFragment homeFragment) {
        mFragment = homeFragment;
    }

    @Override
    public void onLoad(){
        super.onLoad();
//        setHorizontalData();
        allSampleData = new ArrayList<>();
        allSampleData2 = new ArrayList<>();
        createDummyData();
    }

    public void createDummyData() {
        for (int i = 1; i <= 2; i++) {
            SectionSecondDataModel dm = new SectionSecondDataModel();
            dm.setHeaderTitle("Countries " + i);
            ArrayList<Country> singleItem = new ArrayList<>();
            for (int j = 0; j <= 5; j++) {
                Country country = new Country();
                country.setCountry_id(String.valueOf(j));
                country.setCountry_name("Indonesia " + j);
                singleItem.add(country);
            }

            dm.setAllItemsInSection(singleItem);

            allSampleData2.add(dm);
        }

        for (int i = 1; i <= 2; i++) {
            SectionDataModel dm = new SectionDataModel();
            dm.setHeaderTitle("Section " + i);
            ArrayList<Address> singleItem = new ArrayList<>();
            for (int j = 0; j <= 5; j++) {
                Address address = new Address();
                address.setCity("Jakarta " + j);
                address.setProvince("DKI Jakarta " + j);
                singleItem.add(address);
            }

            dm.setAllItemsInSection(singleItem);

            allSampleData.add(dm);

            getView().setAdapterHorizontal(allSampleData,allSampleData2);
        }
    }
}
