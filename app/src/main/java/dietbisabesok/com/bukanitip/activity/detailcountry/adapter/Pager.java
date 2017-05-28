package dietbisabesok.com.bukanitip.activity.detailcountry.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import dietbisabesok.com.bukanitip.fragment.diaspora.DiasporaFragment;
import dietbisabesok.com.bukanitip.fragment.myrequest.MyRequestFragment;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class Pager extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                MyRequestFragment myRequestFragment = new MyRequestFragment();
                return myRequestFragment;
            case 1:
                DiasporaFragment diasporaFragment = new DiasporaFragment();
                return diasporaFragment;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}