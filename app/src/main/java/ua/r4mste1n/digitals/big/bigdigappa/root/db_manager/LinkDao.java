package ua.r4mste1n.digitals.big.bigdigappa.root.db_manager;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.Constants.ColumnNames;
import ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.Constants.UriData;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
@Dao
public interface LinkDao {

    @Query("SELECT * FROM " + UriData.TABLE_NAME)
    LiveData<List<Link>> getAllLinks();

    @Insert
    long insert(Link link);

    @Update
    int update(Link link);

    @Delete
    void delete(Link link);

    @Query("DELETE FROM " + UriData.TABLE_NAME + " WHERE " + ColumnNames.COLUMN_ID + " = :id")
    int deleteById(long id);
}
