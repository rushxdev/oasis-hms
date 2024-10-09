package com.ward;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oasisdb.DBConnection;

public class WardDAO {
	
	public static List<Ward> getAllWards() {
		
		List<Ward> wards = new ArrayList<>();
		
		try(Connection conn = DBConnection.getConnection()){
			
			String sql = "SELECT * FROM Wards";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				wards.add(new Ward(rs.getInt("ward_id"), rs.getString("name"), rs.getInt("no_of_beds"), 
                        rs.getString("department"), rs.getString("nurse_in_charge")));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return wards;
		
	}
	
	public static void addWard(Ward ward) {
		
		try(Connection conn = DBConnection.getConnection()) {
			String sql = "INSERT INTO Wards (name, no_of_beds, department, nurse_in_charge) VALUES (?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, ward.getName());
            stmt.setInt(2, ward.getNoOfBeds());
            stmt.setString(3, ward.getDepartment());
            stmt.setString(4, ward.getNurseInCharge());
            stmt.executeUpdate();
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void updateWard(Ward ward) {
		
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE Wards SET name = ?, no_of_beds = ?, department = ?, nurse_in_charge = ? WHERE ward_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, ward.getName());
            stmt.setInt(2, ward.getNoOfBeds());
            stmt.setString(3, ward.getDepartment());
            stmt.setString(4, ward.getNurseInCharge());
            stmt.setInt(5, ward.getWardId());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public static void deleteWard(int wardId) {
		
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM Wards WHERE ward_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, wardId);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
