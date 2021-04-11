package com.justhabit.model.controller;

import java.util.List;

import com.justhabit.model.dto.AllHabitDTO;
import com.justhabit.model.service.HaeinService;
import com.justhabit.view.FirstFrame;

public class HaeinController {

	private HaeinService habitService = new HaeinService();
//	public List<AllHabitDTO>  selectAllHabitBy(int loggedUserID) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public List<AllHabitDTO> selectAllHabitBy(int loggedUserID) {
		
		return habitService.selectAllHabitBy(loggedUserID);
		
	}

	

}
