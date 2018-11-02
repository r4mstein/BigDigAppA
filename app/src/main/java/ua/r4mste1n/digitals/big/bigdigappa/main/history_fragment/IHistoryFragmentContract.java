package ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment;

import java.util.List;

import ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment.adapter.AdapterData;
import ua.r4mste1n.digitals.big.bigdigappa.root.base.IModel;
import ua.r4mste1n.digitals.big.bigdigappa.root.base.IPresenter;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
public interface IHistoryFragmentContract {

    interface Presenter extends IPresenter {
        void dataLoaded(List<AdapterData> _data);
    }

    interface Model extends IModel<Presenter> {
        void loadData();
    }
}
