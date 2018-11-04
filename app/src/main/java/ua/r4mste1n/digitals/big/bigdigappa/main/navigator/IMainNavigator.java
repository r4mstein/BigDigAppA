package ua.r4mste1n.digitals.big.bigdigappa.main.navigator;

import ua.r4mste1n.digitals.big.bigdigappa.main.history_fragment.adapter.AdapterData;
import ua.r4mste1n.digitals.big.bigdigappa.root.base.INavigator;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
public interface IMainNavigator extends INavigator {
    void showHomeFragment();
    boolean openAppB(AdapterData _data, boolean _isPutAllData);
}
