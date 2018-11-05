package ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.DBManager;
import ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.IDBManager;

/**
 * Created by Alex Shtain on 05.11.2018.
 */
@Module
public final class DiDBManagerModule {

    @Provides
    @Singleton
    final IDBManager provideDBManager(final Context _context) {
        return new DBManager(_context);
    }
}
