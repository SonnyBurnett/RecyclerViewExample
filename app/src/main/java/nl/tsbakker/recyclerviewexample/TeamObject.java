package nl.tsbakker.recyclerviewexample;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

//
// Name:    TeamObject
// Purpose: Handle the datamodel with room
// Author:  Taco Bakker
// Date:    14-10-2018
//


@Entity(tableName = "teamObject")
public class TeamObject implements Parcelable {


    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo (name = "TeamName")
    private String mTeamName;

    public String getTeamName() {
        return mTeamName;
    }

    public void setTeamName(String mTeamName) {
        this.mTeamName = mTeamName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public TeamObject(String mTeamName) {
        this.mTeamName = mTeamName;
    }

    @Override
    public String toString() {
        return mTeamName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.mTeamName);
    }

    protected TeamObject(Parcel in) {
        this.id = in.readLong();
        this.mTeamName = in.readString();
    }

    public static final Creator<TeamObject> CREATOR = new Creator<TeamObject>() {
        @Override
        public TeamObject createFromParcel(Parcel source) {
            return new TeamObject(source);
        }

        @Override
        public TeamObject[] newArray(int size) {
            return new TeamObject[size];
        }
    };
}