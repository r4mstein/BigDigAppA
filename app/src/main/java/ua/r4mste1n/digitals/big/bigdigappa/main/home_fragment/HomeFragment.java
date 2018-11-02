package ua.r4mste1n.digitals.big.bigdigappa.main.home_fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import hugo.weaving.DebugLog;
import ua.r4mste1n.digitals.big.bigdigappa.R;
import ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment.HistoryFragment;
import ua.r4mste1n.digitals.big.bigdigappa.main.home_fragment.adapter.TabsAdapter;
import ua.r4mste1n.digitals.big.bigdigappa.main.navigator.IMainNavigator;
import ua.r4mste1n.digitals.big.bigdigappa.main.test_fragment.TestFragment;
import ua.r4mste1n.digitals.big.bigdigappa.root.base.BaseFragment;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
public final class HomeFragment extends BaseFragment<IMainNavigator, IHomeFragmentContract.Model>
        implements IHomeFragmentContract.Presenter {

    @BindView(R.id.tlTabs_HF)
    TabLayout tlTabs;
    @BindView(R.id.vpPager_HF)
    ViewPager vpPager;

    @DebugLog
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @DebugLog
    @Override
    protected void init() {
        mObjectGraph.getMainComponent().inject(this);
    }

    @DebugLog
    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater _inflater, final ViewGroup _container, final Bundle _savedInstanceState) {
        final View view = _inflater.inflate(R.layout.home_fragment, _container, false);
        bindView(this, view);
        setupTabs();
        return view;
    }

    @DebugLog
    private void setupTabs() {
        final TabsAdapter tabsAdapter = new TabsAdapter(getChildFragmentManager());
        tabsAdapter.addFragment(TestFragment.newInstance(), getString(R.string.tab_name_test));
        tabsAdapter.addFragment(HistoryFragment.newInstance(), getString(R.string.tab_name_history));
        vpPager.setAdapter(tabsAdapter);
        tlTabs.setupWithViewPager(vpPager);
    }
}
