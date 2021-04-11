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

	/**
	 * <pre>
	 * 습관정보 조회
	 * </pre>
	 * 
	 * @param 
	 * @return
	 */
	public HaesungInfoDTO selectHabitInfo(HaesungInfoDTO registInfo) {
		
		Connection con = getConnection();
		
		HaesungInfoDTO info = habitDAO.selectHabit(con, registInfo);
		close(con);
		return info;
	}

	/**
	 * <pre>
	 * CHECK INSERT
	 * </pre>
	 * @param checkRecord
	 * @return
	 */
	public int insertCheckService(HaeseungRecordDTO checkRecord) {
		
		Connection con = getConnection();
		
		int result = habitDAO.insertCheck(con, checkRecord);
		
		if(result > 0 ) {
			commit(con);
		}else {
			rollback(con);
		}
		return result;
	}
	
	/**
	 * <pre>
	 * Timer INSERT
	 * </pre>
	 * @param checkRecord
	 * @return
	 */
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
	

	/**
	 * <pre>
	 * SELECT date
	 * </pre>
	 * @param recordInfo
	 * @return
	 */
	public HaeseungRecordDTO selectDateinfo(HaeseungRecordDTO recordInfo) {
		
		Connection con = getConnection();
		
		HaeseungRecordDTO info= habitDAO.selectDate(con, recordInfo);
		
		close(con);
		return info;
	}

	/**
	 * <pre>
	 * CHECK UPDATE
	 * </pre>
	 * @param checkRecord
	 * @return
	 */
	public int updateCheckRecordService(HaeseungRecordDTO checkRecord) {
		
		Connection con = getConnection();
		
		int result = habitDAO.updateCheckRecord(con,checkRecord);
		
		if(result > 0 ) {
			commit(con);
		}else {
			rollback(con);
		}
		return result;
	}

	/**
	 * <pre>
	 * Timer Update
	 * </pre>
	 * @param timerRecord
	 * @return
	 */
	public int updateTimerRecordService(HaeseungRecordDTO timerRecord) {
		Connection con = getConnection();
		
		int result = habitDAO.updateTimerRecord(con, timerRecord);
		System.out.println(result);
		if(result > 0 ) {
			commit(con);
		}else {
			rollback(con);
		}
		return result;
	}

	public Object selectTimerDateinfo(HaeseungRecordDTO timerRecord) {
		Connection con = getConnection();
		
		HaeseungRecordDTO info= habitDAO.selectTimerDate(con, timerRecord);
		
		close(con);
		return info;
	}


}
