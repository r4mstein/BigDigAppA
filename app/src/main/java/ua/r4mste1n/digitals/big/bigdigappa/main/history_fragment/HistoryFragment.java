package ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import hugo.weaving.DebugLog;
import ua.r4mste1n.digitals.big.bigdigappa.R;
import ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment.adapter.Adapter;
import ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment.adapter.AdapterData;
import ua.r4mste1n.digitals.big.bigdigappa.main.navigator.IMainNavigator;
import ua.r4mste1n.digitals.big.bigdigappa.root.base.BaseFragment;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
public final class HistoryFragment extends BaseFragment<IMainNavigator, IHistoryFragmentContract.Model>
        implements IHistoryFragmentContract.Presenter {

    @BindView(R.id.rvList_HF)
    RecyclerView rvList;

    private Adapter mAdapter;

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
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mModel.loadData();
    }

    @DebugLog
    private void setupList() {
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new Adapter(getContext());
        rvList.setAdapter(mAdapter);
    }

    @DebugLog
    @Override
    public void dataLoaded(final List<AdapterData> _data) {
        mAdapter.addData(_data);
    }
}
