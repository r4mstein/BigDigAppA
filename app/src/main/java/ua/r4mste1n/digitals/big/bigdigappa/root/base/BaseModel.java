package ua.r4mste1n.digitals.big.bigdigappa.root.base;

import android.support.annotation.CallSuper;

import hugo.weaving.DebugLog;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
public abstract class BaseModel<P extends IPresenter> implements IModel<P> {

    protected P mPresenter;

    @CallSuper
    @DebugLog
    @Override
    public void setPresenter(final P _presenter) {
        mPresenter = _presenter;
    }

    @CallSuper
    @DebugLog
    @Override
    public void removePresenter() {
        mPresenter = null;
    }

    /**
     *  This method is called in onStop() method in BaseFragment.
     *  Override to add custom behavior.
     */
    @CallSuper
    @DebugLog
    @Override
    public void onStop() {

    }
}
