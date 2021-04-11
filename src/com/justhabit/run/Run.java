
package com.justhabit.run;

import static com.justhabit.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.justhabit.view.FirstFrame;
import com.justhabit.view.HabbitAdd;
import com.justhabit.view.MainPage;
import com.justhabit.view.MainView;
import com.justhabit.view.MyPage;
import com.justhabit.view.TimeRecordView;



public class Run {

	public static void main(String[] args) {
//		new LoginFrame().initialize();
//		new MainView();
		
		/* 연결됐는지 확인하는 메소드 */
//		Connection con = getConnection();
//		System.out.println(con);

		new HabbitAdd();
		
//		MainPage mainpage = new MainPage();
//		mainpage.displayHabit();
		
//		new MyPage();
		
	}
}
