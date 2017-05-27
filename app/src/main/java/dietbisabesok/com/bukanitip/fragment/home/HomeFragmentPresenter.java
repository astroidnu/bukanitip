package dietbisabesok.com.bukanitip.fragment.home;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.ViewParent;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.data.Address;
import dietbisabesok.com.bukanitip.data.Country;
import dietbisabesok.com.bukanitip.data.CountryData;
import dietbisabesok.com.bukanitip.data.SectionDataModel;
import dietbisabesok.com.bukanitip.data.SectionSecondDataModel;
import dietbisabesok.com.bukanitip.fragment.home.service.FetchAllCountryListService;
import dietbisabesok.com.bukanitip.fragment.home.service.FetchAllCountryResponse;
import dietbisabesok.com.bukanitip.network.NetworkError;
import dietbisabesok.com.bukanitip.session.LoginSession;
import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */

public class HomeFragmentPresenter extends ViewPresenter<HomeFragmentView> {
    @Inject
    FetchAllCountryListService mFetchAllCountryListService;

    @Inject
    Gson gson;

    @Inject
    LoginSession mLoginSession;

    private HomeFragment mFragment;
    ArrayList<SectionDataModel> allSampleData;
    ArrayList<SectionSecondDataModel> allSampleData2;
    private List<CountryData> mCountryDataList = new ArrayList<>();
    private static final Integer[] images= {R.drawable.buka_nitip,R.drawable.buka_nitip};
    ArrayList<Integer> mImageList;

    public HomeFragmentPresenter(HomeFragment homeFragment) {
        mFragment = homeFragment;
    }

    @Override
    public void onLoad(){
        super.onLoad();
//        setHorizontalData();
        allSampleData = new ArrayList<>();
        allSampleData2 = new ArrayList<>();
        mImageList = new ArrayList<>();
        fetchAllCountryList();
    }

    private void fetchAllCountryList(){
        HashMap<String, String> mParam = new HashMap<>();
        mParam.put("token", mLoginSession.getLoginToken());
        mParam.put("email", mLoginSession.getEmail());
        mParam.put("user_id", mLoginSession.getUserID());
        mFetchAllCountryListService.init(mParam);
        mFetchAllCountryListService.fetchAllCountries(new FetchAllCountryListService.GetResponseCallback() {
            @Override
            public void onSuccess(FetchAllCountryResponse dataList) {
               mCountryDataList = dataList.mListCountryData;
                for (int i = 1; i <= 1; i++) {
                    SectionSecondDataModel dm = new SectionSecondDataModel();
                    dm.setHeaderTitle("Trending Countries ");
                    dm.setAllItemsInSection(mCountryDataList);
                    allSampleData2.add(dm);
                    createDummyData(allSampleData2);
                }
            }

            @Override
            public void onError(NetworkError networkError) {
                Log.e(getClass().getName(), networkError.getMessage());
            }
        });
    }

    public void createDummyData(ArrayList<SectionSecondDataModel> allSampleData2) {


        for(int i = 0;i<images.length;i++){
            mImageList.add(images[i]);
        }


        for (int i = 1; i <= 1; i++) {
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

            getView().setAdapterHorizontal(allSampleData,allSampleData2, mImageList);
        }
    }

//    private void init() {
//        for(int i=0;i<2;i++)
//            XMENArray.add(XMEN[i]);
//
//        mViewPager = (ViewPager) findViewById(R.id.pager);
//        mViewPager.setAdapter(new MyAdapter(MainActivity.this,XMENArray));
//        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
//        indicator.setViewPager(mPager);
//
//        // Auto start of viewpager
//        final Handler handler = new Handler();
//        final Runnable Update = new Runnable() {
//            public void run() {
//                if (currentPage == XMEN.length) {
//                    currentPage = 0;
//                }
//                mPager.setCurrentItem(currentPage++, true);
//            }
//        };
//        Timer swipeTimer = new Timer();
//        swipeTimer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                handler.post(Update);
//            }
//        }, 2500, 2500);
//    }
}
