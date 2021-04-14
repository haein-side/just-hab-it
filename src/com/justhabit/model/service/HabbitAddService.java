package com.justhabit.model.service;

import static com.justhabit.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.justhabit.model.dao.HabbitAddDAO;
import com.justhabit.model.dto.HabbitAddDTO;

public class HabbitAddService {
	
	private HabbitAddDAO habbitAddDAO = new HabbitAddDAO();


	public int insertAllHabbit(HabbitAddDTO habitAddDTO) {
		
		Connection con = getConnection();
		
		int result = habbitAddDAO.insertAllHabbit(con, habitAddDTO);
		
		return result;
	}
}