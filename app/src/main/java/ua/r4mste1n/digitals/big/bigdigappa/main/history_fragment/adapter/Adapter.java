package ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import hugo.weaving.DebugLog;
import ua.r4mste1n.digitals.big.bigdigappa.R;
import ua.r4mste1n.digitals.big.bigdigappa.main.Constants.Status;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
public final class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<AdapterData> mData = new ArrayList<>();
    private Context mContext;
    private ClickListener mClickListener;

    public Adapter(final Context _context) {
        mContext = _context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup _viewGroup, final int _viewType) {
        return new ViewHolder(LayoutInflater.from(_viewGroup.getContext()).inflate(R.layout.history_item, _viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder _holder, final int _position) {
        final AdapterData data = mData.get(_position);
        _holder.tvLink.setText(data.getLink());
        _holder.tvTime.setText(createFormattedDate(data.getTime()));
        setupBackgroundColor(_holder, data);
        _holder.itemView.setOnClickListener(v -> mClickListener.itemClicked(data));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    private void setupBackgroundColor(final ViewHolder _holder, final AdapterData _data) {
        switch (_data.getStatus()) {
            case Status.LOADED:
                _holder.cvContainer.setCardBackgroundColor(mContext.getResources().getColor(R.color.green_400));
                break;
            case Status.ERROR:
                _holder.cvContainer.setCardBackgroundColor(mContext.getResources().getColor(R.color.red_400));
                break;
            case Status.UNKNOWN:
                _holder.cvContainer.setCardBackgroundColor(mContext.getResources().getColor(R.color.grey_400));
                break;
        }
    }

    private String createFormattedDate(final long _date) {
        final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy hh:mm", Locale.US);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(_date);
        return formatter.format(calendar.getTime());
    }

    @DebugLog
    public final void addData(final List<AdapterData> _data) {
        mData.clear();
        mData.addAll(_data);
        notifyDataSetChanged();
    }

    public final void setClickListener(final ClickListener _clickListener) {
        mClickListener = _clickListener;
    }

    public final class ViewHolder extends RecyclerView.ViewHolder {

        private final CardView cvContainer;
        private final TextView tvLink;
        private final TextView tvTime;

        public ViewHolder(@NonNull final View _item) {
            super(_item);
            cvContainer = _item.findViewById(R.id.cvContainer_HI);
            tvLink = _item.findViewById(R.id.tvLink_HI);
            tvTime = _item.findViewById(R.id.tvTime_HI);
        }
    }
}
