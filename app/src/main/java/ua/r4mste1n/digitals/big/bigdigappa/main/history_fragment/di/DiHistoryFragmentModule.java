package ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment.di;

import dagger.Module;
import dagger.Provides;
import ua.r4mste1n.digitals.big.bigdigappa.main.di.MainScope;
import ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment.HistoryFragmentModelImpl;
import ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment.IHistoryFragmentContract;
import ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.IDBManager;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
@Module
public final class DiHistoryFragmentModule {

    @Provides
    @MainScope
    final IHistoryFragmentContract.Model provideHistoryFragmentModel(final IDBManager _dbManager) {
        return new HistoryFragmentModelImpl(_dbManager);
    }
}
