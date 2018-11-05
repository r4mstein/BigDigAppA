package ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment;

import android.arch.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hugo.weaving.DebugLog;
import ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment.IHistoryFragmentContract.SortingType;
import ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment.adapter.AdapterData;
import ua.r4mste1n.digitals.big.bigdigappa.root.base.BaseModel;
import ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.IDBManager;
import ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.database.Link;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
public final class HistoryFragmentModelImpl extends BaseModel<IHistoryFragmentContract.Presenter>
        implements IHistoryFragmentContract.Model {

    private final IDBManager mDBManager;

    @Inject
    public HistoryFragmentModelImpl(final IDBManager _dbManager) {
        mDBManager = _dbManager;
    }

    @DebugLog
    @Override
    public final LiveData<List<Link>> loadData(final SortingType _type) {
        switch (_type) {
            case BY_DATE:
                return mDBManager.getLinksByDate();
            case BY_STATUS:
                return mDBManager.getLinksByStatus();
            case DEFAULT:
                return mDBManager.getAllLinks();
            default: throw new IllegalArgumentException("Illegal sorting type");
        }
    }

    @DebugLog
    @Override
    public final List<AdapterData> convertToAdapterData(final List<Link> _links) {
        final List<AdapterData> dataList = new ArrayList<>();
        for (Link link : _links) {
            final AdapterData data = new AdapterData();
            data.setId(link.getId());
            data.setLink(link.getUrl());
            data.setStatus(link.getStatus());
            data.setTime(link.getDate());
            dataList.add(data);
        }
        return dataList;
    }
}
