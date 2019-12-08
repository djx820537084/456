package 学生选课;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class Choosing extends JFrame implements  ActionListener{
	JLabel a = new JLabel("请选择课程：");
	JButton r = new JButton("确定");
	JCheckBox jc1 = new JCheckBox("老师名称：张三    老师编号： 1  所授课程：物理   学分：2 地点：1   时间：9:25am-11:15am");
	JCheckBox jc2 = new JCheckBox("老师名称：李四    老师编号： 2  所授课程：英语   学分：2 地点：2   时间：11:15am-12:05pm");
	JCheckBox jc3 = new JCheckBox("老师名称：王二麻   老师编号：  3 所授课程：语文   学分：2  地点：3  时间：13:30pm-15:05pm");
	
	Choosing(){
		setTitle("选课");
		setSize(600,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new FlowLayout());
		
		add(a);
		add(jc1);
		add(jc2);
		add(jc3);
		add(r);
		jc1.addActionListener(this);
		jc2.addActionListener(this);
		jc3.addActionListener(this);
		r.addActionListener(this);
	}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==r) {
				JOptionPane.showMessageDialog(null, "选课成功！");
				new caozuo();
				try {
					FileWriter fw1=new FileWriter("C:\\Users\\Administrator\\Desktop\\ws.txt",true);
					BufferedWriter fw=new BufferedWriter(fw1);
					fw.write("已选课程：");
					fw.newLine();
					fw.write("老师名称：张三    老师编号： 1  所授课程：物理   学分：2 地点：1   时间：9:25am-11:15am");
					fw.newLine();
					fw.write("老师名称：李四    老师编号： 2  所授课程：英语   学分：2 地点：2   时间：11:15am-12:05pm");
					fw.newLine();
					fw.write("老师名称：王二麻   老师编号：  3 所授课程：语文   学分：2  地点：3  时间：13:30pm-15:05pm");					
					fw.close();
				}
				catch (IOException n) 
				{
				n.printStackTrace();
				}
			}
		}
		public static void main(String args[]) {
			Choosing c = new Choosing();
		}
}
