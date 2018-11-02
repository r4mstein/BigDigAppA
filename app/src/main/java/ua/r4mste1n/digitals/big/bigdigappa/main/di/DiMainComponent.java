package ua.r4mste1n.digitals.big.bigdigappa.main.di;

import dagger.Component;
import ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment.HistoryFragment;
import ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment.di.DiHistoryFragmentModule;
import ua.r4mste1n.digitals.big.bigdigappa.main.home_fragment.HomeFragment;
import ua.r4mste1n.digitals.big.bigdigappa.main.home_fragment.di.DiHomeFragmentModule;
import ua.r4mste1n.digitals.big.bigdigappa.main.navigator.MainActivity;
import ua.r4mste1n.digitals.big.bigdigappa.main.test_fragment.TestFragment;
import ua.r4mste1n.digitals.big.bigdigappa.main.test_fragment.di.DiTestFragmentModule;
import ua.r4mste1n.digitals.big.bigdigappa.root.di.DiRootComponent;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
@MainScope
@Component(modules = {
        DiMainModule.class,
        DiHomeFragmentModule.class,
        DiTestFragmentModule.class,
        DiHistoryFragmentModule.class
},
        dependencies = {DiRootComponent.class})
public interface DiMainComponent {
    void inject(MainActivity _activity);
    void inject(HomeFragment _fragment);
    void inject(TestFragment _fragment);
    void inject(HistoryFragment _fragment);
}
