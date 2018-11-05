package ua.r4mste1n.digitals.big.bigdigappa.root.db_manager;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;

import hugo.weaving.DebugLog;
import ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.database.AppDatabase;
import ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.database.Link;

/**
 * Created by Alex Shtain on 05.11.2018.
 */
public final class DBManager implements IDBManager {

    private Context mContext;

    public DBManager(final Context _context) {
        mContext = _context;
    }

    @DebugLog
    @Override
    public final LiveData<List<Link>> getAllLinks() {
        return AppDatabase.getInstance(mContext).linkDao().getAllLinks();
    }

    @DebugLog
    @Override
    public final LiveData<List<Link>> getLinksByDate() {
        return AppDatabase.getInstance(mContext).linkDao().getLinksByDate();
    }

    @DebugLog
    @Override
    public final LiveData<List<Link>> getLinksByStatus() {
        return AppDatabase.getInstance(mContext).linkDao().getLinksByStatus();
    }
}
