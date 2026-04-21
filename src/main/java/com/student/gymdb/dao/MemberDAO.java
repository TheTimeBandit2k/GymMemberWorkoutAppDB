package com.student.gymdb.dao;

import com.student.gymdb.model.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDAO {
    
    public void insertMember(Member member) {
        String query = "INSERT INTO MemberTable (MemberID, FullName, MembershipType, JoinDate, ExpiryDate, Phone, TrainerName) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, member.getMemberID());
            pstmt.setString(2, member.getFullname());
            pstmt.setString(3, member.getMembershipType());
            pstmt.setDate(4, member.getJoinDate());
            pstmt.setDate(5, member.getExpiryDate());
            pstmt.setString(6, member.getPhone());
            pstmt.setString(7, member.getTrainerName());
            
            pstmt.executeUpdate();
            System.out.println("Insert of " + member.getFullname() + " successful.");
        }
        catch (SQLException e) {
            System.err.println("FAILURE: Could not insert!");
            System.err.println(e.getMessage());
        }
        
        //TODO: Add remainder up update and deletion logic
    }
}
