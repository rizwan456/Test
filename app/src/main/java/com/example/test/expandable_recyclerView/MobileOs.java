package com.example.test.expandable_recyclerView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class MobileOs extends ExpandableGroup<Phone> {
    public MobileOs(String title, List<Phone> items) {
        super(title, items);
    }
}
