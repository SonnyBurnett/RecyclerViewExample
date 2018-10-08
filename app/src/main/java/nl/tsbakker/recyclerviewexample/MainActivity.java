package nl.tsbakker.recyclerviewexample;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//
// Name:    MainActivity
// Purpose: Handle the MainActivity
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

    public RecyclerView recyclerView;
    public TeamObjectAdapter mAdapter;
    final List<TeamObject> mTeamObjects = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTeamObjects.add(new TeamObject("Ajax","Amsterdam"));
        mTeamObjects.add(new TeamObject("AZ","Alkmaar"));

        recyclerView = findViewById(R.id.team_recyclerview);

        RecyclerViewClickListener listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {

            }
        };

        mAdapter = new TeamObjectAdapter(listener);
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

    }
}
