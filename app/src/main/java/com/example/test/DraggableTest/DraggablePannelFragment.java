package com.example.test.DraggableTest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.R;
import com.example.test.databinding.DraggablePannelFragmentBinding;

public class DraggablePannelFragment extends Fragment {

    DraggablePannelFragmentBinding draggableBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        draggableBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_draggable_pannel, container, false);
        draggableBinding.draggablePanel.setFragmentManager(getChildFragmentManager());
        // mainActivityBinding.draggablePanel.setTopFragment(VideoPlayerFragment.newInstance(Uri.parse("https://dlkteeygs75wb.cloudfront.net/2580fe71-2455-4aef-b66b-e841dc35dd3d/hls/ds.m3u8")));
        draggableBinding.draggablePanel.setTopFragment(new TopFragment());
        draggableBinding.draggablePanel.setBottomFragment(new BottomFragment());
        draggableBinding.draggablePanel.setTopViewHeight(500);
        draggableBinding.draggablePanel.initializeView();

        /*Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                draggableBinding.draggablePanel.closeToLeft();
            }
        },100);*/

        /*mainActivityBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                draggableBinding.draggablePanel.maximize();
            }
        });*/
        return draggableBinding.getRoot();
    }

}
