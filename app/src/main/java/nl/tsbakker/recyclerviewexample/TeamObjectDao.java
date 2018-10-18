package nl.tsbakker.recyclerviewexample;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TeamObjectDao {

    @Query("SELECT * FROM teamObject")
    public List<TeamObject> getAllTeamObject();

    @Insert
    public void insertTeamObjects(TeamObject teams);

    @Delete
    public void deleteTeamObjects(TeamObject teams);

    @Update
    public void updateTeamObjects(TeamObject teams);

}
