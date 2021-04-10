package com.justhabit.model.controller;

import java.util.List;

import com.justhabit.model.dto.AllHabitDTO;
import com.justhabit.model.service.HaeinService;

public class HaeinController {

	private HaeinService habitService = new HaeinService();
//	public List<AllHabitDTO>  selectAllHabitBy(int loggedUserID) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public List<AllHabitDTO> selectAllHabitBy(int userid) {
		
		return habitService.selectAllHabitBy(userid);
		
	}

	

}
