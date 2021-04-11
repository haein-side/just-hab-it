package com.justhabit.model.dao;

import static com.justhabit.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.justhabit.model.dto.HabbitAddDTO;

public class HabbitAddDAO {
	
	private static Properties prop = new Properties();
	
	public HabbitAddDAO() {
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/order-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int selectAllHabbit(List<HabbitAddDTO> allhabitList, Connection con) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertAllHabbit");
		
//		try {
//			pstmt = con.prepareStatement(query);
//			pstmt.setString(1, allhabitList.get(0));
//			pstmt.setString(2, ((HabbitAddDTO) allhabitList).getHabitType());
//			pstmt.setInt(3, ((HabbitAddDTO)allhabitList).getHabitDate());
//			pstmt.setString(4, ((HabbitAddDTO)allhabitList).getHabitselectDay());
//			pstmt.setString(5, ((HabbitAddDTO)allhabitList).getHabitRecord());
//			pstmt.setString(6, ((HabbitAddDTO)allhabitList).getHabitRecordNext());
//			
//			result = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
		
		return result;
	}

	

}