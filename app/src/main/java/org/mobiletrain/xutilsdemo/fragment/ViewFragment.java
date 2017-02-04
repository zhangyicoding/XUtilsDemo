package org.mobiletrain.xutilsdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.mobiletrain.xutilsdemo.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.fragment_view)
public class ViewFragment extends Fragment {

    @ViewInject(R.id.list_view)
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return x.view().inject(this, inflater, container);
    }

    // 按钮点击事件
    @Event(R.id.btn)
    private void click(View view) {
        Toast.makeText(getContext(), "哦", Toast.LENGTH_SHORT).show();

    }

    // ListView点击事件
    @Event(type = AdapterView.OnItemClickListener.class, value = R.id.list_view)
    private void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext(), "item点击", Toast.LENGTH_SHORT).show();
    }

    // ListView长点击事件
    @Event(type = AdapterView.OnItemLongClickListener.class, value = R.id.list_view)
    private boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext(), "item长点击", Toast.LENGTH_LONG).show();
        return true;
    }

}
