package com.justhabit.model.controller;

import java.util.ArrayList;
import java.util.List;

import com.justhabit.model.dto.HabbitAddDTO;
//import com.justhabit.model.service.HabbitAddService;
import com.justhabit.view.FirstFrame;
import com.justhabit.view.HabbitAdd;



public class HabbitAddController {
	
//	private HabbitAddService habbitAddService = new HabbitAddService(); // 캡슐화로 private을 사용

	public int insertAllHabbit(HabbitAddDTO habitAddDTO) {
		
		HabbitAddDTO habbitadd = new HabbitAddDTO();
		habbitadd.setUserID(FirstFrame.loggedUserID);
//		habbitadd.setHabitID();
//		habbitadd.setHabitName();
//		habbitadd.setHabitType();
//		habbitadd.setHabitDays();
//		habbitadd.setHabitGoal();
		
		
//		int result = habbitAddService.registHabbitAdd(habbitadd);
		
		return 0;
	}
}
