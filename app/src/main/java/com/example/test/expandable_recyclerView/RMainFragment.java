package com.example.test.expandable_recyclerView;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.R;
import com.example.test.databinding.RMainFragmentBinding;

import java.util.ArrayList;

public class RMainFragment extends Fragment {
    RMainFragmentBinding rMainFragmentBinding;
    public static ArrayList<MobileOs> mobileOSes;
    public static RecyclerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rMainFragmentBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_rmain,container,false);
        mobileOSes = new ArrayList<>();

        setData();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rMainFragmentBinding.recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter(getActivity(), mobileOSes);
        rMainFragmentBinding.recyclerView.setAdapter(adapter);

        return rMainFragmentBinding.getRoot();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        adapter.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        adapter.onRestoreInstanceState(savedInstanceState);
    }

    public static void setData() {
        ArrayList<Phone> iphones = new ArrayList<>();
        iphones.add(new Phone("iPhone 4"));
        iphones.add(new Phone("iPhone 4S"));
        iphones.add(new Phone("iPhone 5"));
        iphones.add(new Phone("iPhone 5S"));
        iphones.add(new Phone("iPhone 6"));
        iphones.add(new Phone("iPhone 6Plus"));
        iphones.add(new Phone("iPhone 6S"));
        iphones.add(new Phone("iPhone 6S Plus"));

        ArrayList<Phone> nexus = new ArrayList<>();
        nexus.add(new Phone("Nexus One"));
        nexus.add(new Phone("Nexus S"));
        nexus.add(new Phone("Nexus 4"));
        nexus.add(new Phone("Nexus 5"));
        nexus.add(new Phone("Nexus 6"));
        nexus.add(new Phone("Nexus 5X"));
        nexus.add(new Phone("Nexus 6P"));
        nexus.add(new Phone("Nexus 7"));

        ArrayList<Phone> windowPhones = new ArrayList<>();
        windowPhones.add(new Phone("Nokia Lumia 800"));
        windowPhones.add(new Phone("Nokia Lumia 710"));
        windowPhones.add(new Phone("Nokia Lumia 900"));
        windowPhones.add(new Phone("Nokia Lumia 610"));
        windowPhones.add(new Phone("Nokia Lumia 510"));
        windowPhones.add(new Phone("Nokia Lumia 820"));
        windowPhones.add(new Phone("Nokia Lumia 920"));

        mobileOSes.add(new MobileOs("iOS", iphones));
        mobileOSes.add(new MobileOs("Android", nexus));
        mobileOSes.add(new MobileOs("Window Phone", windowPhones));
    }

}
