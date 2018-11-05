package ua.r4mste1n.digitals.big.bigdigappa.root.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.IDBManager;
import ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.di.DiDBManagerModule;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
@Singleton
@Component(modules = {
        DiAppModule.class,
        DiDBManagerModule.class
})
public interface DiRootComponent {
    Context context();
    IDBManager dBManager();
}
