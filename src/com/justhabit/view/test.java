package com.justhabit.view;

import java.util.List;

import com.justhabit.model.controller.HabbitAddController;
import com.justhabit.model.dto.HabbitAddDTO;

public class test {
 
	
	
	public static void main(String[] args) {
		
		 String MemberId = "gag";
		 String habitType = "fanla";
		 int habitDate = 14;
		 String habitselectDay = "123";
		 String habitRecord="시간";
		 String habitRecordNext = "3";
		
		 List<HabbitAddDTO> allhabitList = HabbitAddController.selectAllHabbit(MemberId, habitType, habitDate,habitselectDay ,habitRecord, habitRecordNext);
		
		
	}

}
