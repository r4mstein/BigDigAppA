package ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import hugo.weaving.DebugLog;
import ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment.adapter.AdapterData;
import ua.r4mste1n.digitals.big.bigdigappa.root.base.BaseModel;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
public final class HistoryFragmentModelImpl extends BaseModel<IHistoryFragmentContract.Presenter>
        implements IHistoryFragmentContract.Model {

    @Inject
    public HistoryFragmentModelImpl() {

    }

    @DebugLog
    @Override
    public final void loadData() {
        mPresenter.dataLoaded(generateData());
    }

    // TODO: 02.11.2018 delete this method
    private List<AdapterData> generateData() {
        List<AdapterData> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            AdapterData data = new AdapterData();
            data.setLink("https://material.io__" + i);
            data.setTime("02.11.201" + i);
            Random random = new Random();
            data.setStatus(random.nextInt(3) + 1);
            list.add(data);
        }
        return list;
    }
}
