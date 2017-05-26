package dietbisabesok.com.bukanitip.fragment.home;

import java.util.ArrayList;
import java.util.List;

import dietbisabesok.com.bukanitip.data.Address;
import dietbisabesok.com.bukanitip.data.SectionDataModel;
import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */

public class HomeFragmentPresenter extends ViewPresenter<HomeFragmentView> {
    private HomeFragment mFragment;
    ArrayList<SectionDataModel> allSampleData;

    public HomeFragmentPresenter(HomeFragment homeFragment) {
        mFragment = homeFragment;
    }

    @Override
    public void onLoad(){
        super.onLoad();
//        setHorizontalData();
        allSampleData = new ArrayList<>();
        createDummyData();
    }

    private void setHorizontalData(){
        List<Address> mAddressList = new ArrayList<>();
        for(int i = 0;i<10;i++){
            Address address = new Address();
            address.setCity("Jakarta" + i);
            address.setProvince("DKI Jakarta" + i);
            mAddressList.add(address);
        }
    }


    public void createDummyData() {
        for (int i = 1; i <= 5; i++) {

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

            getView().setAdapterHorizontal(allSampleData);
        }
    }
}
