package com.anil.imcs.multithreading.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.anil.imcs.multithreading.bean.PropertyInfo;


public class FileDBService {

	public Boolean addIntoDB(PropertyInfo info) throws SQLException {
		Connection connection = getDbConnection();
		String sql = "Insert into property(property_id, property_name, property_address, amount, filing_date) values(?, ?, ?, ?, ?)";
		PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		stmt.setInt(1, info.getPropertyId());
		stmt.setString(2, info.getPropertyName());
		stmt.setString(3, info.getPropertyAddress());
		stmt.setDouble(4, info.getTaxAmount());
		stmt.setDate(5, Date.valueOf(info.getFilingDate()));
		
		return stmt.execute();
	}

	private Connection getDbConnection() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/propertyinfo", "root", "admin");
		return conn;
	}
	

}
