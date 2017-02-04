package org.mobiletrain.xutilsdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class PostStringFragment extends Fragment implements Callback.CommonCallback<String> {
    public static final String JSON_URL = "http://192.168.1.127:8080/PostServletDemo/PostParamsServlet";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RequestParams params = new RequestParams(JSON_URL);
        params.addBodyParameter("name", "赵四");
        params.addBodyParameter("age", "18");
        x.http().post(params, this);
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
