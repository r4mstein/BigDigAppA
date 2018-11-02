package ua.r4mste1n.digitals.big.bigdigappa.root.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import ua.r4mste1n.digitals.big.bigdigappa.root.ObjectGraph;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
public abstract class BaseFragment<N extends INavigator, M extends IModel> extends Fragment
        implements IPresenter {

    protected N mNavigator;
    @Inject
    protected M mModel;
    protected ObjectGraph mObjectGraph;
    protected Unbinder mUnbinder;

    protected abstract void init();

    @Override
    public void onAttach(final Context _context) {
        super.onAttach(_context);
        //noinspection unchecked
        mNavigator = ((INavigatorProvider<N>) Objects.requireNonNull(getActivity())).getNavigator();
        mObjectGraph = ObjectGraph.getInstance(getActivity().getApplication());
        init();
    }

    protected final void bindView(final BaseFragment _fragment, final View _view) {
        mUnbinder = ButterKnife.bind(_fragment, _view);
    }

    @CallSuper
    @Override
    public void onViewCreated(@NonNull final View _view, @Nullable final Bundle _savedInstanceState) {
        super.onViewCreated(_view, _savedInstanceState);
        //noinspection unchecked
        mModel.setPresenter(this);
    }

    @CallSuper
    @Override
    public void onStop() {
        super.onStop();
        mModel.onStop();
    }

    @CallSuper
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
        mModel.removePresenter();
    }
}
