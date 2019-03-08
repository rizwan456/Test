package com.example.test.expandable_recyclerView_custom;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.R;
import com.example.test.databinding.CRMainFragmentBinding;

import java.util.ArrayList;

public class CRMainFragment extends Fragment {
    CRMainFragmentBinding crMainFragmentBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        crMainFragmentBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_crmain,container,false);
        initiateExpander();
        return crMainFragmentBinding.getRoot();
    }
    private void initiateExpander() {

        ArrayList<String> parentList = new ArrayList<>();
        ArrayList<ArrayList> childListHolder = new ArrayList<>();

        parentList.add("Fruits & Vegetables");
        parentList.add("Beverages & Health");
        parentList.add("Home & Kitchen");

        ArrayList<String> childNameList = new ArrayList<>();
        childNameList.add("Apple");
        childNameList.add("Mango");
        childNameList.add("Banana");

        childListHolder.add(childNameList);

        childNameList = new ArrayList<>();
        childNameList.add("Red bull");
        childNameList.add("Maa");
        childNameList.add("Horlicks");

        childListHolder.add(childNameList);

        childNameList = new ArrayList<>();
        childNameList.add("Knife");
        childNameList.add("Vessels");
        childNameList.add("Spoons");

        childListHolder.add(childNameList);

        ExpandableRecyclerViewAdapter expandableCategoryRecyclerViewAdapter = new ExpandableRecyclerViewAdapter(getContext(), parentList,childListHolder);

        crMainFragmentBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        crMainFragmentBinding.recyclerView.setAdapter(expandableCategoryRecyclerViewAdapter);
    }
}
