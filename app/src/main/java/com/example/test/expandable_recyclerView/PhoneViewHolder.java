package com.example.test.expandable_recyclerView;

import android.view.View;
import android.widget.TextView;

import com.example.test.R;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class PhoneViewHolder extends ChildViewHolder {

    private TextView phoneName;

    public PhoneViewHolder(View itemView) {
        super(itemView);

        phoneName = (TextView) itemView.findViewById(R.id.phone_name);
    }

    public void onBind(Phone phone, ExpandableGroup group) {
        phoneName.setText(phone.getName());
        if (group.getTitle().equals("Android")) {
            //phoneName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.nexus, 0, 0, 0);
        } else if (group.getTitle().equals("iOS")) {
            //phoneName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.iphone, 0, 0, 0);
        } else {
            //phoneName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.window_phone, 0, 0, 0);
        }
    }
}