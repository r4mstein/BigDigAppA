package ua.r4mste1n.digitals.big.bigdigappa.main.test_fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import hugo.weaving.DebugLog;
import ua.r4mste1n.digitals.big.bigdigappa.R;
import ua.r4mste1n.digitals.big.bigdigappa.main.navigator.IMainNavigator;
import ua.r4mste1n.digitals.big.bigdigappa.root.base.BaseFragment;

/**
 * Created by Alex Shtain on 02.11.2018.
 */
public final class TestFragment extends BaseFragment<IMainNavigator, ITestFragmentContract.Model>
        implements ITestFragmentContract.Presenter {

    @BindView(R.id.etLink_TF)
    EditText etLink;

    @DebugLog
    public static TestFragment newInstance() {
        return new TestFragment();
    }

    @DebugLog
    @Override
    protected void init() {
        mObjectGraph.getMainComponent().inject(this);
    }

    @DebugLog
    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater _inflater, final ViewGroup _container, final Bundle _savedInstanceState) {
        final View view = _inflater.inflate(R.layout.test_fragment, _container, false);
        bindView(this, view);
        return view;
    }

    @OnClick(R.id.btnOk_TF)
    final void onClickOk() {
        if (isEnteredValidLink(etLink.getText().toString())) {
            Toast.makeText(getContext(), "ok", Toast.LENGTH_SHORT).show();
            etLink.setText("");
        }
    }

    private boolean isEnteredValidLink(final String _link) {
        if (TextUtils.isEmpty(_link)) {
            Toast.makeText(getContext(), R.string.warning_empty_link_field, Toast.LENGTH_SHORT).show();
            return false;
        } else if (!mModel.validateLink(_link)) {
            Toast.makeText(getContext(), R.string.warning_valid_link, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
