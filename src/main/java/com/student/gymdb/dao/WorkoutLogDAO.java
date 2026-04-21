package com.student.gymdb.dao;

import com.student.gymdb.model.WorkoutLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WorkoutLogDAO {
    
    public void insertWorkoutLog(WorkoutLog log) {
        String query = "INSERT INTO WorkoutLogTable (LogID, MemberID, WorkoutDate, ExerciseName, DurationMins, CaloriesBurned, Intensity) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, log.getLogID());
            pstmt.setInt(2, log.getMemberID());
            pstmt.setDate(3, log.getWorkoutDate());
            pstmt.setString(4, log.getExerciseName());
            pstmt.setInt(5, log.getDuration());
            pstmt.setInt(6, log.getCaloriesBurned());
            pstmt.setString(7, log.getIntensity());
            
            pstmt.executeUpdate();
            System.out.println(log.getExerciseName() + " log insertion successful");
        }
        catch (SQLException e) {
            System.err.println("FAILURE: Could not insert into log!");
            System.err.println(e.getMessage());
        }
    }
    
    //TODO: FInish backend log search and update logic
}
