package com.justhabit.model.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.justhabit.model.dto.HaeseungRecordDTO;
import com.justhabit.model.dto.HaesungInfoDTO;
import com.justhabit.model.service.HaeSeungService;

public class HaeSeungController {
	
	private HaeSeungService habitService = new HaeSeungService();

	public HaesungInfoDTO selectHabitInfo(int habitID) {
		
		HaesungInfoDTO habitInfo = habitService.selectHabitInfo(habitID);
		return habitInfo;
	}

	

	public void insertTimerController(HaeseungRecordDTO checkRecord) {
		Date todayDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
		checkRecord.setDoDate(dateFormat.format(todayDate));
		
		int result = habitService.insertTimerService(checkRecord);
		
		if(result > 0) {
			System.out.println("저장성공");
		} else {
			System.out.println("저장실패");
		}
	}



	public String dateSelectController(int habitId) {
		
		String date = habitService.selectDateinfo(habitId);
		return date;
	}



	public void updateTimerController(HaeseungRecordDTO checkRecord) {
		
		int result = habitService.updateRecordService(checkRecord);
		
		if(result > 0) {
			System.out.println("수정성공!");
		} else {
			System.out.println("수정실패!");
		}
	}

}
