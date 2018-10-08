package nl.tsbakker.recyclerviewexample;


import android.content.Context;

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
    public List<TeamObject> mDataset;
    private RecyclerViewClickListener mListener;

    TeamObjectAdapter(RecyclerViewClickListener listener) {
        mListener = listener;
    }

    public void updateData(List<TeamObject> dataset) {
        mDataset.clear();
        mDataset.addAll(dataset);
        notifyDataSetChanged();
    }

    @Override
    public TeamObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.grid_team, parent, false);
        return new TeamObjectViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(final TeamObjectViewHolder holder, final int position) {
        if (holder instanceof TeamObjectViewHolder) {
            TeamObjectViewHolder rowHolder = (TeamObjectViewHolder) holder;
            final TeamObject TeamObject = mDataset.get(position);
            holder.teamName.setText(TeamObject.getmTeamName());
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    // Remove an item from the RecyclerView
    public void deleteItem(int index) {
        mDataset.remove(index);
    }


}