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

	/**
	 * <pre>
	 * 습관정보조회
	 * </pre>
	 * @param con
	 * @param registInfo
	 * @return
	 */
	public HaesungInfoDTO selectHabit(Connection con, HaesungInfoDTO registInfo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		HaesungInfoDTO info = null;
		
		String query = prop.getProperty("selectHabitInfo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, registInfo.getHabitID());
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
	
	/**
	 * <pre>
	 * 날짜조회
	 * </pre>
	 * 
	 * @param con
	 * @param recordInfo
	 * @return
	 */
	public HaeseungRecordDTO selectDate(Connection con, HaeseungRecordDTO recordInfo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HaeseungRecordDTO selectRecord = null;
		
		String query = prop.getProperty("selectDateInfo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, recordInfo.getHabitId());
			pstmt.setString(2, recordInfo.getDoDate());
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				selectRecord = new HaeseungRecordDTO();
				selectRecord.setHabitId(rset.getInt("HABIT_ID"));
				selectRecord.setDoDate(rset.getString("DO_DATE"));
			} 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return selectRecord;
	}

	/**
	 * <pre>
	 * CHECK INSERT
	 * </pre>
	 * @param con
	 * @param checkRecord
	 * @return
	 */
	public int insertCheck(Connection con, HaeseungRecordDTO checkRecord) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertCheck");
		
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

	
	/**
	 * <pre>
	 * Timer INSERT
	 * </pre>
	 * @param con
	 * @param checkRecord
	 * @return
	 */
	public int insertTimer(Connection con, HaeseungRecordDTO checkRecord) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertTimer");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, checkRecord.getTimer());
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
