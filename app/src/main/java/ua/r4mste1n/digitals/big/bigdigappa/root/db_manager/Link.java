package ua.r4mste1n.digitals.big.bigdigappa.root.db_manager;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.content.ContentValues;
import android.support.annotation.NonNull;

import hugo.weaving.DebugLog;
import ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.Constants.ColumnNames;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
@SuppressWarnings("unused")
@Entity
public class Link {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ColumnNames.COLUMN_ID)
    private long id;
    @ColumnInfo(name = ColumnNames.COLUMN_URL)
    private String url;
    @ColumnInfo(name = ColumnNames.COLUMN_DATE)
    private long date;
    @ColumnInfo(name = ColumnNames.COLUMN_STATUS)
    private int status;

    @DebugLog
    public static Link fromContentValues(final ContentValues _values) {
        final Link link = new Link();
        if (_values.containsKey(ColumnNames.COLUMN_ID)) link.id = _values.getAsLong(ColumnNames.COLUMN_ID);
        if (_values.containsKey(ColumnNames.COLUMN_URL)) link.url = _values.getAsString(ColumnNames.COLUMN_URL);
        if (_values.containsKey(ColumnNames.COLUMN_DATE)) link.date = _values.getAsLong(ColumnNames.COLUMN_DATE);
        if (_values.containsKey(ColumnNames.COLUMN_STATUS)) link.status = _values.getAsInteger(ColumnNames.COLUMN_STATUS);
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
