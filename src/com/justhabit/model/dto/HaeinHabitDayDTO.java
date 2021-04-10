package com.justhabit.model.dto;

public class HaeinHabitDayDTO {
	private int UserID;
	private int habitID;
	private String habitName;
	private int habitDays;
	private int todayDay;
	
	public HaeinHabitDayDTO() {
		super();
	}

	public HaeinHabitDayDTO(int userID, int habitID, String habitName, int habitDays, int todayDay) {
		super();
		UserID = userID;
		this.habitID = habitID;
		this.habitName = habitName;
		this.habitDays = habitDays;
		this.todayDay = todayDay;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public int getHabitID() {
		return habitID;
	}

	public void setHabitID(int habitID) {
		this.habitID = habitID;
	}

	public String getHabitName() {
		return habitName;
	}

	public void setHabitName(String habitName) {
		this.habitName = habitName;
	}

	public int getHabitDays() {
		return habitDays;
	}

	public void setHabitDays(int habitDays) {
		this.habitDays = habitDays;
	}

	public int getTodayDay() {
		return todayDay;
	}

	public void setTodayDay(int todayDay) {
		this.todayDay = todayDay;
	}

	@Override
	public String toString() {
		return "HaeinHabitDayDTO [UserID=" + UserID + ", habitID=" + habitID + ", habitName=" + habitName
				+ ", habitDays=" + habitDays + ", todayDay=" + todayDay + "]";
	}
	

	
}
