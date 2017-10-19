package cihangul.com.employechecker.Network;

import java.util.List;

import cihangul.com.employechecker.Models.Task;
import cihangul.com.employechecker.Models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by cihan on 17.10.2017.
 */

public interface Connect {

    /**
     *
     * @param user -> User required
     * @return List<Task>
     *
     * @param user alternatively can be sha256 token
     *
     * @desc Only admin can see task current task list
     */

    @POST("listTask")
    Call<List<Task>> listTask(@Body User user);

    /**
     *
     * @param user -> current user except Admin
     * @return current user tasks
     */
    @POST("listMyTask")
    Call<List<Task>> listMyTask(@Body User user);


}
