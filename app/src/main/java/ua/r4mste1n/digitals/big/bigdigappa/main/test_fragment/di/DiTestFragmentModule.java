package ua.r4mste1n.digitals.big.bigdigappa.main.test_fragment.di;

import dagger.Module;
import dagger.Provides;
import ua.r4mste1n.digitals.big.bigdigappa.main.di.MainScope;
import ua.r4mste1n.digitals.big.bigdigappa.main.test_fragment.ITestFragmentContract;
import ua.r4mste1n.digitals.big.bigdigappa.main.test_fragment.TestFragmentModelImpl;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
@Module
public final class DiTestFragmentModule {

    @Provides
    @MainScope
    final ITestFragmentContract.Model provideTestFragmentModel() {
        return new TestFragmentModelImpl();
    }
}
