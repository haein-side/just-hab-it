package com.justhabit.model.dao;

import static com.justhabit.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.justhabit.model.dto.HaeseungRecordDTO;
import com.justhabit.model.dto.HaesungInfoDTO;

public class HaeseungDAO {
	private Properties prop = new Properties();
	
	public HaeseungDAO() {
		try {
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public HaesungInfoDTO selectHabit(Connection con, int habitID) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		HaesungInfoDTO info = null;
		
		String query = prop.getProperty("selectHabitInfo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, habitID);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				info = new HaesungInfoDTO();
				info.setUserID(rset.getInt("USER_ID"));
				info.setHabitID(rset.getInt("HABIT_ID"));
				info.setHabitName(rset.getString("HABIT_NAME"));
				info.setHabitType(rset.getString("HABIT_TYPE"));
				info.setHabitGoal(rset.getInt("HABIT_GOAL"));
				info.setHabitDays(rset.getInt("HABIT_DAYS"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return info;
	}

	public int insertTimer(Connection con, HaeseungRecordDTO checkRecord) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertRecord");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, checkRecord.getCheck());
			pstmt.setString(2, checkRecord.getDoDate());
			pstmt.setInt(3, checkRecord.getUserId());
			pstmt.setInt(4, checkRecord.getHabitId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public String selectDate(Connection con, int habitId) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Date recodeDate = null;
		String date = "";
		
		String query = prop.getProperty("selectDateInfo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, habitId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				recodeDate = new Date();
				recodeDate = rset.getDate("DO_DATE");
				SimpleDateFormat recordDateFormat = new SimpleDateFormat("yy/MM/dd");
				date = recordDateFormat.format(recodeDate);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return date;
	}

	public int updateRecord(Connection con, HaeseungRecordDTO checkRecord) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("updateCheck");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, checkRecord.getCheck());
			pstmt.setInt(2, checkRecord.getHabitId());
			pstmt.setString(3, checkRecord.getDoDate());
			
			
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	

}
