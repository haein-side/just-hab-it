package com.justhabit.model.dto;

public class AllHabitDTO {
	private int UserID;
	private int habitID;
	private String habitName;
	
	public AllHabitDTO() {
		super();
	}

	public AllHabitDTO(int userID, int habitID, String habitName) {
		super();
		UserID = userID;
		this.habitID = habitID;
		this.habitName = habitName;
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

	@Override
	public String toString() {
		return "AllHabitDTO [UserID=" + UserID + ", habitID=" + habitID + ", habitName=" + habitName + "]";
	}

	
	
}
