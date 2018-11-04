package ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment.adapter;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
public final class AdapterData {
    private long mId = -1;
    private String mLink;
    private long mTime;
    private int mStatus;

    public long getId() {
        return mId;
    }

    public AdapterData setId(long id) {
        mId = id;
        return this;
    }

    public String getLink() {
        return mLink;
    }

    public AdapterData setLink(String link) {
        mLink = link;
        return this;
    }

    public long getTime() {
        return mTime;
    }

    public AdapterData setTime(long time) {
        mTime = time;
        return this;
    }

    public int getStatus() {
        return mStatus;
    }

    public AdapterData setStatus(int status) {
        mStatus = status;
        return this;
    }

    @Override
    public String toString() {
        return "AdapterData{" +
                "mId=" + mId +
                ", mLink='" + mLink + '\'' +
                ", mTime=" + mTime +
                ", mStatus=" + mStatus +
                '}';
    }
}
