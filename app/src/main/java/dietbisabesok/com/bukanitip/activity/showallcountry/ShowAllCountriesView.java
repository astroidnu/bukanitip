package dietbisabesok.com.bukanitip.activity.showallcountry;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.activity.showallcountry.adapter.ShowAllCountriesAdapter;
import dietbisabesok.com.bukanitip.data.CountryData;

/**
 * Created by ibnumuzzakkir on 5/27/17.
 */
@EViewGroup(R.layout.activity_show_all_countries)
public class ShowAllCountriesView extends CoordinatorLayout {
    @ViewById(R.id.toolbar_arrow_left)
    ImageButton mArrowLeft;
    @ViewById(R.id.all_countries_recyclerview)
    RecyclerView mRecyclerView;

    private ShowAllCountriesAdapter mShowAllCountriesAdapter;

    public ShowAllCountriesView(Context context) {
        super(context);
    }

    @AfterViews
    void init(){
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mShowAllCountriesAdapter = new ShowAllCountriesAdapter(getContext());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mShowAllCountriesAdapter);
    }

    public void setData(List<CountryData> countryDataList) {
        if (countryDataList != null) {
            mShowAllCountriesAdapter.setData(countryDataList);
        }
    }
}
