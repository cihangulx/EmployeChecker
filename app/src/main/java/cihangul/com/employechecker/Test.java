package cihangul.com.employechecker;

import java.util.ArrayList;
import java.util.List;

import cihangul.com.employechecker.Models.Task;
import cihangul.com.employechecker.Models.User;

/**
 * Created by tuzlabim on 17.10.2017.
 */

public class Test {

    public static List<User> userList = new ArrayList<>();
    public static List<Task> taskList = new ArrayList<>();


    public static List<User> getUsers() {

        userList.add(new User());

        return userList;
    }

    public static List<Task> getTasks() {

        taskList.add(new Task("id","Uygulama Akış Şeması","Yazılım",null,90,"",false,40,"Mahmut Şeh"));
        taskList.add(new Task("id","Uygulama Akış Şeması","Yazılım",null,90,"",false,40,"Mahmut Şeh"));
        taskList.add(new Task("id","Uygulama Akış Şeması","Yazılım",null,90,"",false,40,"Mahmut Şeh"));
        taskList.add(new Task("id","Uygulama Akış Şeması","Yazılım",null,90,"",false,40,"Mahmut Şeh"));
        taskList.add(new Task("id","Uygulama Akış Şeması","Yazılım",null,90,"",false,40,"Mahmut Şeh"));
        taskList.add(new Task("id","Uygulama Akış Şeması","Yazılım",null,90,"",false,40,"Mahmut Şeh"));
        taskList.add(new Task("id","Uygulama Akış Şeması","Yazılım",null,90,"",false,40,"Mahmut Şeh"));
        taskList.add(new Task("id","Uygulama Akış Şeması","Yazılım",null,90,"",false,40,"Mahmut Şeh"));

        return taskList;
    }

}
