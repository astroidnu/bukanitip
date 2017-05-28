package dietbisabesok.com.bukanitip.fragment.diaspora;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dietbisabesok.com.bukanitip.activity.home.DaggerHomeScreenComponent;
import dietbisabesok.com.bukanitip.activity.home.HomeScreenComponent;
import dietbisabesok.com.bukanitip.di.component.AppComponent;
import dietbisabesok.com.bukanitip.ui.base.BaseFragment;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class DiasporaFragment extends BaseFragment {
    private DiasporaView mView;
    private DiasporaPresenter mPresenter;
    private HomeScreenComponent mComponent;


    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = DiasporaView_.build(getContext());
        mPresenter = new DiasporaPresenter(this);
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
