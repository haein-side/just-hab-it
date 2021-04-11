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

import com.justhabit.model.dto.AllHabitDTO;

public class HaeinDAO {
	
	private Properties prop = new Properties();
	
	public HaeinDAO() {
		try {
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	public List<AllHabitDTO> selectAllHabitBy(Connection con, int userid) {
//
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		
//		List<AllHabitDTO> allhabitList = null;
//		
//		String query = prop.getProperty("selectAllHabit");
//		
//		
//			try {
//				pstmt = con.prepareStatement(query);
//				pstmt.setInt(1, userid);
//				
//				rset = pstmt.executeQuery();
//				
//				allhabitList = new ArrayList<>();
//				
//				while(rset.next()) {
//					
//					AllHabitDTO habit = new AllHabitDTO();
//					habit.setUserID(rset.getInt("USER_ID"));
//					habit.setHabitID(rset.getInt("HABIT_ID"));
//					habit.setHabitName(rset.getString("HABIT_NAME"));
//					
//					allhabitList.add(habit);
//					
//				}
//				
//						
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				close(rset);
//				close(pstmt);
//			}
//			
//			
//			
//		
//		
//		return allhabitList;
//	}

	public List<AllHabitDTO> selectAllHabitBy(Connection con, int loggedUserID) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<AllHabitDTO> allhabitList = null;
		
		String query = prop.getProperty("selectAllHabit");
		
		
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, loggedUserID);
				
				rset = pstmt.executeQuery();
				
				allhabitList = new ArrayList<>();
				
				while(rset.next()) {
					
					AllHabitDTO habit = new AllHabitDTO();
					habit.setHabitID(rset.getInt("HABIT_ID"));
					habit.setHabitName(rset.getString("HABIT_NAME"));
					habit.setHabitType(rset.getString("HABIT_TYPE"));
					habit.setHabitDays(rset.getString("HABIT_DAYS"));
					habit.setHabitGoal(rset.getInt("HABIT_GOAL"));
					allhabitList.add(habit);
					
				}
				
						
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			
			
		
		
		return allhabitList;
	}

}
