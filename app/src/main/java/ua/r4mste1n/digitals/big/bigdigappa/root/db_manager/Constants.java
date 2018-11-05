package ua.r4mste1n.digitals.big.bigdigappa.root.db_manager;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Alex Shtain on 04.11.2018.
 */
public final class Constants {

    public interface UriData {
        String TABLE_NAME       = "link";
        String AUTHORITY        = "ua.r4mste1n.digitals.big.bigdigappa";
        Uri URI_LINK            = android.net.Uri.parse("content://" + AUTHORITY + "/" + TABLE_NAME);
    }

    public interface ColumnNames {
        String COLUMN_ID        = BaseColumns._ID;
        String COLUMN_URL       = "url";
        String COLUMN_DATE      = "date";
        String COLUMN_STATUS    = "status";
    }
}
