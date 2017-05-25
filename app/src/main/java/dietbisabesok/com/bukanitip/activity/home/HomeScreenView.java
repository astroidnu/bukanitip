package dietbisabesok.com.bukanitip.activity.home;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import dietbisabesok.com.bukanitip.R;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */
@EViewGroup(R.layout.activity_home_screen)
public class HomeScreenView extends CoordinatorLayout {
    @ViewById(R.id.home_toolbar)
    Toolbar mToolbar;

    @AfterViews
    void init(){

    }
    public HomeScreenView(Context context) {
        super(context);
    }
}
