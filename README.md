#学生选课 班级：计181 姓名：李佳润 学号：2018310740

一、实验目的

  分析学生选课系统
  使用GUI窗体及其组件设计窗体界面
  完成学生选课过程业务逻辑编程
  基于文件保存并读取数据
  处理异常
二、实验要求

1、设计GUI窗体，支持学生注册、课程新加、学生选课、学生退课、打印学生选课列表等操作。
2、基于事件模型对业务逻辑编程，实现在界面上支持上述操作。
3、针对操作过程中可能会出现的各种异常，做异常处理
三、实验过程

1、编写思路
    先画出流程图，确定需要实现哪些功能，然后再根据框架写出程序。先确定需要哪些包（swing\awt\IO），将包导入，导入后先构建整体的GUI的所有界面，         
将界面通过监听事件相连接。然后在需要文本写入与文本读出的地方的界面写上文本操作。而打印课表则是通过将文件打开，显示出学生基本信息、所选课程来实现
的。
2、核心代码
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
