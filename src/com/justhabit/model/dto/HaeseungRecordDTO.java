package com.justhabit.model.dto;

import java.sql.Date;

public class HaeseungRecordDTO {

	private int userId;
	private int habitId;
	private String doDate;
	private int check;
	private int timer;
	
	public HaeseungRecordDTO() {
		super();
	}

	public HaeseungRecordDTO(int userId, int habitId, String doDate, int check, int timer) {
		super();
		this.userId = userId;
		this.habitId = habitId;
		this.doDate = doDate;
		this.check = check;
		this.timer = timer;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getHabitId() {
		return habitId;
	}

	public void setHabitId(int habitId) {
		this.habitId = habitId;
	}

	public String getDoDate() {
		return doDate;
	}

	public void setDoDate(String doDate) {
		this.doDate = doDate;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	@Override
	public String toString() {
		return "HaeseungRecordDTO [userId=" + userId + ", habitId=" + habitId + ", doDate=" + doDate + ", check="
				+ check + ", timer=" + timer + "]";
	}
	
	
	
}
