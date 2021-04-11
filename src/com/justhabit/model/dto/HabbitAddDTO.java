package com.justhabit.model.dto;

import java.io.Serializable;

public class HabbitAddDTO implements Serializable{
	
	private static final long serialVersionUID = 843061075072438592L;
	private String MemberId;
	private String habitType;
	private int habitDate;
	private String habitselectDay;
	private String habitRecord;
	private String habitRecordNext;
	
	
	public HabbitAddDTO() {}
	
	public HabbitAddDTO(String memberId, String habitType, int habitDate, String habitselectDay, String habitRecord,
			String habitRecordNext) {
		
		this.MemberId = memberId;
		this.habitType = habitType;
		this.habitDate = habitDate;
		this.habitselectDay = habitselectDay;
		this.habitRecord = habitRecord;
		this.habitRecordNext = habitRecordNext;
	}

	public String getMemberId() {
		return MemberId;
	}

	public void setMemberId(String memberId) {
		MemberId = memberId;
	}

	public String getHabitType() {
		return habitType;
	}

	public void setHabitType(String habitType) {
		this.habitType = habitType;
	}

	public int getHabitDate() {
		return habitDate;
	}

	public void setHabitDate(int habitDate) {
		this.habitDate = habitDate;
	}

	public String getHabitselectDay() {
		return habitselectDay;
	}

	public void setHabitselectDay(String habitselectDay) {
		this.habitselectDay = habitselectDay;
	}

	public String getHabitRecord() {
		return habitRecord;
	}

	public void setHabitRecord(String habitRecord) {
		this.habitRecord = habitRecord;
	}

	public String getHabitRecordNext() {
		return habitRecordNext;
	}

	public void setHabitRecordNext(String habitRecordNext) {
		this.habitRecordNext = habitRecordNext;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "HabbitAddDTO [MemberId=" + MemberId + ", habitType=" + habitType + ", habitDate=" + habitDate
				+ ", habitselectDay=" + habitselectDay + ", habitRecord=" + habitRecord + ", habitRecordNext="
				+ habitRecordNext + "]";
	}
	
	
	
	
}
	
