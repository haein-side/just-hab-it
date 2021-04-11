package com.justhabit.model.service;

import static com.justhabit.common.JDBCTemplate.close;
import static com.justhabit.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.justhabit.model.dao.HabbitAddDAO;
import com.justhabit.model.dto.HabbitAddDTO;

public class HabbitAddService {

	public String selectAllHabbit(List<HabbitAddDTO> allhabitList) {
		
		String confirm = null;
		
		Connection con = getConnection();
		
		int selectAllHabbit = HabbitAddDAO.selectAllHabbit(allhabitList, con);
		
		if(selectAllHabbit != 0) {
			confirm += "성공 했다";
		} else {
			confirm += "성공했겠냐 ";
		}
		
		close(con);
		
		return confirm;
	}

}