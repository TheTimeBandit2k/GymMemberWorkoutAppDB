package com.student.gymdb.utils;

import com.student.gymdb.dao.MemberDAO;
import com.student.gymdb.dao.WorkoutLogDAO;
import com.student.gymdb.model.Member;
import com.student.gymdb.model.WorkoutLog;
import java.util.List;
import java.sql.Date;


public class DatabaseSeeder {
    
    public static void main (String[] args) {
        MemberDAO mDAO = new MemberDAO();
        WorkoutLogDAO wDAO = new WorkoutLogDAO();
        
        System.out.println("Database insertion started...");
        
         Member[] members = {
            new Member(820, "Alice Smith", "Basic", Date.valueOf("2025-01-15"), Date.valueOf("2026-12-31"), "555-0101", "John"),
            new Member(821, "Bob Jones", "Premium", Date.valueOf("2025-06-01"), Date.valueOf("2026-05-10"), "555-0102", "Sarah"), // Expiring < 30 days
            new Member(822, "Charlie Brown", "Annual", Date.valueOf("2026-01-01"), Date.valueOf("2027-01-01"), "555-0103", "John"),
            new Member(823, "Diana Prince", "Premium", Date.valueOf("2024-11-20"), Date.valueOf("2026-04-28"), "555-0104", "Mike"), // Expiring < 30 days
            new Member(824, "Evan Wright", "Basic", Date.valueOf("2026-02-14"), Date.valueOf("2027-02-14"), "555-0105", "Sarah"),
            new Member(825, "Fiona Gallagher", "Annual", Date.valueOf("2023-08-10"), Date.valueOf("2026-08-10"), "555-0106", "John"),
            new Member(826, "George Miller", "Premium", Date.valueOf("2025-09-01"), Date.valueOf("2026-09-01"), "555-0107", "Mike"),
            new Member(827, "Hannah Abbott", "Basic", Date.valueOf("2026-03-05"), Date.valueOf("2027-03-05"), "555-0108", "Sarah"),
            new Member(828, "Ian Malcolm", "Annual", Date.valueOf("2022-05-12"), Date.valueOf("2027-05-12"), "555-0109", "John"),
            new Member(829, "Julia Roberts", "Premium", Date.valueOf("2025-12-01"), Date.valueOf("2026-12-01"), "555-0110", "Mike")
        };
         
         for (Member m : members) {
             mDAO.insertMember(m);
         }
         
         WorkoutLog[] logs = {
            new WorkoutLog(1, 820, Date.valueOf("2026-04-18"), "Treadmill", 45, 400, "Medium"),
            new WorkoutLog(2, 820, Date.valueOf("2026-04-19"), "Weightlifting", 60, 550, "High"), // > 500 Calories
            new WorkoutLog(3, 821, Date.valueOf("2026-04-15"), "Cycling", 30, 300, "Low"),
            new WorkoutLog(4, 822, Date.valueOf("2026-04-20"), "Rowing", 50, 600, "High"), // > 500 Calories
            new WorkoutLog(5, 823, Date.valueOf("2026-04-10"), "Yoga", 60, 200, "Low"),
            new WorkoutLog(6, 824, Date.valueOf("2026-04-12"), "Elliptical", 40, 450, "Medium"),
            new WorkoutLog(7, 825, Date.valueOf("2026-04-16"), "HIIT", 30, 520, "High"), // > 500 Calories
            new WorkoutLog(8, 826, Date.valueOf("2026-04-17"), "Stairmaster", 20, 250, "Medium"),
            new WorkoutLog(9, 827, Date.valueOf("2026-04-14"), "Swimming", 45, 480, "High"),
            new WorkoutLog(10, 828, Date.valueOf("2026-04-19"), "Treadmill", 60, 650, "High") // > 500 Calories
        };
         
         for (WorkoutLog w : logs) {
             wDAO.insertWorkoutLog(w);
         }
         
         System.out.println("Seeding complete.");
         
         
         // Logic Testing
         MemberDAO memDAO = new MemberDAO();
         WorkoutLogDAO logDAO = new WorkoutLogDAO();
         
         System.out.println("Case 1");
         List<Member> expiringSoon = memDAO.getPremiumMembersExpiring();
         
         for (Member m : expiringSoon) {
             System.out.println(m.toString());
         }
         
         System.out.println("Case 2");
         List<WorkoutLog> hardWorkouts = logDAO.getHighCalorieWorkouts();
         
         for (WorkoutLog log : hardWorkouts) {
             System.out.println(log.toString());
         }
         
         System.out.println("Case 3");
         List<WorkoutLog> retrievedLogs = logDAO.getLogbyMemberID(820);
         
         for (WorkoutLog log : retrievedLogs) {
             System.out.println(log.toString());
         }
         
         System.out.println("Case 4");
         List<Member> byTrainer = mDAO.getMembersByTrainer("John");
         
         for (Member m : byTrainer) {
             System.out.println(m.toString());
         }
         
         System.out.println("Case 5");
         mDAO.updateMembershipType(820, "Premium");
         
         System.out.println("Case 6");
         logDAO.updateWorkoutDuration(1, 60);
    }
}
