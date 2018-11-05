package ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import hugo.weaving.DebugLog;
import ua.r4mste1n.digitals.big.bigdigappa.R;
import ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment.IHistoryFragmentContract.SortingType;
import ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment.adapter.Adapter;
import ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment.adapter.AdapterData;
import ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment.adapter.ClickListener;
import ua.r4mste1n.digitals.big.bigdigappa.main.navigator.IMainNavigator;
import ua.r4mste1n.digitals.big.bigdigappa.root.base.BaseFragment;
import ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.database.Link;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
public final class HistoryFragment extends BaseFragment<IMainNavigator, IHistoryFragmentContract.Model>
        implements IHistoryFragmentContract.Presenter {

    @BindView(R.id.rvList_HF)
    RecyclerView rvList;

    private Adapter mAdapter;
    private LiveData<List<Link>> mData;

    @DebugLog
    public static HistoryFragment newInstance() {
        return new HistoryFragment();
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
        final View view = _inflater.inflate(R.layout.history_fragment, _container, false);
        bindView(this, view);
        setupList();
        setHasOptionsMenu(true);
        return view;
    }

    @DebugLog
    @Override
    public void onStart() {
        super.onStart();
        if (mData == null) mData = mModel.loadData(SortingType.DEFAULT);
        mData.observe(this, mDataObserver);
    }

    @DebugLog
    @Override
    public void onStop() {
        super.onStop();
        mData.removeObserver(mDataObserver);
    }

    @Override
    public void onCreateOptionsMenu(final Menu _menu, final MenuInflater _inflater) {
        _inflater.inflate(R.menu.sorting_menu, _menu);
    }

    @DebugLog
    @Override
    public boolean onOptionsItemSelected(final MenuItem _item) {
        switch (_item.getItemId()) {
            case R.id.sortingByDate:
                loadDataAfterMenuClicked(SortingType.BY_DATE);
                return true;
            case R.id.sortingByStatus:
                loadDataAfterMenuClicked(SortingType.BY_STATUS);
                return true;
            case R.id.sortingByDefault:
                loadDataAfterMenuClicked(SortingType.DEFAULT);
                return true;
            default: return super.onOptionsItemSelected(_item);
        }
    }

    @DebugLog
    private void loadDataAfterMenuClicked(final SortingType _type) {
        mData.removeObserver(mDataObserver);
        mData = mModel.loadData(_type);
        mData.observe(this, mDataObserver);
    }

    private final Observer<List<Link>> mDataObserver = _links -> dataLoaded(mModel.convertToAdapterData(_links));

    @DebugLog
    private void setupList() {
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new Adapter(getContext());
        mAdapter.setClickListener(mAdapterClickListener);
        rvList.setAdapter(mAdapter);
    }

    private final ClickListener mAdapterClickListener = data ->
            mNavigator.openAppB(new AdapterData()
                    .setLink(data.getLink())
                    .setId(data.getId())
                    .setStatus(data.getStatus())
                    .setTime(data.getTime()),
            true);

    @DebugLog
    private void dataLoaded(final List<AdapterData> _data) {
        mAdapter.addData(_data);
    }
}
