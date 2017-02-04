package org.mobiletrain.xutilsdemo.fragment;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.json.JSONException;
import org.json.JSONObject;
import org.mobiletrain.xutilsdemo.R;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;

public class PostFileFragment extends Fragment implements Callback.CommonCallback<String> {
    public static final String POST_URL = "http://10.0.184.27:8080/PostServletDemo/PostFileServlet";

    private ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_get_bytes, container, false);

        ImageView imageView = (ImageView) rootView.findViewById(R.id.iv);

        File uploadFile = new File(Environment.getExternalStorageDirectory(), "image.jpg");

        RequestParams params = new RequestParams(POST_URL);
        params.setMultipart(true);
        params.addBodyParameter("name", uploadFile.getName());
        params.addBodyParameter("image", uploadFile);

        x.http().post(params, this);

        return rootView;
    }

    @Override
    public void onSuccess(String result) {
        try {
            JSONObject jsonObjectect = new JSONObject(result);
            String imgUrl = jsonObjectect.getString("img_url");
            Log.d("tag", imgUrl);
            x.image().bind(imageView, imgUrl);
        } catch (JSONException e) {
            e.printStackTrace();
        }
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
