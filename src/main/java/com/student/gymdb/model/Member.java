package com.student.gymdb.model;

import java.sql.Date;

public class Member {
    
    private int memberID;
    private String fullName;
    private String membershipType;
    private Date joinDate;
    private Date expiryDate;
    private String phone;
    private String trainerName;
    
    // Constructor
    public Member() {
        
    }
    
    // All-arguments constructor
    public Member(int memberID, String fullName, String membershipType, Date joinDate, Date expiryDate, String phone, String trainerName) {
        this.memberID = memberID;
        this.fullName = fullName;
        this.membershipType = membershipType;
        this.joinDate = joinDate;
        this.expiryDate = expiryDate;
        this.phone = phone;
        this.trainerName = trainerName;
    }
    
    // Setters and getters
    public int getMemberID() { return memberID; }
    public void setMemberID(int memberID) { this.memberID = memberID; }
    
    public String getFullname() { return fullName; }
    public void setFullname(String fullName) { this.fullName = fullName; }
    
    public String getMembershipType() { return membershipType; }
    public void setMembershipType(String membershipType) { this.membershipType = membershipType; }
    
    public Date getJoinDate() { return joinDate; }
    public void setJoinDate(Date joinDate) { this.joinDate = joinDate; }
    
    public Date getExpiryDate() { return expiryDate; }
    public void setExpiryDate(Date expiryDate) { this.expiryDate = expiryDate; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getTrainerName() { return trainerName; }
    public void setTrainername(String trainerName) { this.trainerName = trainerName; }
    
    // toString() override to make my debugging easier 
    @Override
    public String toString() {
        return "Member: " + fullName + " (" + membershipType + ") ";
    }
}
