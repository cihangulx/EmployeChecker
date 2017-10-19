package cihangul.com.employechecker.Models.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
    public View detailView;

    public TextView baslik;
    public TextView departman;
    public TextView sorumlu;
    public TextView gorevli;
    public Button progress;

    public TaskViewholder(View itemView) {
        super(itemView);
        view=itemView;
        detailView=itemView.findViewById(R.id.detail_view);

        baslik = view.findViewById(R.id.tv_gorev_basligi);
        departman =view.findViewById(R.id.tv_depatmam);
        sorumlu =view.findViewById(R.id.tv_sorumlu);
        gorevli =view.findViewById(R.id.tv_gorevli);
        progress =view.findViewById(R.id.bt_progress);

    }
}
