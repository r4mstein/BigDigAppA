package ua.r4mste1n.digitals.big.bigdigappa.main.home_fragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import hugo.weaving.DebugLog;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
public final class TabsAdapter extends FragmentPagerAdapter {

    private static final int TABS_COUNT = 2;

    private List<Fragment> mFragmentList = new ArrayList<>(TABS_COUNT);
    private List<String> mTitleList = new ArrayList<>(TABS_COUNT);

    public TabsAdapter(final FragmentManager _fm) {
        super(_fm);
    }

    @DebugLog
    @Override
    public final Fragment getItem(final int _position) {
        return mFragmentList.get(_position);
    }

    @Override
    public int getCount() {
        return TABS_COUNT;
    }

    @DebugLog
    @Override
    public CharSequence getPageTitle(final int _position) {
        return mTitleList.get(_position);
    }

    @DebugLog
    public final void addFragment(final Fragment _fragment, final String _title) {
        mFragmentList.add(_fragment);
        mTitleList.add(_title);
    }
}
