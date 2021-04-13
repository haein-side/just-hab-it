package com.justhabit.model.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.justhabit.model.dto.HaeseungMonthTotalDTO;
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
	 * 횟수기록 INSERT
	 * </pre>
	 * @param checkRecord
	 */
	public void insertCheckController(HaeseungRecordDTO checkRecord) {
//		오늘날짜로 설정. 테스트시 주석처리
		Date todayDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
		checkRecord.setDoDate(dateFormat.format(todayDate));
		
		
		int result = habitService.insertCheckService(checkRecord);
		
		if(result > 0) {
			System.out.println("신규저장성공");
		} else {
			System.out.println("신규저장실패");
		}
	}

	/**
	 * <pre>
	 * 시간기록 INSERT
	 * @param checkRecord
	 */
	public void insertTimerController(HaeseungRecordDTO timerRecord) {
//		오늘날짜로 설정. 테스트시 주석처리
		Date todayDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
		timerRecord.setDoDate(dateFormat.format(todayDate));
		
		
		int result = habitService.insertTimerService(timerRecord);
		
		if(result > 0) {
			System.out.println("신규저장성공");
		} else {
			System.out.println("신규저장실패");
		}
	}

	/**
	 * <pre>
	 *   횟수기록 UPDATE
	 * </pre>
	 * @param checkRecord
	 */
	public void updateCheckController(HaeseungRecordDTO checkRecord) {
		
		int result = habitService.updateCheckRecordService(checkRecord);
		
		if(result > 0) {
			System.out.println("갱신성공!");
		} else {
			System.out.println("갱신실패!");
		}
	}

	/**
	 * <pre>
	 *   시간기록 UPDATE
	 * </pre>  
	 * @param timerRecord
	 */
	public void updateTimerController(HaeseungRecordDTO timerRecord) {
		
		int result = habitService.updateTimerRecordService(timerRecord);
		
		if(result > 0) {
			System.out.println("갱신성공!");
		} else {
			System.out.println("갱신실패!");
		}
	}

	public int dateTimerSelectController(HaeseungRecordDTO timerRecord) {
		int result = 0;
		if(!(habitService.selectTimerDateinfo(timerRecord)==null)) {
			result = 1;
		}
		
		return result;
	}

	/**
	 * <pre>
	 *   월 횟수 total 출력을 위한 정보조회
	 * </pre>
	 * @param totalRecord
	 * @return
	 */
	public HaeseungMonthTotalDTO monthTotalController(HaeseungMonthTotalDTO totalRecord) {
		
		HaeseungMonthTotalDTO monthTotal = habitService.selectMonthTotal(totalRecord);
		return monthTotal;
	}

	/**
	 * <pre>
	 *   월 Timer total 출력을 위한 정보조회
	 * </pre>
	 * @param totalRecord
	 * @return
	 */
	public HaeseungMonthTotalDTO monthTimerTotalController(HaeseungMonthTotalDTO totalRecord) {
		
		HaeseungMonthTotalDTO monthTotal = habitService.selectMonthTimerTotal(totalRecord);
		
		return monthTotal;
	}

	public List<HaeseungRecordDTO> selectRecordGoal(HaeseungRecordDTO Record) {
		List<HaeseungRecordDTO> recordAndGoalList = habitService.selectRecordGoal(Record);
		return recordAndGoalList;
	}


}
