package dietbisabesok.com.bukanitip.activity.home;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.roughike.bottombar.BottomBar;

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
    @ViewById(R.id.toolbar_title)
    TextView mToolbarTitle;
    @ViewById(R.id.home_bottom_bar)
    BottomBar mBottomBar;
    @ViewById(R.id.menu_my_request)
    FloatingActionButton mMenuMyRequest;
    @ViewById(R.id.myScrollingContent)
    NestedScrollView mMyScrollingContent;
    @ViewById(R.id.home_screen_floating_action_menu)
    FloatingActionMenu mFloatingActionMenu;

    @AfterViews
    void init(){

    }
    public HomeScreenView(Context context) {
        super(context);
    }
}
