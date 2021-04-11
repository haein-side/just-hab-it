package com.justhabit.model.service;

import static com.justhabit.common.JDBCTemplate.close;
import static com.justhabit.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.justhabit.model.dao.HaeinDAO;
import com.justhabit.model.dto.AllHabitDTO;

public class HaeinService {
	
	private HaeinDAO habitDAO = new HaeinDAO();

	public List<AllHabitDTO> selectAllHabitBy(int loggedUserID) {

		Connection con = getConnection();
		
		List<AllHabitDTO> allhabitList = habitDAO.selectAllHabitBy(con, loggedUserID);
		
		close(con);
		
		return allhabitList;
	}

}
