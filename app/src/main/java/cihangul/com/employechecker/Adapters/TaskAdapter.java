package cihangul.com.employechecker.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cihangul.com.employechecker.Models.Task;
import cihangul.com.employechecker.Models.ViewHolders.TaskViewholder;
import cihangul.com.employechecker.R;

/**
 * Created by cihan on 17.10.2017.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskViewholder>{

    Activity activity;
    List<Task> taskList;

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
    }

    @Override
    public TaskViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.task_card_admin,parent,false);

        /**
         *
         * @param view inflated card view
         *
         *
         * return new ViewHolder via param
         */

        return new TaskViewholder(view);
    }

    @Override
    public void onBindViewHolder(TaskViewholder holder, int position) {




    }

    @Override
    public int getItemCount() {
        /**
         *  return taskList.size
         */

        return taskList.size();
    }
}
