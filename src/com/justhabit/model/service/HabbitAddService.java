package com.justhabit.model.service;

import static com.justhabit.common.JDBC_EC2.close;
import static com.justhabit.common.JDBC_EC2.getConnection;

//import static com.justhabit.common.JDBCTemp.close;
//import static com.justhabit.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.justhabit.model.dao.HabbitAddDAO;
import com.justhabit.model.dto.HabbitAddDTO;

//public class HabbitAddService {
	
//	private HabbitAddDAO habbitAddDAO = new HabbitAddDAO();


//	public int insertAllHabbit(HabbitAddDTO habitAddDTO) {
//		
//		Connection con = getConnection();
//		
//		int result = 0;
//		
////		int result = 
////		
////		
////		return 0;
//	}
//
//}