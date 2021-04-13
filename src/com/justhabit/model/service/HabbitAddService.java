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



//	public List<HabbitAddDTO> insertAllHabbit() {
//		
//		Connection con = getConnection();
//		
//		List<HabbitAddDTO> habbitAddList = habbitAddDAO.insertAllHabbit(con, userID, habitID, habitDate, habitType,
//				habitDays, habitGoal);
//		
//		close(con);
//		
//		return habbitAddList;
//	}



	public List<HabbitAddDTO> insertAllHabbit(HabbitAddDTO habitAddDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}