package com.example.test.DraggableTest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.R;
import com.example.test.databinding.TopFragmentBinding;

public class TopFragment extends Fragment {

    TopFragmentBinding topFragmentBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        topFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_top,container,false);
        return topFragmentBinding.getRoot();
    }
}
