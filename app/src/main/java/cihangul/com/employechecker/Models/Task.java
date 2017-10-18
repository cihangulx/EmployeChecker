package cihangul.com.employechecker.Models;

import java.util.List;

/**
 * Created by cihan on 17.10.2017.
 */

public class Task {

    private String id;
    private String title;
    private Department department;
    private List<Step> stepList;
    private int progress;
    private String sure;
    private boolean isComplate;
    private int minAccess;

    public Task() {
    }

    public Task(String id, String title, Department department, List<Step> stepList, int progress, String sure, boolean isComplate, int minAccess) {
        this.id = id;
        this.title = title;
        this.department = department;
        this.stepList = stepList;
        this.progress = progress;
        this.sure = sure;
        this.isComplate = isComplate;
        this.minAccess = minAccess;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Step> getStepList() {
        return stepList;
    }

    public void setStepList(List<Step> stepList) {
        this.stepList = stepList;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getSure() {
        return sure;
    }

    public void setSure(String sure) {
        this.sure = sure;
    }

    public boolean isComplate() {
        return isComplate;
    }

    public void setComplate(boolean complate) {
        isComplate = complate;
    }

    public int getMinAccess() {
        return minAccess;
    }

    public void setMinAccess(int minAccess) {
        this.minAccess = minAccess;
    }
}
