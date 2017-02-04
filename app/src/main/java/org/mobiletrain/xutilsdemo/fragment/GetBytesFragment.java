package org.mobiletrain.xutilsdemo.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.mobiletrain.xutilsdemo.R;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class GetBytesFragment extends Fragment implements Callback.CommonCallback<byte[]> {
    private final String FILE_URL = "https://www.baidu.com/img/bd_logo1.png";

    private ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_get_bytes, container, false);
        imageView = (ImageView) rootView.findViewById(R.id.iv);

        x.http().get(new RequestParams(FILE_URL), this);
        return rootView;
    }

    @Override
    public void onSuccess(byte[] result) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(result, 0, result.length);
        imageView.setImageBitmap(bitmap);
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
