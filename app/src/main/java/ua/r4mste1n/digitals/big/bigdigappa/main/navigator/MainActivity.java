package ua.r4mste1n.digitals.big.bigdigappa.main.navigator;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.Objects;

import butterknife.BindView;
import hugo.weaving.DebugLog;
import ua.r4mste1n.digitals.big.bigdigappa.R;
import ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment.adapter.AdapterData;
import ua.r4mste1n.digitals.big.bigdigappa.main.home_fragment.HomeFragment;
import ua.r4mste1n.digitals.big.bigdigappa.root.base.BaseActivity;
import ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.Constants;

public class MainActivity extends BaseActivity<IMainNavigator, IMainContract.Model>
        implements IMainContract.Presenter, IMainNavigator {

    private static final String ACTION = "ua.r4mste1n.digitals.big.bigdigappb.LAUNCH";

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
        Objects.requireNonNull(toolbar.getOverflowIcon())
                .setColorFilter(ContextCompat.getColor(this, android.R.color.white), PorterDuff.Mode.SRC_ATOP);
        setSupportActionBar(toolbar);
    }

    @DebugLog
    @Override
    public final void showHomeFragment() {
        replaceFragment(R.id.flRootContainer_AM, HomeFragment.newInstance());
    }

    @DebugLog
    @Override
    public final boolean openAppB(final AdapterData _data, final boolean _isPutAllData) {
        final Intent intent = new Intent(ACTION);
        intent.putExtra(Constants.ColumnNames.COLUMN_URL, _data.getLink());
        if (_isPutAllData) {
            intent.putExtra(Constants.ColumnNames.COLUMN_ID, _data.getId());
            intent.putExtra(Constants.ColumnNames.COLUMN_DATE, _data.getTime());
            intent.putExtra(Constants.ColumnNames.COLUMN_STATUS, _data.getStatus());
        }
        if (intent.resolveActivity(Objects.requireNonNull(this).getPackageManager()) != null) {
            startActivity(intent);
            return true;
        } else {
            Toast.makeText(this, "Install BigDigAppB please", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
