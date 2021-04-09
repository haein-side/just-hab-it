package com.justhabit.model.service;

import static com.justhabit.common.JDBCTemplate.close;
import static com.justhabit.common.JDBCTemplate.commit;
import static com.justhabit.common.JDBCTemplate.getConnection;
import static com.justhabit.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.justhabit.model.dao.HaeseungDAO;
import com.justhabit.model.dto.HaeseungRecordDTO;
import com.justhabit.model.dto.HaesungInfoDTO;

public class HaeSeungService {
	
	HaeseungDAO habitDAO = new HaeseungDAO();

	public HaesungInfoDTO selectHabitInfo(int habitID) {
		
		Connection con = getConnection();
		
		HaesungInfoDTO info = habitDAO.selectHabit(con, habitID);
		close(con);
		return info;
	}

	public int insertTimerService(HaeseungRecordDTO checkRecord) {
		
		Connection con = getConnection();
		
		int result = habitDAO.insertTimer(con, checkRecord);
		
		if(result > 0 ) {
			commit(con);
		}else {
			rollback(con);
		}
		return result;
	}

	public String selectDateinfo(int habitId) {
		
		Connection con = getConnection();
		
		String date = habitDAO.selectDate(con, habitId);
		close(con);
		return date;
	}

	public int updateRecordService(HaeseungRecordDTO checkRecord) {
		
		Connection con = getConnection();
		
		int result = habitDAO.updateRecord(con,checkRecord);
		
		if(result > 0 ) {
			System.out.println("수정성공!");
			commit(con);
		}else {
			System.out.println("수정실패!");
			rollback(con);
		}
		return result;
	}

}
