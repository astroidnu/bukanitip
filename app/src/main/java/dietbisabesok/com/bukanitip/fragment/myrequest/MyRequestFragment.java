package dietbisabesok.com.bukanitip.fragment.myrequest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dietbisabesok.com.bukanitip.activity.home.DaggerHomeScreenComponent;
import dietbisabesok.com.bukanitip.activity.home.HomeScreenComponent;
import dietbisabesok.com.bukanitip.di.component.AppComponent;
import dietbisabesok.com.bukanitip.fragment.mytrip.MyTripFragmentPresenter;
import dietbisabesok.com.bukanitip.fragment.mytrip.MyTripFragmentView;
import dietbisabesok.com.bukanitip.ui.base.BaseFragment;

/**
 * Created by ibnumuzzakkir on 5/27/17.
 */

public class MyRequestFragment extends BaseFragment {
    private HomeScreenComponent mComponent;
    private MyRequestFragmentPresenter mPresenter;
    private MyRequestFragmentView mView;

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = MyRequestFragmentView_.build(getContext());
        mPresenter = new MyRequestFragmentPresenter(this);
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
