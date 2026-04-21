package com.student.gymdb.dao;

import com.student.gymdb.model.WorkoutLog;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

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
    
    public List<WorkoutLog> getHighCalorieWorkouts() {
        List<WorkoutLog> logs = new ArrayList<>();
        String query = "SELECT * FROM WorkoutLogTable where CaloriesBurned > 500";
        
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                logs.add(new WorkoutLog(
                        rs.getInt("LogID"), rs.getInt("MemberID"), rs.getDate("WorkoutDate"), rs.getString("exercisename"),
                        rs.getInt("DurationMins"), rs.getInt("CaloriesBurned"), rs.getString("Intensity")
                ));
            }
        }
        catch (SQLException e) {
            System.err.println("FAILURE: Could not get high-calorie workouts!");
            System.err.println(e.getMessage());
        }
        
        return logs;
    }
    
    public List<WorkoutLog> getLogbyMemberID(int memberID) {
        List<WorkoutLog> logs = new ArrayList<>();
        String query = "SELECT * FROM WorkoutLogTable WHERE MemberID = ?";
        
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, memberID);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while(rs.next()) {
                    logs.add(new WorkoutLog(
                            rs.getInt("LogID"), rs.getInt("MemberID"), rs.getDate("WorkoutDate"), rs.getString("exercisename"),
                            rs.getInt("DurationMins"), rs.getInt("CaloriesBurned"), rs.getString("Intensity")
                    ));
                }
            }
        }
        catch (SQLException e) {
            System.err.println("FAILURE: could not get log by Member ID!");
            System.err.println(e.getMessage());
        }
        
        return logs;
    }
    
    public void updateWorkoutDuration(int logID, int duration) {
        String query = "UPDATE WorkoutLogTable SET DurationMins = ? WHERE LogID = ?";
        
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, duration);
            pstmt.setInt(2, logID);
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("SUCCESS: Duration changed for log " + logID);
            }
            else {
                System.out.println("No log entry found for LogID " + logID);
            }
        }
        catch (SQLException e) {
            System.err.println("FAILURE: Could not update log!");
            System.err.println(e.getMessage());
        }
    }
    
}
