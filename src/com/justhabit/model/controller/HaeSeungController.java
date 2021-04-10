package com.justhabit.model.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.justhabit.model.dto.HaeseungRecordDTO;
import com.justhabit.model.dto.HaesungInfoDTO;
import com.justhabit.model.service.HaeSeungService;

public class HaeSeungController {
	
	private HaeSeungService habitService = new HaeSeungService();
	
	/**
	 * <pre>
	 * 습관정보 조회
	 * </pre>
	 * @param habitID
	 * @return
	 */
	public HaesungInfoDTO selectHabitInfo(HaesungInfoDTO registInfo) {
		
		HaesungInfoDTO info = habitService.selectHabitInfo(registInfo);
		return info;
	}

	

	/**
	 * <pre>
	 * 습관기록 INSERT
	 * </pre>
	 * @param checkRecord
	 */
	public void insertTimerController(HaeseungRecordDTO checkRecord) {
//		오늘날짜로 설정. 테스트시 주석처리
		Date todayDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
		checkRecord.setDoDate(dateFormat.format(todayDate));
		
		System.out.println("======컨트롤러 일 안하냐? " +checkRecord.getDoDate());
		
		int result = habitService.insertTimerService(checkRecord);
		
		if(result > 0) {
			System.out.println("신규저장성공");
		} else {
			System.out.println("신규저장실패");
		}
	}



	/**
	 * <pre>
	 *   습관기록 SELECT하여 오늘 기록된 습관이 있으면 1반환 없으면 0 반환
	 * </pre>
	 * @param record
	 * @return
	 */
	public int dateSelectController(HaeseungRecordDTO recordInfo) {
		
		int result = 0;
		if(!(habitService.selectDateinfo(recordInfo)==null)) {
			result = 1;
		}
		
		return result;
	}



	/**
	 * <pre>
	 *   습관기록 UPDATE
	 * </pre>
	 * @param checkRecord
	 */
	public void updateTimerController(HaeseungRecordDTO checkRecord) {
		
		int result = habitService.updateRecordService(checkRecord);
		
		if(result > 0) {
			System.out.println("갱신성공!");
		} else {
			System.out.println("갱신실패!");
		}
	}

}
