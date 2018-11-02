package ua.r4mste1n.digitals.big.bigdigappa.main.test_fragment;

import android.util.Patterns;

import javax.inject.Inject;

import hugo.weaving.DebugLog;
import ua.r4mste1n.digitals.big.bigdigappa.root.base.BaseModel;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
public final class TestFragmentModelImpl extends BaseModel<ITestFragmentContract.Presenter>
        implements ITestFragmentContract.Model {

    @Inject
    public TestFragmentModelImpl() {

    }

    @DebugLog
    @Override
    public final boolean validateLink(final String _link) {
        return Patterns.WEB_URL.matcher(_link).matches();
    }
}
