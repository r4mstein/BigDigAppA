package ua.r4mste1n.digitals.big.bigdigappa.main.test_fragment;

import ua.r4mste1n.digitals.big.bigdigappa.root.base.IModel;
import ua.r4mste1n.digitals.big.bigdigappa.root.base.IPresenter;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
public interface ITestFragmentContract {

    interface Presenter extends IPresenter {

    }

    interface Model extends IModel<Presenter> {
        boolean validateLink(String _link);
    }
}
