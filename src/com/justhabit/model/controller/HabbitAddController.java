package com.justhabit.model.controller;

import java.util.ArrayList;
import java.util.List;

import com.justhabit.model.dto.HabbitAddDTO;
import com.justhabit.model.service.HabbitAddService;



public class HabbitAddController {
	
	private HabbitAddService habbitAddService = new HabbitAddService();
	

//	public static List<HabbitAddDTO> selectAllHabbit(String MemberId, String habitType, int habitDate,
//			String habitselectDay,String habitRecord, String habitRecordNext) {
//		HabbitAddDTO test = null;
//		List<HabbitAddDTO> allhabitList = new ArrayList<HabbitAddDTO>();
//		allhabitList.add(MemberId);
//		List<HabbitAddDTO> allhabitList = new ArrayList<>();
//		
//		test = new HabbitAddDTO();
		
//		test.setMemberId(MemberId);
//		test.setHabitType(habitType);
//		test.setHabitDate(habitDate);
//		test.setHabitselectDay(habitselectDay);
//		test.setHabitRecord(habitRecord);
//		test.setHabitRecordNext(habitRecordNext);
//		allhabitList.add(test);
		
//		String selectAllHabbit = HabbitAddService.selectAllHabbit(allhabitList);
//		
//		System.out.println(selectAllHabbit);
//		
//		return allhabitList;
//	}

//	public static List<HabbitAddDTO> selectAllHabbit2() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public HabbitAddDTO insertAllHabbit(HabbitAddDTO habitAddDTO) {
		
//		HabbitAddDTO test = null;
//		
//		List<HabbitAddDTO> allhabitList = new ArrayList<>();
//		
//		test = new HabbitAddDTO();
//		
//		String insertAllHabbit = HabbitAddService.insertAllHabbit(allhabitList);
		
		
		return habbitAddService.insertAllHabbit();
	}

}
