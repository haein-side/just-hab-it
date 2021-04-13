package com.justhabit.model.dao;

import static com.justhabit.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.justhabit.model.dto.HabbitAddDTO;

public class HabbitAddDAO {
	
	private Properties prop = new Properties();
	
	public HabbitAddDAO() {
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/habit-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public List<HabbitAddDTO> insertAllHabbit(Connection con, String userID, int habitID, int habitDate,
			String habitType, String habitDays, int habitGoal) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		List<HabbitAddDTO> habbitAddList = null;
		
		String query = prop.getProperty("insertAllHabbit");
		
			
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, result);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	

}