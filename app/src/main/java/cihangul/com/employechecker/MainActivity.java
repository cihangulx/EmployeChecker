package cihangul.com.employechecker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.List;

import cihangul.com.employechecker.Adapters.TaskAdapter;
import cihangul.com.employechecker.Adapters.UserController;
import cihangul.com.employechecker.Models.Task;
import cihangul.com.employechecker.Models.User;
import cihangul.com.employechecker.Network.Db;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /**
     *
     * @param recyclerView main content viewer
     *
     */
    private RecyclerView recyclerView;
    //
    RelativeLayout contextMenu;
    TaskAdapter taskAdapter;
    Button done;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_toggle);

        recyclerView =findViewById(R.id.recycler_view);

        contextMenu=(RelativeLayout)findViewById(R.id.context_menu);
        done = findViewById(R.id.done);
        delete = findViewById(R.id.delete);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                visibleContextMenu(0);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                   TaskAdapter adapter=(TaskAdapter)recyclerView.getAdapter();
                    adapter.delete();
                    recyclerView.getAdapter().notifyDataSetChanged();
                }catch (Exception e){

                }

            }
        });

        testCard();
        /**
         * if isAdmin return true -> listActive task
         *
         * else -> list current user tasks
         *
         */
     /*   if (isAdmin()) {
            listActiveTasks();
        } else {
            listMyTask();
        }*/



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(false);

        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void listMyTask() {
        /**
         * @param user current user
         * @param call it will return task list
         */
        User user = UserController.getInstance().getCurrentUser();

        Call<List<Task>> call = Db.getConnect().listTask(user);
        call.enqueue(new Callback<List<Task>>() {
            @Override
            public void onResponse(Call<List<Task>> call, Response<List<Task>> response) {
                if (response.code() == 200) {
                    /**
                     * connection success and list can use
                     *
                     * @param taskList  Task Objects
                     * @param linearLayoutManager task view inserter
                     */
                    List<Task> taskList = response.body();

                    taskAdapter = new TaskAdapter(MainActivity.this, taskList);

                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);

                    /*
                     * set layout manager and adapter for recyclerView
                     *
                     */
                    //
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(taskAdapter);
                    //


                } else {

                    /**
                     *
                     * task not found create AlertDialog
                     *
                     */

                }
            }

            @Override
            public void onFailure(Call<List<Task>> call, Throwable t) {
                /**
                 *
                 * Connection failed log(t.getMessage())
                 *
                 * or
                 *
                 * parsing  error log(t.getMessage())
                 *
                 *
                 */
                Log.e("onFailure()",t.getMessage());
            }
        });


    }


    private void listActiveTasks() {
        /**
         * @param user current user
         * @param call it will return task list
         */
        User user = UserController.getInstance().getCurrentUser();

        Call<List<Task>> call = Db.getConnect().listTask(user);
        call.enqueue(new Callback<List<Task>>() {
            @Override
            public void onResponse(Call<List<Task>> call, Response<List<Task>> response) {
                if (response.code() == 200) {
                    /**
                     * connection success and list can use
                     *
                     * @param taskList  Task Objects
                     * @param linearLayoutManager task view inserter
                     */
                    List<Task> taskList = response.body();

                     taskAdapter = new TaskAdapter(MainActivity.this, taskList);

                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);

                    /*
                     * set layout manager and adapter for recyclerView
                     *
                     */
                    //
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(taskAdapter);
                    //


                } else {

                    /**
                     *
                     * task not found create AlertDialog
                     *
                     */

                }
            }

            @Override
            public void onFailure(Call<List<Task>> call, Throwable t) {
                /**
                 *
                 * Connection failed log(t.getMessage())
                 *
                 * or
                 *
                 * parsing  error log(t.getMessage())
                 *
                 *
                 */
                Log.e("onFailure()",t.getMessage());
            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    /**
     *
     * if current user is an Admin return true else return false
     *
     * @return
     */
    private boolean isAdmin() {
        try {
            UserController controller = UserController.getInstance();

            if (controller.getCurrentUser().getAccess() == S.ADMİN) {
                /**
                 * current user is an Admin return true
                 *
                 */

                return true;
            } else {
                /**
                 * current user is not admin return false
                 */
                return false;
            }
        } catch (NullPointerException e) {
            /**
             * if controller a null object referrance log(e)
             */
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            /**
             * another error
             *
             * log(e)
             */
            e.printStackTrace();
            return false;
        }
    }
    public void testCard(){
        List<Task> taskList = Test.getTasks();

        TaskAdapter taskAdapter = new TaskAdapter(MainActivity.this, taskList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);

                    /*
                     * set layout manager and adapter for recyclerView
                     *
                     */
        //
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(taskAdapter);


    }
    public void visibleContextMenu(int i){
        if (i==0){
            contextMenu.setVisibility(View.GONE);
        }else {
            contextMenu.setVisibility(View.VISIBLE);
        }
    }
}
