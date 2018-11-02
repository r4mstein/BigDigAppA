package ua.r4mste1n.digitals.big.bigdigappa.root;

import android.content.Context;

import ua.r4mste1n.digitals.big.bigdigappa.main.di.DaggerDiMainComponent;
import ua.r4mste1n.digitals.big.bigdigappa.main.di.DiMainComponent;
import ua.r4mste1n.digitals.big.bigdigappa.root.di.DaggerDiRootComponent;
import ua.r4mste1n.digitals.big.bigdigappa.root.di.DiAppModule;
import ua.r4mste1n.digitals.big.bigdigappa.root.di.DiRootComponent;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
public final class ObjectGraph {

    private static ObjectGraph graph;

    private DiMainComponent mMainComponent;

    public static ObjectGraph getInstance(final Context _context) {
        if (graph == null) {
            graph = new ObjectGraph(_context);
        }
        return graph;
    }

    public ObjectGraph(final Context _context) {
        DiRootComponent rootComponent = DaggerDiRootComponent.builder().diAppModule(new DiAppModule(_context)).build();
        mMainComponent = DaggerDiMainComponent.builder().diRootComponent(rootComponent).build();
    }

    public final DiMainComponent getMainComponent() {
        return mMainComponent;
    }
}
