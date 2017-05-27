package dietbisabesok.com.bukanitip.activity.showallcountry;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import dietbisabesok.com.bukanitip.data.CountryData;
import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;

/**
 * Created by ibnumuzzakkir on 5/27/17.
 */

public class ShowAllCountriesPresenter extends ViewPresenter<ShowAllCountriesView> {
    private ShowAllCountriesActivity mActivity;
    private List<CountryData> mCountryDataList = new ArrayList<>();

    public ShowAllCountriesPresenter(ShowAllCountriesActivity activity){
        mActivity = activity;
    }

    @Override
    public void onLoad(){
        createDummyData();
        onFinishActivity();
    }

    private void onFinishActivity(){
        getView().mArrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.finish();
            }
        });
    }

    private void createDummyData(){
        for(int i = 0;i<10;i++){
            CountryData countryData = new CountryData();
            countryData.setName("Indonesia " + i);
            mCountryDataList.add(countryData);
        }

        getView().setData(mCountryDataList);
    }

}
