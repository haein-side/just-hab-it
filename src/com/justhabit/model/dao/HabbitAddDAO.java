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
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	public static int selectAllHabbit(List<HabbitAddDTO> allhabitList, Connection con) {
//
//		PreparedStatement pstmt = null;
//		int result = 0;
//		
//		String query = prop.getProperty("insertAllHabbit");
//		
//		try {
//			pstmt = con.prepareStatement(query);
//			pstmt.setInt(1, allhabitList.get(0));
//			pstmt.set
//			pstmt.setInt(3, ((HabbitAddDTO)allhabitList).gethabitID());
//			pstmt.setString(2, ((HabbitAddDTO) allhabitList).gethabitName());
//			pstmt.setString(4, ((HabbitAddDTO)allhabitList).gethabitType());
//			pstmt.setString(5, ((HabbitAddDTO)allhabitList).getHABIT_DAYS());
//			pstmt.setString(6, ((HabbitAddDTO)allhabitList).getHABIT_GOAL());
//			
//			result = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		
//		return result;
//	}
//
//	public static int insertAllHabbit(List<HabbitAddDTO> allhabitList, Connection con) {
//		
//		return 0;
//	}

	public List<HabbitAddDTO> insertAllHabbit(Connection con, String userID, int habitID, int habitDate,
			String habitType, String habitDays, int habitGoal) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<HabbitAddDTO> habbitAddList = null;
		
		String query = prop.getProperty("insertAllHabbit");
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			habbitAddList = new ArrayList<HabbitAddDTO>();
			
			while(rset.next()) {
				HabbitAddDTO habbitadd = new HabbitAddDTO();
				
				habbitadd.setuserID(rest.getInt(USER_ID));
				habbitadd.sethabitID(rest.getInt(HABIT_ID));
				habbitadd.sethabitName(rest.getInt(HABIT_NAME));
				habbitadd.sethabitType(rest.getInt(HABIT_TYPE));
				habbitadd.sethabitDays(rest.getInt(HABIT_DAYS));
				habbitadd.sethabitGoal(rest.getInt(HABIT_GOAL));

			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return null;
	}

	

}