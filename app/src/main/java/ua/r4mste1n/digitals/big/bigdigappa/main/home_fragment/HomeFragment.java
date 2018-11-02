package ua.r4mste1n.digitals.big.bigdigappa.main.home_fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hugo.weaving.DebugLog;
import ua.r4mste1n.digitals.big.bigdigappa.R;
import ua.r4mste1n.digitals.big.bigdigappa.main.navigator.IMainNavigator;
import ua.r4mste1n.digitals.big.bigdigappa.root.base.BaseFragment;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
public final class HomeFragment extends BaseFragment<IMainNavigator, IHomeFragmentContract.Model>
        implements IHomeFragmentContract.Presenter {

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
        return view;
    }
}
