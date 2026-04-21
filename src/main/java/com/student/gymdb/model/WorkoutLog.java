package com.student.gymdb.model;

import java.sql.Date;

public class WorkoutLog {
    
    private int logID;
    private int memberID;
    private Date workoutDate;
    private String exerciseName;
    private int duration; // duration represented as minutes. 
    private int caloriesBurned;
    private String intensity;
    
    // Constructor
    public WorkoutLog() {
        
    }
    
    // All-arguments constructor
    public WorkoutLog(int logID, int memberID, Date workoutDate, String exerciseName, int duration, int caloriesBurned, String intensity) {
        this.logID = logID;
        this.memberID = memberID;
        this.workoutDate = workoutDate;
        this.exerciseName = exerciseName;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
        this.intensity = intensity;
    }
    
    // Setters and getters
    public int getLogID() { return logID; }
    public void setLogID(int logID) { this.logID = logID; }
    
    public int getMemberID() { return memberID; }
    public void setMemberID(int memberID) { this.memberID = memberID; }
    
    public Date getWorkoutDate() { return workoutDate; }
    public void setWorkoutDate(Date workoutDate) { this.workoutDate = workoutDate; }
    
    public String getExerciseName() { return exerciseName; }
    public void setExercisename(String exerciseName) { this.exerciseName = exerciseName; }
    
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
    
    public int getCaloriesBurned() { return caloriesBurned; }
    public void setCaloriesBurned(int caloriesBurned) { this.caloriesBurned = caloriesBurned; }
    
    public String getIntensity() { return intensity; }
    public void setIntensity(String intensity) { this.intensity = intensity; }
    
    // Same toString() override as in Members.java
    @Override
    public String toString() {
        return exerciseName + " for " + duration + " mins. (" + caloriesBurned + " cal)";
    }
}
