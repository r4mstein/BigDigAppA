package ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import hugo.weaving.DebugLog;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
@Database(entities = {Link.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract LinkDao linkDao();

    private static AppDatabase sInstance;

    @DebugLog
    public static synchronized AppDatabase getInstance(final Context _context) {
        if (sInstance == null) {
            sInstance = Room
                    .databaseBuilder(_context.getApplicationContext(), AppDatabase.class, "links_database")
                    .build();
        }
        return sInstance;
    }
}
