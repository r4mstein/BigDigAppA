package ua.r4mste1n.digitals.big.bigdigappa.main.navigator;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import hugo.weaving.DebugLog;
import ua.r4mste1n.digitals.big.bigdigappa.R;
import ua.r4mste1n.digitals.big.bigdigappa.main.home_fragment.HomeFragment;
import ua.r4mste1n.digitals.big.bigdigappa.root.base.BaseActivity;

public class MainActivity extends BaseActivity<IMainNavigator, IMainContract.Model>
        implements IMainContract.Presenter, IMainNavigator {

    @BindView(R.id.toolbar_AH)
    Toolbar toolbar;

    @DebugLog
    @Override
    protected void init() {
        mNavigator = this;
        mObjectGraph.getMainComponent().inject(this);
    }

    @DebugLog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView(this);
        setupUI();
        showHomeFragment();
    }

    @DebugLog
    private void setupUI() {
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);
    }

    @DebugLog
    @Override
    public final void showHomeFragment() {
        replaceFragment(R.id.flRootContainer_AM, HomeFragment.newInstance());
    }
}
