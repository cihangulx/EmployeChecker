package cihangul.com.employechecker.Adapters;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cihangul.com.employechecker.MainActivity;
import cihangul.com.employechecker.Models.Task;
import cihangul.com.employechecker.Models.ViewHolders.TaskViewholder;
import cihangul.com.employechecker.R;

/**
 * Created by cihan on 17.10.2017.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskViewholder>{

    Activity activity;
    List<Task> taskList;
    public static int current =-1;
    int [] checked;
    /**
     *
     * @param activity current Context
     *
     *
     * @param taskList current content Task objects
     */
    public TaskAdapter(Activity activity, List<Task> taskList) {
        this.activity = activity;
        this.taskList = taskList;
        checked = new int[taskList.size()];
        for (int i=0;i<checked.length;i++){
            checked[i]=-1;
        }
    }

    @Override
    public TaskViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.task_card_admin,parent,false);

        /**
         *
         * @param view inflated card view
         *
         *
         * return new ViewHolder with view param
         */

        return new TaskViewholder(view);
    }

    @Override
    public void onBindViewHolder(final TaskViewholder holder, final int position) {

        holder.setIsRecyclable(false);
        /**
         * @param holder destination view
         * @param postion current object position. iti will be final referance
         * @param task current Task instance
         */

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                MainActivity mainActivity = (MainActivity) activity;
                mainActivity.visibleContextMenu(1);
                taskList.get(position).setComplate(true);
                if (taskList.get(position).isComplate()){
                    holder.itemView.setBackgroundColor(Color.parseColor("#C8E6C9"));
                    holder.progress.setBackgroundResource(R.drawable.progress_pressed);
                    checked[position] =1;
                }
                return false;
            }
        });


        Task task = taskList.get(position);

        if (task.isComplate()){
            holder.itemView.setBackgroundColor(Color.parseColor("#C8E6C9"));
            holder.progress.setBackgroundResource(R.drawable.progress_pressed);
        }

        holder.baslik.setText(task.getTitle());
        holder.departman.setText("Depatman: "+task.getDepartment());
        holder.sorumlu.setText("Sorumlu: "+task.getSorumlu());
        holder.progress.setText("%"+task.getProgress());

    }

    @Override
    public int getItemCount() {
        /**
         *  return taskList.size
         */

        return taskList.size();
    }

    public void delete(){
        for (int i =0;i<checked.length;i++){
            if (checked[i]!=-1){
                taskList.remove(i);
            }
        }
        for (int i=0;i<checked.length;i++){
            checked[i]=-1;
        }
    }
}
