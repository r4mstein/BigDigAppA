package ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment.adapter;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
public final class AdapterData {
    private String mLink;
    private String mTime;
    private int mStatus;

    public String getLink() {
        return mLink;
    }

    public void setLink(String link) {
        mLink = link;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int status) {
        mStatus = status;
    }

    @Override
    public String toString() {
        return "AdapterData{" +
                "mLink='" + mLink + '\'' +
                ", mTime='" + mTime + '\'' +
                ", mStatus=" + mStatus +
                '}';
    }
}
