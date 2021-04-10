package com.justhabit.model.dto;

public class AllHabitDTO {
	private int UserID;
	private int habitID;
	private String habitName;
	private String habitType;
	
	public AllHabitDTO() {
		super();
	}

	public AllHabitDTO(int userID, int habitID, String habitName, String habitType) {
		super();
		UserID = userID;
		this.habitID = habitID;
		this.habitName = habitName;
		this.habitType = habitType;
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

	public String getHabitType() {
		return habitType;
	}

	public void setHabitType(String habitType) {
		this.habitType = habitType;
	}

	@Override
	public String toString() {
		return "AllHabitDTO [UserID=" + UserID + ", habitID=" + habitID + ", habitName=" + habitName + ", habitType="
				+ habitType + "]";
	}

	
}
