package dietbisabesok.com.bukanitip.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dietbisabesok.com.bukanitip.app.BukaNitipApp;
import dietbisabesok.com.bukanitip.di.component.AppComponent;

/**
 * Created by Ibnu Muzzakkir on 11/12/2016.
 * Contact ibnumuzzaakkir@gmail.com
 * scoproject
 */

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        onCreateComponent(BukaNitipApp.getApp().component());
        View view = initViews(inflater, container, savedInstanceState);
        return view;
    }

    protected abstract View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    protected abstract void onCreateComponent(AppComponent appComponent);
}
