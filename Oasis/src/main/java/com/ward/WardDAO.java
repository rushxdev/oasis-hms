package com.ward;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import oasisdb.DBConnection;

public class WardDAO {
	
	public void insertWard(Ward ward) {
		
		String sql = "INSERT INTO wards(name, number_of_beds, department) VALUES (?, ?, ?)";
		
		try(Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, ward.getName());
			stmt.setInt(2, ward.getNumberOfBeds());
			stmt.setString(3, ward.getDepartment());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Ward> getAllWards() {
		
		List<Ward> wards = new ArrayList<>();
		
		String sql = "SELECT * FROM wards";
		
		try(Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Ward ward = new Ward(rs.getInt("ward_id"), rs.getString("name"), rs.getInt("number_of_beds"), rs.getString("department"));
				wards.add(ward);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return wards;
	
	}
	
	public Ward getWardById(int wardId) {
		
		Ward ward = null;
		
		String sql = "SELECT * FROM wards WHERE ward_id = ?";
		
		try(Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, wardId);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				ward = new Ward(rs.getInt("ward_id"), rs.getString("name"), rs.getInt("number_of_beds"), rs.getString("department"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ward;
	}
	
	public void updateWard(Ward ward) {
		
		String sql = "UPDATE wards SET name = ?, number_of_beds = ?, department = ? WHERE ward_id = ?";
		
		try(Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, ward.getName());
			stmt.setInt(2, ward.getNumberOfBeds());
			stmt.setString(3, ward.getDepartment());
			stmt.setInt(4, ward.getWardId());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteWard(int wardId) {
		
		String sql = "DELETE FROM wards WHERE ward_id =?";
		
		try(Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, wardId);
			stmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
