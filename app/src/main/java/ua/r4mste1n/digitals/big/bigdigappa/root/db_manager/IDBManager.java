package ua.r4mste1n.digitals.big.bigdigappa.root.db_manager;

import android.arch.lifecycle.LiveData;

import java.util.List;

import ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.database.Link;

/**
 * Created by Alex Shtain on 05.11.2018.
 */
public interface IDBManager {
    LiveData<List<Link>> getAllLinks();
    LiveData<List<Link>> getLinksByDate();
    LiveData<List<Link>> getLinksByStatus();
}
