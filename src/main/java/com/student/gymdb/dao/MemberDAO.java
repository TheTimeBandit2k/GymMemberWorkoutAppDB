package com.student.gymdb.dao;

import com.student.gymdb.model.Member;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class MemberDAO {

    public void insertMember(Member member) {
        String query = "INSERT INTO MemberTable (MemberID, FullName, MembershipType, JoinDate, ExpiryDate, Phone, TrainerName) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, member.getMemberID());
            pstmt.setString(2, member.getFullname());
            pstmt.setString(3, member.getMembershipType());
            pstmt.setDate(4, member.getJoinDate());
            pstmt.setDate(5, member.getExpiryDate());
            pstmt.setString(6, member.getPhone());
            pstmt.setString(7, member.getTrainerName());

            pstmt.executeUpdate();
            System.out.println("Insert of " + member.getFullname() + " successful.");
        } catch (SQLException e) {
            System.err.println("FAILURE: Could not insert!");
            System.err.println(e.getMessage());
        }

        //TODO: Add remainder up update and deletion logic
    }

    public List<Member> getPremiumMembersExpiring() {
        List<Member> members = new ArrayList<>();

        // SQL logic to get the range of memberships expiring in 30 days
        String query = "SELECT * FROM MemberTable WHERE MembershipType = 'Premium' AND ExpiryDate BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                members.add(new Member(
                        rs.getInt("MemberID"), rs.getString("FullName"), rs.getString("MembershipType"),
                        rs.getDate("JoinDate"), rs.getDate("ExpiryDate"), rs.getString("Phone"), rs.getString("TrainerName")
                ));
            }

        } catch (SQLException e) {
            System.err.println("FAILURE: Could not fetch expiring members!");
            System.err.println(e.getMessage());
        }

        return members;
    }

    public List<Member> getMembersByTrainer(String trainerName) {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM MemberTable WHERE TrainerName = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, trainerName);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    members.add(new Member(
                            rs.getInt("MemberID"), rs.getString("FullName"), rs.getString("MembershipType"),
                            rs.getDate("JoinDate"), rs.getDate("ExpiryDate"), rs.getString("Phone"), rs.getString("TrainerName")
                    ));
                }
            }
        } catch (SQLException e) {
            System.err.println("FAILURE: Could not fetch members by trainer!");
            System.err.println(e.getMessage());
        }
        return members;
    }
    
    public void updateMembershipType(int memberID, String membershipType) {
        String query = "UPDATE MemberTable SET MembershipType = ? Where MemberID = ?";
        
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, membershipType);
            pstmt.setInt(2, memberID);
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0 ) {
                System.out.println("SUCCESS: Update complete for member ID " + memberID);
            }
            else {
                System.out.println("No member ID found for " + memberID);
            }
        }
        catch (SQLException  e) {
            System.err.println("FAILURE: Could not update membership type!");
            System.out.println(e.getMessage());
        }
    }
    
}
