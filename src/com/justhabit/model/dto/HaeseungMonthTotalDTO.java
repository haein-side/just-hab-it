package com.justhabit.model.dto;

public class HaeseungMonthTotalDTO {

	private int habitId;
	private String todayMonth;
	private int dateCount;
	private int recordSum;
	
	public HaeseungMonthTotalDTO() {
		super();
	}

	public HaeseungMonthTotalDTO(int habitId, String todayMonth, int dateCount, int recordSum) {
		super();
		this.habitId = habitId;
		this.todayMonth = todayMonth;
		this.dateCount = dateCount;
		this.recordSum = recordSum;
	}

	public int getHabitId() {
		return habitId;
	}

	public void setHabitId(int habitId) {
		this.habitId = habitId;
	}

	public String getTodayMonth() {
		return todayMonth;
	}

	public void setTodayMonth(String todayMonth) {
		this.todayMonth = todayMonth;
	}

	public int getDateCount() {
		return dateCount;
	}

	public void setDateCount(int dateCount) {
		this.dateCount = dateCount;
	}

	public int getRecordSum() {
		return recordSum;
	}

	public void setRecordSum(int recordSum) {
		this.recordSum = recordSum;
	}

	@Override
	public String toString() {
		return "HaeseungSumCountDTO [habitId=" + habitId + ", todayMonth=" + todayMonth + ", dateCount=" + dateCount
				+ ", recordSum=" + recordSum + "]";
	}

	
	
	
	
	
	
}
