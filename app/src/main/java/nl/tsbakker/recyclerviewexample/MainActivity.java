package nl.tsbakker.recyclerviewexample;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//
// Name:    MainActivity
// Purpose: Explain Recyclerview with a very simple example
// Author:  Taco Bakker
// Date:    7-10-2018
//
//
// Note a RecyclerView is a view that is used when a lot of data needs to be displayed
// that will likely not fit the screen
// And you can have a list with more complex elements
// An excellent article can be found here: https://medium.com/@thomassimonini/recyclerview-made-easy-16bf2e261694
//


public class MainActivity extends AppCompatActivity {

    private TeamObjectAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private List<TeamObject> mTeamObjects;
    private EditText mNewTeamName;

    public final static int TASK_GET_ALL_TEAMOBJECTS = 0;
    public final static int TASK_DELETE_TEAMOBJECT = 1;
    public final static int TASK_UPDATE_TEAMOBJECT = 2;
    public final static int TASK_INSERT_TEAMOBJECT = 3;


    //final List<TeamObject> mTeamObjects = new ArrayList<>();

    static AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getInstance(this);

        mRecyclerView = findViewById(R.id.team_recyclerview);
        mTeamObjects = new ArrayList<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);

        updateUI();

        FloatingActionButton fab = findViewById(R.id.add_team_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //hier gaat iets niet goed
                String text = mNewTeamName.getText().toString();
                TeamObject newTeamObject = new TeamObject(text);
                if (!(TextUtils.isEmpty(text))) {
                    new TeamObjectAsyncTask(TASK_INSERT_TEAMOBJECT).execute(newTeamObject);
                    mNewTeamName.setText("");
                } else {
                    Snackbar.make(view, "Please enter some text in the textfield", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            }
        });

    }

    private void updateUI() {
        //mTeamObjects = db.teamObjectDao().getAllTeamObject();
        if (mAdapter == null) {
            mAdapter = new TeamObjectAdapter(this, mTeamObjects);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.swapList(mTeamObjects);
        }
    }

    public void onReminderDbUpdated(List list) {

        mTeamObjects = list;
        updateUI();

    }

    public class TeamObjectAsyncTask extends AsyncTask<TeamObject, Void, List> {

        private int taskCode;

        public TeamObjectAsyncTask(int taskCode) {
            this.taskCode = taskCode;
        }


        @Override
        protected List doInBackground(TeamObject... teamobjects) {
            switch (taskCode) {
                case TASK_DELETE_TEAMOBJECT:
                    db.teamObjectDao().deleteTeamObjects(teamobjects[0]);
                    break;

                case TASK_UPDATE_TEAMOBJECT:
                    db.teamObjectDao().updateTeamObjects(teamobjects[0]);
                    break;

                case TASK_INSERT_TEAMOBJECT:
                    db.teamObjectDao().insertTeamObjects(teamobjects[0]);
                    break;
            }


            //To return a new list with the updated data, we get all the data from the database again.
            return db.teamObjectDao().getAllTeamObject();
        }


        @Override
        protected void onPostExecute(List list) {
            super.onPostExecute(list);
            onReminderDbUpdated(list);
        }

    }

}
