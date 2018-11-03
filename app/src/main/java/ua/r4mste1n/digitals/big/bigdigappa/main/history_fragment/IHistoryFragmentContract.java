package ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment;

import android.arch.lifecycle.LiveData;

import java.util.List;

import ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment.adapter.AdapterData;
import ua.r4mste1n.digitals.big.bigdigappa.root.base.IModel;
import ua.r4mste1n.digitals.big.bigdigappa.root.base.IPresenter;
import ua.r4mste1n.digitals.big.bigdigappa.root.db_manager.Link;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
public interface IHistoryFragmentContract {

    interface Presenter extends IPresenter {

    }

    interface Model extends IModel<Presenter> {
        LiveData<List<Link>> loadData();
        List<AdapterData> convertToAdapterData(List<Link> _links);
    }
}
