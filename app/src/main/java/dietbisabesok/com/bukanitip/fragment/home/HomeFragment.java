package dietbisabesok.com.bukanitip.fragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dietbisabesok.com.bukanitip.activity.home.DaggerHomeScreenComponent;
import dietbisabesok.com.bukanitip.activity.home.HomeScreenComponent;
import dietbisabesok.com.bukanitip.di.component.AppComponent;
import dietbisabesok.com.bukanitip.ui.base.BaseFragment;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */

public class HomeFragment extends BaseFragment {
    private HomeScreenComponent mComponent;
    private HomeFragmentView mView;
    private HomeFragmentPresenter mPresenter;

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = HomeFragmentView_.build(getContext());
        mPresenter = new HomeFragmentPresenter(this);
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
