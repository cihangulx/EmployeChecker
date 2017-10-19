package cihangul.com.employechecker.Models.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import cihangul.com.employechecker.R;

/**
 * Created by cihan on 17.10.2017.
 */

public class TaskViewholder extends RecyclerView.ViewHolder{
    /**
     * @param view will be CardView
     * @param detailView will be hidden
     */
    View view;
    View detailView;
    public TaskViewholder(View itemView) {
        super(itemView);
        view=itemView;
        detailView=itemView.findViewById(R.id.detail_view);
    }
}
