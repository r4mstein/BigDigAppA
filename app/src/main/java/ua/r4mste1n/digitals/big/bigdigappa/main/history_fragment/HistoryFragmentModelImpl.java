package ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hugo.weaving.DebugLog;
import ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment.adapter.AdapterData;
import ua.r4mste1n.digitals.big.bigdigappa.root.base.BaseModel;
import ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.AppDatabase;
import ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.Link;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
public final class HistoryFragmentModelImpl extends BaseModel<IHistoryFragmentContract.Presenter>
        implements IHistoryFragmentContract.Model {

    private final Context mContext;

    @Inject
    public HistoryFragmentModelImpl(final Context _context) {
        mContext = _context;
    }

    @DebugLog
    @Override
    public final LiveData<List<Link>> loadData() {
        return AppDatabase.getInstance(mContext).linkDao().getAllLinks();
    }

    @DebugLog
    @Override
    public final List<AdapterData> convertToAdapterData(final List<Link> _links) {
        final List<AdapterData> dataList = new ArrayList<>();
        for (Link link : _links) {
            final AdapterData data = new AdapterData();
            data.setLink(link.getUrl());
            data.setStatus(link.getStatus());
            data.setTime(link.getDate() + "");
            dataList.add(data);
        }
        return dataList;
    }
}
