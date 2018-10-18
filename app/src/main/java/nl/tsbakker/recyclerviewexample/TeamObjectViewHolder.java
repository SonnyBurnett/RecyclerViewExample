package nl.tsbakker.recyclerviewexample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//
// Name:    TeamObjectViewHolder
// Purpose: Handle the viewholder, which means translate the layout of the object in the Contentview to the Recycleview
//          It is the very object that represents each item in our collection and will be used to display it.
//          In other words: Used to provide the RecyclerView with new views when needed.
//          For example when scrolling
// Author:  Taco Bakker
// Date:    7-10-2018
//

public class TeamObjectViewHolder extends RecyclerView.ViewHolder {


    public TextView teamName;
    public TextView teamLocation;
    public View view;


    TeamObjectViewHolder(View v) {
        super(v);
        teamName = itemView.findViewById(R.id.team_name);
        view = v;
    }


}
