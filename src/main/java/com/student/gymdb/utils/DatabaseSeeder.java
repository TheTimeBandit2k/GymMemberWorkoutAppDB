package com.student.gymdb.utils;

import com.student.gymdb.dao.MemberDAO;
import com.student.gymdb.dao.WorkoutLogDAO;
import com.student.gymdb.model.Member;
import com.student.gymdb.model.WorkoutLog;
import java.sql.Date;


public class DatabaseSeeder {
    
    public static void main (String[] args) {
        MemberDAO mDAO = new MemberDAO();
        WorkoutLogDAO wDAO = new WorkoutLogDAO();
        
        System.out.println("Database insertion started...");
        
         Member[] members = {
            new Member(1, "Dwayne Johnson", "Annual", Date.valueOf("2023-01-01"), Date.valueOf("2027-12-31"), "555-1111", "Arnold"),
            new Member(2, "Chris Hemsworth", "Premium", Date.valueOf("2024-02-15"), Date.valueOf("2026-05-10"), "555-2222", "Phil Heath"),
            new Member(3, "Gal Gadot", "Basic", Date.valueOf("2024-03-01"), Date.valueOf("2027-04-01"), "555-3333", "Self"),
            new Member(4, "Henry Cavill", "Annual", Date.valueOf("2024-01-10"), Date.valueOf("2027-01-09"), "555-4444", "Arnold"),
            new Member(5, "Brie Larson", "Premium", Date.valueOf("2024-05-01"), Date.valueOf("2026-05-05"), "555-5555", "Phil Heath"),
            new Member(6, "Alice Smith", "Basic", Date.valueOf("2025-01-15"), Date.valueOf("2026-12-31"), "555-0101", "John"),
            new Member(7, "Bob Jones", "Premium", Date.valueOf("2025-06-01"), Date.valueOf("2026-05-15"), "555-0102", "Sarah"),
            new Member(8, "Charlie Brown", "Annual", Date.valueOf("2026-01-01"), Date.valueOf("2027-01-01"), "555-0103", "John"),
            new Member(9, "Diana Prince", "Premium", Date.valueOf("2024-11-20"), Date.valueOf("2027-04-28"), "555-0104", "Mike"),
            new Member(10, "Evan Wright", "Basic", Date.valueOf("2026-02-14"), Date.valueOf("2027-02-14"), "555-0105", "Sarah")
        };
         
         for (Member m : members) {
             mDAO.insertMember(m);
         }
         
         WorkoutLog[] logs = {
            new WorkoutLog(101, 1, Date.valueOf("2026-04-10"), "Deadlift", 60, 500, "High"),
            new WorkoutLog(102, 2, Date.valueOf("2026-04-10"), "Shoulder Press", 45, 350, "Medium"),
            new WorkoutLog(103, 3, Date.valueOf("2026-04-11"), "Yoga", 30, 150, "Low"),
            new WorkoutLog(104, 4, Date.valueOf("2026-04-11"), "Squats", 50, 450, "High"),
            new WorkoutLog(105, 5, Date.valueOf("2026-04-12"), "Running", 40, 400, "Medium"),
            new WorkoutLog(106, 6, Date.valueOf("2026-04-18"), "Treadmill", 45, 400, "Medium"),
            new WorkoutLog(107, 7, Date.valueOf("2026-04-19"), "Weightlifting", 60, 550, "High"), 
            new WorkoutLog(108, 8, Date.valueOf("2026-04-15"), "Cycling", 30, 300, "Low"),
            new WorkoutLog(109, 9, Date.valueOf("2026-04-20"), "Rowing", 50, 600, "High"), 
            new WorkoutLog(110, 10, Date.valueOf("2026-04-10"), "Yoga", 60, 200, "Low")
        };
         
         for (WorkoutLog w : logs) {
             wDAO.insertWorkoutLog(w);
         }
         
         System.out.println("Seeding complete.");
         
    }
}
