package ua.r4mste1n.digitals.big.bigdigappa.main.di;

import dagger.Component;
import ua.r4mste1n.digitals.big.bigdigappa.main.navigator.MainActivity;
import ua.r4mste1n.digitals.big.bigdigappa.root.di.DiRootComponent;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
@MainScope
@Component(modules = {
        DiMainModule.class
},
        dependencies = {DiRootComponent.class})
public interface DiMainComponent {
    void inject(MainActivity _activity);
}
