package com.justhabit.model.service;

import static com.justhabit.common.JDBC_EC2.close;
import static com.justhabit.common.JDBC_EC2.getConnection;

//import static com.justhabit.common.JDBCTemp.close;
//import static com.justhabit.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.justhabit.model.dao.HabbitAddDAO;
import com.justhabit.model.dto.HabbitAddDTO;

public class HabbitAddService {
	
	private HabbitAddDAO habbitAddDAO = new HabbitAddDAO();

//	public String selectAllHabbit(List<HabbitAddDTO> allhabitList) {
		
//		String confirm = null;
		
//		Connection con = getConnection();
		
//		int selectAllHabbit = HabbitAddDAO.insertAllHabbit(allhabitList, con);
//		
//		if(selectAllHabbit != 0) {
//			confirm += "성공 했다";
//		} else {
//			confirm += "성공했 ";
//		}
//		
//		close(con);
//		
//		return confirm;
//	}
//
//	public String insertAllHabbit(List<HabbitAddDTO> allhabitList) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public List<HabbitAddDTO> insertAllHabbit(int habitDate, int habitID, String userID, String habitType,
			String habitDays, int habitGoal) {
		
		Connection con = getConnection();
		
		List<HabbitAddDTO> habbitAddList = habbitAddDAO.insertAllHabbit(con, userID, habitID, habitDate, habitType,
				habitDays, habitGoal);
		
		close(con);
		
		return habbitAddList;
	}

}