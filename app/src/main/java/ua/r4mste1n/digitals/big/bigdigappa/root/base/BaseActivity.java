package ua.r4mste1n.digitals.big.bigdigappa.root.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
public abstract class BaseActivity<N extends INavigator, M extends IModel> extends AppCompatActivity
        implements INavigatorProvider<N>, IPresenter {

    protected N mNavigator;
    @Inject
    protected M mModel;

    protected abstract void init();

    @Override
    public final N getNavigator() {
        return mNavigator;
    }

    @Override
    protected void onCreate(@Nullable final Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //noinspection unchecked
        mModel.setPresenter(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mModel.removePresenter();
    }

    protected final void bindView(final BaseActivity _activity) {
        ButterKnife.bind(_activity);
    }

    protected final void addFragment(final int _containerId, final @NonNull Fragment _fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(_containerId, _fragment)
                .commit();
    }

    protected final void replaceFragment(final int _containerId, final @NonNull Fragment _fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(_containerId, _fragment)
                .commit();
    }

    protected final void replaceFragmentAndAddToBackStack(final int _containerId, final @NonNull Fragment _fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(_containerId, _fragment)
                .addToBackStack(null)
                .commit();
    }
}
