package dietbisabesok.com.bukanitip.fragment.mytrip;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dietbisabesok.com.bukanitip.activity.home.DaggerHomeScreenComponent;
import dietbisabesok.com.bukanitip.activity.home.HomeScreenComponent;
import dietbisabesok.com.bukanitip.di.component.AppComponent;
import dietbisabesok.com.bukanitip.ui.base.BaseFragment;

/**
 * Created by ibnumuzzakkir on 5/27/17.
 */

public class MyTripFragment extends BaseFragment {
    private HomeScreenComponent mComponent;
    private MyTripFragmentPresenter mPresenter;
    private MyTripFragmentView mView;
    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = MyTripFragmentView_.build(getContext());
        mPresenter = new MyTripFragmentPresenter(this);
        mComponent.inject(mPresenter);
        mPresenter.takeView(mView);
        return mView;
    }

    @Override
    protected void onCreateComponent(AppComponent appComponent) {
        mComponent = DaggerHomeScreenComponent.builder().appComponent(appComponent).build();
        mComponent.inject(this);
    }
}
