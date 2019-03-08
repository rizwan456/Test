package com.example.test.DraggableTest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.R;
import com.example.test.databinding.BottomFragmentBinding;


public class BottomFragment extends Fragment {
    BottomFragmentBinding bottomFragmentBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bottomFragmentBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_bottom,container,false);
        return bottomFragmentBinding.getRoot();
    }
}
