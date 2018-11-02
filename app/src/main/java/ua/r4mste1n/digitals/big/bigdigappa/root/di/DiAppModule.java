package ua.r4mste1n.digitals.big.bigdigappa.root.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
@Module
public final class DiAppModule {

    private final Context mContext;

    public DiAppModule(final Context _context) {
        mContext = _context;
    }

    @Provides
    @Singleton
    final Context provideContext() {
        return mContext;
    }
}
