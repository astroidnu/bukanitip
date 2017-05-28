package dietbisabesok.com.bukanitip.activity.listoffering;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import dietbisabesok.com.bukanitip.activity.addnewoffering.AddNewOfferingActivity;
import dietbisabesok.com.bukanitip.data.ListOfferingData;
import dietbisabesok.com.bukanitip.di.component.AppComponent;
import dietbisabesok.com.bukanitip.ui.base.BaseActivity;
import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;
import dietbisabesok.com.bukanitip.ui.navigation.ActivityScreen;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class ListOfferingActivity extends BaseActivity {
    private ListOfferingComponent mComponent;
    private ListOfferingView mView;
    private ListOfferingPresenter mPresenter;
    @Override
    protected void onCreateUI(Bundle bundle) {
        mView = ListOfferingView_.build(this);
        setContentView(mView);
        List<ListOfferingData> mData =  getIntent().getParcelableArrayListExtra(Screen.TAG_DATA);
        mPresenter = new ListOfferingPresenter(this, mData);
        mComponent.inject(mPresenter);
        mPresenter.takeView(mView);
    }

    @Override
    protected void onCreateComponent(AppComponent appComponent) {
        mComponent = DaggerListOfferingComponent.builder().appComponent(appComponent).build();
        mComponent.inject(this);
    }

    @Override
    protected boolean isValid() {
        return false;
    }

    @Override
    protected ViewPresenter<? extends View> presenter() {
        return mPresenter;
    }

    public static class Screen extends ActivityScreen {
        public static  final String TAG_DATA= "data";
        private ArrayList<ListOfferingData> mData = new ArrayList<>();
        public Screen(List<ListOfferingData> mListOfferingDatas) {
            mData.addAll(mListOfferingDatas);
        }

        @Override
        protected void configureIntent(@NonNull Intent intent) {
            intent.putParcelableArrayListExtra(TAG_DATA,mData);
        }

        @Override
        protected Class<? extends Activity> activityClass() {
            return ListOfferingActivity.class;
        }
    }
}
