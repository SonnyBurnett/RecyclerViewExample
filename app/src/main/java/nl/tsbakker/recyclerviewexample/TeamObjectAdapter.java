package nl.tsbakker.recyclerviewexample;


import android.content.Context;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class TeamObjectAdapter extends RecyclerView.Adapter<TeamObjectViewHolder> {

//
// Name:    TeamObjectAdapter
// Purpose: Handle the Adpter, which means connect the datamodel to the Reccycleview
//          Connection to the Recyclerview is done via the ViewHolder.
//          The Adapter is called to create new items (in the form of ViewHolders).
//          Provides the viewholders with data.
//          Returns information about data (how many items…).
// Author:  Taco Bakker
// Date:    7-10-2018
//

    private Context context;
    public List<TeamObject> listTeamObject;


    //
    // Constructor
    //
    public TeamObjectAdapter(Context context, List<TeamObject> listTeamObject) {
        this.context = context;
        this.listTeamObject = listTeamObject;

    }

    // onCreateViewHolder
    // called when the RecyclerView instantiates a new ViewHolder instance
    // (inflates the items view from xml → creates them in code → return a new ViewHolder object).
    @Override
    public TeamObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_team, parent, false);
        return new TeamObjectViewHolder(view);
    }


    // onBindViewHolder:
    // called when RecyclerView wants to populate the view with data from our model so that the user can see it.


    @Override
    public void onBindViewHolder(final TeamObjectViewHolder holder, int position) {
        // Gets a single item in the list from its position
        TeamObject TeamObject = listTeamObject.get(position);
        // The holder argument is used to reference the views inside the viewHolder
        // Populate the views with the data from the list
        holder.teamName.setText(TeamObject.getTeamName());
    }

    @Override
    public int getItemCount() {
        return listTeamObject.size();
    }

    public void swapList (List<TeamObject> newList) {
        listTeamObject = newList;
        if (newList != null) {
            // Force the RecyclerView to refresh
            this.notifyDataSetChanged();
        }

    }

}