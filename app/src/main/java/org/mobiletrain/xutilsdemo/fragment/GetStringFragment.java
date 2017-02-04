package org.mobiletrain.xutilsdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class GetStringFragment extends Fragment implements Callback.CommonCallback<String> {
    private final String JSON_URL = "http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            x.http().get(new RequestParams(JSON_URL), this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onSuccess(String result) {
        Log.d("tag", result);
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {

    }

    @Override
    public void onCancelled(CancelledException cex) {

    }

    @Override
    public void onFinished() {

    }
}
