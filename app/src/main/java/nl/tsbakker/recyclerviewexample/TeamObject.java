package nl.tsbakker.recyclerviewexample;

public class TeamObject {

//
// Name:    TeamObject
// Purpose: Handle the datamodel
// Author:  Taco Bakker
// Date:    7-10-2018
//


    private String mTeamName;
    private String mTeamLocation;


    public TeamObject(String mTeamName, String mTeamLocation) {
        this.mTeamName = mTeamName;
        this.mTeamLocation = mTeamLocation;
    }

    public String getmTeamName() {
        return mTeamName;
    }

    public void setmTeamName(String mTeamName) {
        this.mTeamName = mTeamName;
    }

    public String getmTeamLocation() {
        return mTeamLocation;
    }

    public void setmTeamLocation(String mTeam) {
        this.mTeamLocation = mTeamLocation;
    }

    //
    // Specify some initial values
    // That can be used to create new objects
    //

    public static final String[] PRE_DEFINED_TEAM_OBJECT_NAMES = {
            "Ajax",
            "PSV",
            "AZ",
            "PEC"
    };

    public static final String[] PRE_DEFINED_TEAM_OBJECT_LOCATIONS = {
            "Amsterdam",
            "Eindhoven",
            "Alkmaar",
            "Zwolle"
    };


}