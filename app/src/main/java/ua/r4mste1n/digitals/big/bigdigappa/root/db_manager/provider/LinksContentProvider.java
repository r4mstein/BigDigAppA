package ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Objects;

import hugo.weaving.DebugLog;
import ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.Constants.UriData;
import ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.database.AppDatabase;
import ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.database.Link;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
public final class LinksContentProvider extends ContentProvider {

    private static final int CODE_LINK_DIR          = 1;
    private static final int CODE_LINK_ITEM         = 2;

    private static final UriMatcher MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        MATCHER.addURI(UriData.AUTHORITY, UriData.TABLE_NAME, CODE_LINK_DIR);
        MATCHER.addURI(UriData.AUTHORITY, UriData.TABLE_NAME + "/*", CODE_LINK_ITEM);
    }

    @Override
    public boolean onCreate() {
        return true;
    }

    @DebugLog
    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection,
                        @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @DebugLog
    @Override
    public String getType(@NonNull final Uri _uri) {
        switch (MATCHER.match(_uri)) {
            case CODE_LINK_DIR:
                return "vnd.android.cursor.dir/" + UriData.AUTHORITY + "." + UriData.TABLE_NAME;
            case CODE_LINK_ITEM:
                return "vnd.android.cursor.item/" + UriData.AUTHORITY + "." + UriData.TABLE_NAME;
            default:
                throw new IllegalArgumentException("Unknown URI: " + _uri);
        }
    }

    @DebugLog
    @Nullable
    @Override
    public Uri insert(@NonNull final Uri _uri, @Nullable final ContentValues _values) {
        switch (MATCHER.match(_uri)) {
            case CODE_LINK_DIR:
                final Context context = getContext();
                if (context == null) return null;

                final long id = AppDatabase.getInstance(context).linkDao()
                        .insert(Link.fromContentValues(Objects.requireNonNull(_values)));
                context.getContentResolver().notifyChange(_uri, null);
                return ContentUris.withAppendedId(_uri, id);
            case CODE_LINK_ITEM:
                throw new IllegalArgumentException("Invalid URI, cannot insert with ID: " + _uri);
            default:
                throw new IllegalArgumentException("Unknown URI: " + _uri);
        }
    }

    @DebugLog
    @Override
    public int delete(@NonNull final Uri _uri, @Nullable final String _selection, @Nullable final String[] _selectionArgs) {
        switch (MATCHER.match(_uri)) {
            case CODE_LINK_DIR:
                throw new IllegalArgumentException("Invalid URI, cannot update without ID" + _uri);
            case CODE_LINK_ITEM:
                final Context context = getContext();
                if (context == null) return 0;

                final int count = AppDatabase.getInstance(context).linkDao()
                        .deleteById(ContentUris.parseId(_uri));
                context.getContentResolver().notifyChange(_uri, null);
                return count;
            default:
                throw new IllegalArgumentException("Unknown URI: " + _uri);
        }
    }

    @DebugLog
    @Override
    public int update(@NonNull final Uri _uri, @Nullable final ContentValues _values,
                      @Nullable final String _selection, @Nullable final String[] _selectionArgs) {
        switch (MATCHER.match(_uri)) {
            case CODE_LINK_DIR:
                throw new IllegalArgumentException("Invalid URI, cannot update without ID" + _uri);
            case CODE_LINK_ITEM:
                final Context context = getContext();
                if (context == null) return 0;

                final Link link = Link.fromContentValues(Objects.requireNonNull(_values));
                link.setId(ContentUris.parseId(_uri));
                final int count = AppDatabase.getInstance(context).linkDao().update(link);
                context.getContentResolver().notifyChange(_uri, null);
                return count;
            default:
                throw new IllegalArgumentException("Unknown URI: " + _uri);
        }
    }
}
