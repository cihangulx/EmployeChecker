package cihangul.com.employechecker.Models;

/**
 * Created by cihan on 18.10.2017.
 */

public class Step {

    private String id;
    private String title;
    private int progress;
    private boolean isComplate;

    public Step() {
    }

    public Step(String id, String title, int progress, boolean isComplate) {
        this.id = id;
        this.title = title;
        this.progress = progress;
        this.isComplate = isComplate;
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

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public boolean isComplate() {
        return isComplate;
    }

    public void setComplate(boolean complate) {
        isComplate = complate;
    }
}
