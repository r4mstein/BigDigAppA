package ua.r4mste1n.digitals.big.bigdigappa.root.db_manager;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.content.ContentValues;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;

import hugo.weaving.DebugLog;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
@SuppressWarnings("unused")
@Entity
public class Link {

    public static final String TABLE_NAME = "link";
    public static final String COLUMN_ID = BaseColumns._ID;
    public static final String COLUMN_URL = "url";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_STATUS = "status";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    private long id;
    @ColumnInfo(name = COLUMN_URL)
    private String url;
    @ColumnInfo(name = COLUMN_DATE)
    private long date;
    @ColumnInfo(name = COLUMN_STATUS)
    private int status;

    @DebugLog
    public static Link fromContentValues(final ContentValues _values) {
        final Link link = new Link();
        if (_values.containsKey(COLUMN_ID)) link.id = _values.getAsLong(COLUMN_ID);
        if (_values.containsKey(COLUMN_URL)) link.url = _values.getAsString(COLUMN_URL);
        if (_values.containsKey(COLUMN_DATE)) link.date = _values.getAsLong(COLUMN_DATE);
        if (_values.containsKey(COLUMN_STATUS)) link.status = _values.getAsInteger(COLUMN_STATUS);
        return link;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @NonNull
    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
