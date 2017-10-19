
package cihangul.com.employechecker.Models;

/**
 * Created by cihan on 17.10.2017.
 */

public class Department {

    private String id;
    private String title;
    private String root;
    private String image;

    public Department() {
    }

    public Department(String id, String title, String root, String image) {
        this.id = id;
        this.title = title;
        this.root = root;
        this.image = image;
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

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
