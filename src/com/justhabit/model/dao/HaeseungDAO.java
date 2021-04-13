package com.justhabit.model.dao;

import static com.justhabit.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.justhabit.model.dto.HaeseungMonthTotalDTO;
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
				info.setUserID(rset.getInt("user_id"));
				info.setHabitID(rset.getInt("habit_id"));
				info.setHabitName(rset.getString("habit_name"));
				info.setHabitType(rset.getString("habit_type"));
				info.setHabitGoal(rset.getInt("habit_goal"));
				info.setHabitDays(rset.getString("habit_days"));
				
				
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
				selectRecord.setHabitId(rset.getInt("habit_id"));
				selectRecord.setDoDate(rset.getString("do_date"));
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
			pstmt.setInt(1, checkRecord.getUserId());
			pstmt.setInt(2, checkRecord.getHabitId());
			pstmt.setString(3, checkRecord.getDoDate());
			pstmt.setInt(4, checkRecord.getCheck());
			
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
			pstmt.setInt(1, checkRecord.getUserId());
			pstmt.setInt(2, checkRecord.getHabitId());
			pstmt.setString(3, checkRecord.getDoDate());
			pstmt.setDouble(4, checkRecord.getTimer());
			
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
	 * CHECK UPDATE
	 * </pre>
	 * @param con
	 * @param checkRecord
	 * @return
	 */
	public int updateCheckRecord(Connection con, HaeseungRecordDTO checkRecord) {
		
		PreparedStatement pstmt = null;
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
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * <pre>
	 * TIMER UPDATE
	 * </pre>
	 * @param con
	 * @param timerRecord
	 * @return
	 */
	public int updateTimerRecord(Connection con, HaeseungRecordDTO timerRecord) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("updateTimer");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDouble(1, timerRecord.getTimer()+0.0005);
			pstmt.setInt(2, timerRecord.getHabitId());
			pstmt.setString(3, timerRecord.getDoDate());
			
			
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * <pre>
	 * Timer습관 기록날짜 조회
	 * </pre>
	 * @param con
	 * @param timerRecord
	 * @return
	 */
	public HaeseungRecordDTO selectTimerDate(Connection con, HaeseungRecordDTO timerRecord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HaeseungRecordDTO selectRecord = null;
		
		String query = prop.getProperty("selectTimerDateInfo");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, timerRecord.getHabitId());
			pstmt.setString(2, timerRecord.getDoDate());
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				selectRecord = new HaeseungRecordDTO();
				selectRecord.setHabitId(rset.getInt("habit_id"));
				selectRecord.setDoDate(rset.getString("do_date"));
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
	 * 이번달 횟수기록 일수와 총갯수 조회
	 * </pre>
	 * @param con
	 * @param totalRecord
	 * @return
	 */
	public HaeseungMonthTotalDTO selectMonthTotal(Connection con, HaeseungMonthTotalDTO totalRecord) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectTotalCheck");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, totalRecord.getTodayMonth());
			pstmt.setInt(2, totalRecord.getHabitId());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				totalRecord = new HaeseungMonthTotalDTO();
				totalRecord.setDateCount(rset.getInt("COUNT(*)"));
				totalRecord.setRecordSum(rset.getInt("SUM(count_check)"));
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalRecord;
	}

	/**
	 * <pre>
	 *   월 총시간 출력을 위한 SELECT
	 * </pre>
	 * @param con
	 * @param totalRecord
	 * @return
	 */
	public HaeseungMonthTotalDTO selectMonthTimerTotal(Connection con, HaeseungMonthTotalDTO totalRecord) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectTotalTimerCheck");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, totalRecord.getTodayMonth());
			pstmt.setInt(2, totalRecord.getHabitId());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				totalRecord = new HaeseungMonthTotalDTO();
				totalRecord.setDateCount(rset.getInt("COUNT(*)"));
				totalRecord.setRecordSum(rset.getDouble("SUM(time_record)"));
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalRecord;
	}

	/**
	 * <pre>
	 * 목표와 기록 SELECT 
	 * </pre>
	 * @param con
	 * @param recordInfo
	 * @return
	 */
	public List<HaeseungRecordDTO> selectCheckRecordGoal(Connection con, HaeseungRecordDTO recordInfo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HaeseungRecordDTO row = null;
		List<HaeseungRecordDTO> userRecordGoalList = null;
		String query = prop.getProperty("selectCheckGoalRecord");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, recordInfo.getHabitId());
			rset = pstmt.executeQuery();
			
			userRecordGoalList = new ArrayList<HaeseungRecordDTO>();
			
			while(rset.next()) {
				row = new HaeseungRecordDTO();
				row.setDoDate(rset.getString("do_date"));
				row.setCheck(rset.getInt("count_check"));
				row.setHabitGoal(rset.getInt("habit_goal"));
				
				userRecordGoalList.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return userRecordGoalList;
	}

	public List<HaeseungRecordDTO> selectTimerRecordGoal(Connection con, HaeseungRecordDTO recordInfo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HaeseungRecordDTO row = null;
		List<HaeseungRecordDTO> userRecordGoalList = null;
		String query = prop.getProperty("selectTimerGoalRecord");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, recordInfo.getHabitId());
			rset = pstmt.executeQuery();
			
			userRecordGoalList = new ArrayList<HaeseungRecordDTO>();
			
			while(rset.next()) {
				row = new HaeseungRecordDTO();
				row.setDoDate(rset.getString("do_date"));
				row.setTimer(rset.getDouble("time_record"));
				row.setHabitGoal(rset.getInt("habit_goal"));
				
				userRecordGoalList.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return userRecordGoalList;
	}

	

	

}
