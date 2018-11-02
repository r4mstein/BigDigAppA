package ua.r4mste1n.digitals.big.bigdigappa.main.di;

import dagger.Module;
import dagger.Provides;
import ua.r4mste1n.digitals.big.bigdigappa.main.navigator.IMainContract;
import ua.r4mste1n.digitals.big.bigdigappa.main.navigator.MainModelImpl;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
@Module
public final class DiMainModule {

    @Provides
    @MainScope
    final IMainContract.Model provideMainModel() {
        return new MainModelImpl();
    }
}
