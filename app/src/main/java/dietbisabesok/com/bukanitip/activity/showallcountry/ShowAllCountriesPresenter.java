package dietbisabesok.com.bukanitip.activity.showallcountry;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dietbisabesok.com.bukanitip.data.CountryData;
import dietbisabesok.com.bukanitip.model.CountryDataModel;
import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;

/**
 * Created by ibnumuzzakkir on 5/27/17.
 */

public class ShowAllCountriesPresenter extends ViewPresenter<ShowAllCountriesView> {
    @Inject
    CountryDataModel mCountryDataModel;

    private ShowAllCountriesActivity mActivity;
    private List<CountryData> mCountryDataList = new ArrayList<>();

    public ShowAllCountriesPresenter(ShowAllCountriesActivity activity){
        mActivity = activity;
    }

    @Override
    public void onLoad(){
        onFinishActivity();
        getView().setData(mCountryDataModel.loadAll());
    }

    private void onFinishActivity(){
        getView().mArrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.finish();
            }
        });
    }
}
