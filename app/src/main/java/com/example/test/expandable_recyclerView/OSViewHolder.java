package com.example.test.expandable_recyclerView;

import android.view.View;
import android.widget.TextView;

import com.example.test.R;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class OSViewHolder extends GroupViewHolder {

    private TextView osName;

    public OSViewHolder(View itemView) {
        super(itemView);

        osName = (TextView) itemView.findViewById(R.id.mobile_os);
    }

    @Override
    public void expand() {
        osName.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_down, 0);
        //Log.i("Adapter", "expand");
    }

    @Override
    public void collapse() {
        //Log.i("Adapter", "collapse");
        osName.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_up, 0);
    }

    public void setGroupName(ExpandableGroup group) {
        osName.setText(group.getTitle());
    }
}