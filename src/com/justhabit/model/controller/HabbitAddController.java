package com.justhabit.model.controller;

import java.util.ArrayList;
import java.util.List;

import com.justhabit.model.dto.HabbitAddDTO;
import com.justhabit.model.service.HabbitAddService;



public class HabbitAddController {
	
	private HabbitAddService habbitAddService = new HabbitAddService();

	public List<HabbitAddDTO> insertAllHabbit(HabbitAddDTO habitAddDTO) {
		

		return habbitAddService.insertAllHabbit(habitAddDTO);
	}

}
