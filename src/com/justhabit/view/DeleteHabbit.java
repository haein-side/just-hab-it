package com.justhabit.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.justhabit.model.controller.HaeinController;
import com.justhabit.model.controller.PanelChangeControl;
import com.justhabit.model.dto.AllHabitDTO;

public class DeleteHabbit {
	
	private HaeinController habitDayController = new HaeinController();

	List<AllHabitDTO> allhabitList = habitDayController.selectAllHabitBy(FirstFrame.loggedUserID);
	Map<String, Object> habitMap = new HashMap<>();
	
	public DeleteHabbit() {
		String[] habit = new String[allhabitList.size()];
		int[] habitNum = new int[allhabitList.size()];
		// 맵 객체에 key로 habit과 value로 habitNum을 넣어주고 선택한 
		
		for(int h = 0; h < allhabitList.size(); h++) {
			
			habit[h] = allhabitList.get(h).getHabitName();
			habitNum[h] = allhabitList.get(h).getHabitID();
			
		}
		JComboBox habitCombo = new JComboBox(habit);
		
		JOptionPane.showMessageDialog(null, habitCombo, "어떤 습관을 삭제하시겠습니까?", JOptionPane.QUESTION_MESSAGE );
		
		String deleteHabbit = (String)habitCombo.getSelectedItem();
		System.out.println(deleteHabbit);
		
//		habitMap.put(deleteHabbit, totalOrderPrice);
	
		//버튼 클릭시 event - 선택한 습관을 입력받아야. 입력받을 때 habit id를 받기
		//해당 습관에 해당하는 habid id가 db에서 삭제되어야 함 (JDBC)
		//삭제되고 난 후 새로운 mainpage로 돌아가기 
		
		JButton push = new JButton("삭제하기");
		
//		push.addActionListener(new ActionListener() {
//			
//	          @Override
//	          public void actionPerformed(ActionEvent e) {
//	      
//	        	  habitDayController.deleteHabbitBy(deleteHabbit);
//	        	  
//	          }
//	       });

	


		
	}	
		
}
	  

