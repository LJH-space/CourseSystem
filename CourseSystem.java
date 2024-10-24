package keshe;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import javax.swing.*;
import java.io.*;


public class MAIN extends JFrame implements ActionListener {
	JButton a,b,c,d,w,f,g,h,a1,a2;
	JTextField i,j;
	//主页面
	MAIN(){
		setSize(800,800);
		setResizable(false);
		setTitle("课程设计选题管理系统");
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		a1=new JButton("确定");
		a2=new JButton("确定");
		a=new JButton("添加功能");
		b=new JButton("查询功能");
		c=new JButton("显示功能");
		d=new JButton("编辑功能");
		w=new JButton("删除功能");
		f=new JButton("统计功能");
		g=new JButton("保存功能");
		h=new JButton("读取功能");
		JLabel lb=new JLabel("欢迎使用课程设计选课管理系统");
		i=new JTextField(2);
		j=new JTextField(2);
		lb.setFont(new Font("宋体",Font.BOLD, 16));//设置字体风格，字号，加粗
		add(lb);
		add(a);
		add(b);
		add(c);
		add(d);
		add(w);
		add(f);
		add(g);
		add(h);
		add(i);
		add(j);
		add(a1);
		add(a2);
		lb.setBounds(250, 20, 500, 20);
		a.setBounds(75,100, 300,100);
		b.setBounds(75,250,300,100);
		c.setBounds(75,400,300,100);
		d.setBounds(400,100,300,100);
		w.setBounds(400,250,300,100);
		f.setBounds(400,400,300,100);
		g.setBounds(75,550,300,100);
		h.setBounds(400,550,300,100);
		i.setBounds(175, 210, 100,30);
		j.setBounds(175, 360, 100,30);
		a1.setBounds(275,210,100,30);
		a2.setBounds(275,360,100,30);
		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		d.addActionListener(this);
		w.addActionListener(this);
		f.addActionListener(this);
		g.addActionListener(this);
		h.addActionListener(this);
		a1.addActionListener(this);
		a2.addActionListener(this);
	}
	
	
	//监听器
	public void actionPerformed(ActionEvent e) {
		//判断是哪个按钮触发了，不同的按钮对应着不同的方法
		if(e.getSource()==a) {
			JOptionPane.showMessageDialog(null,"请在下方文本框输入您要添加的数据：1学生信息，2题目信息，3学生选题");
		}
		else if(e.getSource()==a1) {
			if(i.getText().trim().equals("1")) {
				addstudent();
			}
			else if(i.getText().trim().equals("2")) {
				addquestion();
			}
			else if(i.getText().trim().equals("3")) {
				addchoice();
			}
			else
				JOptionPane.showMessageDialog(null,"请重新输入");
		}
		else if(e.getSource()==b) {
			JOptionPane.showMessageDialog(null,"请在下方文本框输入您要查询的依据：1学号，2姓名，3编号，4名称");
		}
		else if(e.getSource()==a2) {
			if(j.getText().trim().equals("1")) {
				searchstuid();
			}
			else if(j.getText().trim().equals("2")) {
				searchname();
			}
			else if(j.getText().trim().equals("3")) {
				searchsubjectid();
			}
			else if(j.getText().trim().equals("4")) {
				searchsubjectname();
			}
		}
		//学号、姓名、编号、名称
		else if(e.getSource()==c) display();
		else if(e.getSource()==d) write();
		else if(e.getSource()==w) delete();
		else if(e.getSource()==f) statistic();
		else if(e.getSource()==g) save();
		else if(e.getSource()==h) read();
	}
	
	//功能1添加功能
	//添加学生
	public void addstudent() {
		JFrame a11=new JFrame("请输入");
		JButton az=new JButton("添加");
		a11.setSize(500,500);
		a11.setVisible(true);
		a11.validate();
		a11.setLayout(null);
        JLabel a111=new JLabel("学号");
        JLabel a112=new JLabel("姓名");
        JLabel a113=new JLabel("性别");
        JLabel a114=new JLabel("年龄");
        JLabel a115=new JLabel("班级");
        JLabel a116=new JLabel("专业");
        JTextField aa=new JTextField(10);
        JTextField bb=new JTextField(10);
        JTextField cc=new JTextField(10);
        JTextField dd=new JTextField(10);
        JTextField ee=new JTextField(10);
        JTextField ff=new JTextField(10);
        a11.add(a111);
        a11.add(a112);
        a11.add(a113);
        a11.add(a114);
        a11.add(a115);
        a11.add(a116);
        a11.add(aa);
        a11.add(bb);
        a11.add(cc);
        a11.add(dd);
        a11.add(ee);
        a11.add(ff);  
        a11.add(az);
        a111.setFont(new Font("宋体",Font.BOLD, 16));
        a112.setFont(new Font("宋体",Font.BOLD, 16));
        a113.setFont(new Font("宋体",Font.BOLD, 16));
        a114.setFont(new Font("宋体",Font.BOLD, 16));
        a115.setFont(new Font("宋体",Font.BOLD, 16));        
        a116.setFont(new Font("宋体",Font.BOLD, 16));
        a111.setBounds(100,30,100,50);
        a112.setBounds(100,100,100,50);
        a113.setBounds(100,170,100,50);
        a114.setBounds(100,240,100,50);
        a115.setBounds(100,310,100,50);
        a116.setBounds(100,380,100,50);
        aa.setBounds(200,30,100,30);
        bb.setBounds(200,100,100,30);
        cc.setBounds(200,170,100,30);
        dd.setBounds(200,240,100,30);
        ee.setBounds(200,310,100,30);
        ff.setBounds(200,380,100,30);
        az.setBounds(350,200,100,50);
        //az按钮点击后可进行添加，进行数据库连接
        az.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
      		      Class.forName("com.mysql.cj.jdbc.Driver");
      		    Connection connect = DriverManager.getConnection(
      		          "jdbc:mysql://localhost:3306/mydate?characterEncoding=utf8&useSSL=false&serverTimezone=UTC","root","2511030166");
      		    String sql="insert into stu (idstu,namestu,sexstu,agestu,classstu,majorstu) values ('"
      		          +aa.getText().trim()+"','"+bb.getText().trim()+"','"+cc.getText().trim()+"','"
      		    		+dd.getText().trim()+"','"+ee.getText().trim()+"','"+ff.getText().trim()+"')";//获取文本框的内容
      		  if(aa.getText().contentEquals(""))
      			JOptionPane.showMessageDialog(null,"请重新输入");
 			//判断文本框是否为空
      		  else {Statement stmt = connect.createStatement();
    		    stmt.executeUpdate(sql);
    		    JOptionPane.showMessageDialog(null,"添加成功");}
      		    connect.close();
        	} 
        		catch (Exception e1) {
        			JOptionPane.showMessageDialog(null,"此学号已经添加请勿重复添加");//学号为主键
  		    }
        }
        });
	}
	//添加问题
	public void addquestion() {
		JFrame a11=new JFrame("请输入");
		JButton az=new JButton("添加");
		a11.setSize(500,500);
		a11.setVisible(true);
		a11.validate();
		a11.setLayout(null);
        JLabel a111=new JLabel("题目编号");
        JLabel a112=new JLabel("题目名称");
        JLabel a113=new JLabel("题目关键字");
        JLabel a114=new JLabel("实现技术");
        JLabel a115=new JLabel("人员数");
        JTextField aa=new JTextField(10);
        JTextField bb=new JTextField(10);
        JTextField cc=new JTextField(10);
        JTextField dd=new JTextField(10);
        JTextField ee=new JTextField(10);
        a11.add(a111);
        a11.add(a112);
        a11.add(a113);
        a11.add(a114);
        a11.add(a115);
        a11.add(aa);
        a11.add(bb);
        a11.add(cc);
        a11.add(dd);
        a11.add(ee);  
        a11.add(az);
        a111.setFont(new Font("宋体",Font.BOLD, 16));
        a112.setFont(new Font("宋体",Font.BOLD, 16));
        a113.setFont(new Font("宋体",Font.BOLD, 16));
        a114.setFont(new Font("宋体",Font.BOLD, 16));
        a115.setFont(new Font("宋体",Font.BOLD, 16));        
        a111.setBounds(100,30,100,50);
        a112.setBounds(100,100,100,50);
        a113.setBounds(100,170,100,50);
        a114.setBounds(100,240,100,50);
        a115.setBounds(100,310,100,50);
        aa.setBounds(200,30,100,30);
        bb.setBounds(200,100,100,30);
        cc.setBounds(200,170,100,30);
        dd.setBounds(200,240,100,30);
        ee.setBounds(200,310,100,30);
        az.setBounds(350,200,100,50);
        az.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
      		      Class.forName("com.mysql.cj.jdbc.Driver");
      		    Connection connect = DriverManager.getConnection(
      		          "jdbc:mysql://localhost:3306/mydate?characterEncoding=utf8&useSSL=false&serverTimezone=UTC","root","2511030166");
      		    String sql="insert into qus (idqus,namequs,keyqus,technology,numberqus) values ('"
      		          +aa.getText().trim()+"','"+bb.getText().trim()+"','"+cc.getText().trim()+"','"
      		    		+dd.getText().trim()+"','"+ee.getText().trim()+"')";
      		  if(aa.getText().contentEquals(""))
        			JOptionPane.showMessageDialog(null,"请重新输入");
   			
        		  else {Statement stmt = connect.createStatement();
      		    stmt.executeUpdate(sql);
      		    JOptionPane.showMessageDialog(null,"添加成功");}
        		    connect.close();
      		      } 
        		catch (Exception e1) {
        			JOptionPane.showMessageDialog(null,"此题目编号已经添加请勿重复添加");
  		    }
        }
        });
	}
	//学生选课
	public void addchoice() {
		JFrame a11=new JFrame("请输入");
		JButton az=new JButton("添加");
		a11.setSize(500,500);
		a11.setVisible(true);
		a11.validate();
		a11.setLayout(null);
        JLabel a111=new JLabel("学号");
        JLabel a12=new JLabel("所选题目名称");
        JLabel a222=new JLabel("请先添加学生信息再进行选题");
        JTextField aa=new JTextField(10);
        JTextField bb=new JTextField(10);
        a11.add(a111);
        a11.add(aa);
        a11.add(a12);
        a11.add(bb);
        a11.add(az);
        a11.add(a222);
        a111.setFont(new Font("宋体",Font.BOLD, 16));
        a222.setFont(new Font("宋体",Font.BOLD, 16));
        a12.setFont(new Font("宋体",Font.BOLD, 16));
        a111.setBounds(50,100,100,50);
        aa.setBounds(200,100,100,50);
        a12.setBounds(50,200,150,50);
        bb.setBounds(200,200,100,50);
        az.setBounds(200,350,100,50);
        a222.setBounds(100,10,400,30);
        az.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
      		      Class.forName("com.mysql.cj.jdbc.Driver");
      		    Connection connect = DriverManager.getConnection(
      		          "jdbc:mysql://localhost:3306/mydate?characterEncoding=utf8&useSSL=false&serverTimezone=UTC","root","2511030166");
      		    String sql="update stu set choose='"+bb.getText().trim()+"' where idstu='"+aa.getText().trim()+"'";
      		  if(aa.getText().contentEquals(""))
      			JOptionPane.showMessageDialog(null,"请重新输入");
 			
      		  else {Statement stmt = connect.createStatement();
    		    stmt.executeUpdate(sql);
    		    JOptionPane.showMessageDialog(null,"添加成功");}
      		    connect.close();
    		      } 
        		catch (Exception e1) {
        			 e1.printStackTrace();
  		    }
        	}
        });
	}
	//功能2查找功能
	//根据学号查找学生
	public void searchstuid() {
		JFrame a11=new JFrame("请输入");
		JLabel a111=new JLabel("学号");
		JButton az=new JButton("查询");
		a111.setFont(new Font("宋体",Font.BOLD, 16));
		JTextField aa=new JTextField(10);
		a11.setSize(500,500);
		a11.setVisible(true);
		a11.validate();
		a11.setLayout(null);
		a11.add(a111);
		a11.add(az);
		a11.add(aa);
		a111.setBounds(100,100,100,50);
		aa.setBounds(300,100,100,50);
		az.setBounds(200,300,100,50);
		az.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
      		      Class.forName("com.mysql.cj.jdbc.Driver");
      		    Connection connect = DriverManager.getConnection(
      		          "jdbc:mysql://localhost:3306/mydate?characterEncoding=utf8&useSSL=false&serverTimezone=UTC","root","2511030166");
      		  Statement stmt = connect.createStatement();
		      ResultSet rs = stmt.executeQuery("select * from stu where idstu='"+aa.getText().trim()+"'");
		      rs.next();
      		  JOptionPane.showMessageDialog(null,"学号:"+rs.getString("idstu")+" 姓名:"+rs.getString("namestu")+" 性别:"+
      				  rs.getString("sexstu")+" 年龄:"+rs.getString("agestu")+" 班级:"+rs.getString("classstu")+" 专业:"+rs.getString("majorstu"));
      		  connect.close();
        	} 
        		catch (Exception e1) {
        			JOptionPane.showMessageDialog(null,"没有找到，请重新输入");
  		    }
        }
        });
	}
	//根据姓名查找学生
	public void searchname() {
		JFrame a11=new JFrame("请输入");
		JLabel a111=new JLabel("姓名");
		JButton az=new JButton("查询");
		a111.setFont(new Font("宋体",Font.BOLD, 16));
		JTextField aa=new JTextField(10);
		a11.setSize(500,500);
		a11.setVisible(true);
		a11.validate();
		a11.setLayout(null);
		a11.add(a111);
		a11.add(az);
		a11.add(aa);
		a111.setBounds(100,100,100,50);
		aa.setBounds(300,100,100,50);
		az.setBounds(200,300,100,50);
		az.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		try {
  		      Class.forName("com.mysql.cj.jdbc.Driver");
  		    Connection connect = DriverManager.getConnection(
  		          "jdbc:mysql://localhost:3306/mydate?characterEncoding=utf8&useSSL=false&serverTimezone=UTC","root","2511030166");
  		  Statement stmt = connect.createStatement();
	      ResultSet rs = stmt.executeQuery("select * from stu where namestu='"+aa.getText().trim()+"'");
	      String s="";
	      while(rs.next()) {
	    	  s=s+"\n学号:"+rs.getString("idstu")+" 姓名:"+rs.getString("namestu")+" 性别:"+
	  				  rs.getString("sexstu")+" 年龄:"+rs.getString("agestu")+" 班级:"+rs.getString("classstu")+" 专业:"+rs.getString("majorstu");
	      }
	      JOptionPane.showMessageDialog(null,""+s);
  		  connect.close();
    	} 
    		catch (Exception e1) {
    			JOptionPane.showMessageDialog(null,"没有找到，请重新输入");
		    }
    }
    });		
}
	//根据编号查找题目
	public void searchsubjectid() {
		JFrame a11=new JFrame("请输入");
		JLabel a111=new JLabel("题目编号");
		JButton az=new JButton("查询");
		a111.setFont(new Font("宋体",Font.BOLD, 16));
		JTextField aa=new JTextField(10);
		a11.setSize(500,500);
		a11.setVisible(true);
		a11.validate();
		a11.setLayout(null);
		a11.add(a111);
		a11.add(az);
		a11.add(aa);
		a111.setBounds(100,100,100,50);
		aa.setBounds(300,100,100,50);
		az.setBounds(200,300,100,50);
		az.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		try {
  		      Class.forName("com.mysql.cj.jdbc.Driver");
  		    Connection connect = DriverManager.getConnection(
  		          "jdbc:mysql://localhost:3306/mydate?characterEncoding=utf8&useSSL=false&serverTimezone=UTC","root","2511030166");
  		  Statement stmt = connect.createStatement();
	      ResultSet rs = stmt.executeQuery("select * from qus where idqus='"+aa.getText().trim()+"'");
	      rs.next();
  		  JOptionPane.showMessageDialog(null,"题目编号:"+rs.getString("idqus")+" 题目名称:"+rs.getString("namequs")+" 题目关键字:"+
  				  rs.getString("keyqus")+" 实现技术:"+rs.getString("technology")+" 人员数:"+rs.getString("numberqus"));
  		  connect.close();
    	} 
    		catch (Exception e1) {
    			JOptionPane.showMessageDialog(null,"没有找到，请重新输入");
		    }
    }
    });		
}
//根据题目名称查找题目
	public void searchsubjectname() {
		JFrame a11=new JFrame("请输入");
		JLabel a111=new JLabel("题目名称");
		JButton az=new JButton("查询");
		a111.setFont(new Font("宋体",Font.BOLD, 16));
		JTextField aa=new JTextField(10);
		a11.setSize(500,500);
		a11.setVisible(true);
		a11.validate();
		a11.setLayout(null);
		a11.add(a111);
		a11.add(az);
		a11.add(aa);
		a111.setBounds(100,100,100,50);
		aa.setBounds(300,100,100,50);
		az.setBounds(200,300,100,50);
		az.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		try {
  		      Class.forName("com.mysql.cj.jdbc.Driver");
  		    Connection connect = DriverManager.getConnection(
  		          "jdbc:mysql://localhost:3306/mydate?characterEncoding=utf8&useSSL=false&serverTimezone=UTC","root","2511030166");
  		  Statement stmt = connect.createStatement();
	      ResultSet rs = stmt.executeQuery("select * from qus where namequs='"+aa.getText().trim()+"'");
	      rs.next();
  		  JOptionPane.showMessageDialog(null,"题目编号:"+rs.getString("idqus")+" 题目名称:"+rs.getString("namequs")+" 题目关键字:"+
  				  rs.getString("keyqus")+" 实现技术:"+rs.getString("technology")+" 人员数:"+rs.getString("numberqus"));
  		  connect.close();
    	} 
    		catch (Exception e1) {
    			JOptionPane.showMessageDialog(null,"没有找到，请重新输入"); 
		    }
    }
    });		
}
//功能4显示功能
	public void display() {
		JFrame a11=new JFrame("显示");
		JLabel a111=new JLabel("以下是系统中所有学生信息和课程设计题目信息");
		JTextArea a112=new JTextArea();
		a11.add(a112);
		a11.add(a111);
		a11.setSize(800,500);
		a11.setVisible(true);
		a11.setLayout(null);
		a111.setFont(new Font("宋体",Font.BOLD, 16));
		a111.setBounds(10,10,400,50);
		a112.setBounds(10,50,700,450);
		a11.setResizable(false);
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection connect = DriverManager.getConnection(
		          "jdbc:mysql://localhost:3306/mydate?characterEncoding=utf8&useSSL=false&serverTimezone=UTC","root","2511030166");
		  Statement stm = connect.createStatement();
		  ResultSet r = stm.executeQuery("select * from stu");
		  a112.append("学生信息\n");
		  while(r.next()) {  
	      a112.append("学生学号:"+r.getString("idstu")+" 学生姓名:"+r.getString("namestu")+" 学生性别:"+
					  r.getString("sexstu")+" 学生年龄:"+r.getString("agestu")+
					  " 学生班级:"+r.getString("classstu")+" 学生专业"+r.getString("majorstu")+" 选择题目:"+r.getString("choose")+"\n");
		  }
		  a112.append("题目信息\n");
		  Statement stmt = connect.createStatement();
	      ResultSet rs = stmt.executeQuery("select * from qus");
	      while(rs.next()) {  
		  a112.append("题目编号:"+rs.getString("idqus")+" 题目名称:"+rs.getString("namequs")+" 题目关键字:"+
				  rs.getString("keyqus")+" 实现技术:"+rs.getString("technology")+" 人员数:"+rs.getString("numberqus")+"\n");
	      }
		  connect.close();
  	} 
  		catch (Exception e1) {
  			
		    }
	}
	
//功能7保存功能
	public void save() {
			JFrame a11=new JFrame("保存");
			JLabel a111=new JLabel("以下是系统中所有学生信息和课程设计题目信息");
			JButton b=new JButton("保存");
			JTextArea a112=new JTextArea();
			a11.add(a112);
			a11.add(a111);
			a11.add(b);
			a11.setSize(800,500);
			a11.setVisible(true);
			a11.setLayout(null);
			a111.setFont(new Font("宋体",Font.BOLD, 16));
			a111.setBounds(10,10,400,50);
			a112.setBounds(10,50,700,300);
			b.setBounds(300,380,100,50);
			a11.setResizable(false);
			try {
			    Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection connect = DriverManager.getConnection(
			          "jdbc:mysql://localhost:3306/mydate?characterEncoding=utf8&useSSL=false&serverTimezone=UTC","root","2511030166");
			  Statement stm = connect.createStatement();
			  ResultSet r = stm.executeQuery("select * from stu");
			  a112.append("学生信息\n");
			  while(r.next()) {  
		      a112.append("学生学号:"+r.getString("idstu")+" 学生姓名:"+r.getString("namestu")+" 学生性别:"+
						  r.getString("sexstu")+" 学生年龄:"+r.getString("agestu")+
						  " 学生班级:"+r.getString("classstu")+" 学生专业"+r.getString("majorstu")+" 选择题目:"+r.getString("choose")+"\n");
			  }
			  a112.append("题目信息\n");
			  Statement stmt = connect.createStatement();
		      ResultSet rs = stmt.executeQuery("select * from qus");
		      while(rs.next()) {  
			  a112.append("题目编号:"+rs.getString("idqus")+" 题目名称:"+rs.getString("namequs")+" 题目关键字:"+
					  rs.getString("keyqus")+" 实现技术:"+rs.getString("technology")+" 人员数:"+rs.getString("numberqus")+"\n");
		      }
			  connect.close();
	  	} 
	  		catch (Exception e1) {
	  			
			    }
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						FileWriter fw=new FileWriter("a.txt");
						BufferedWriter bw=new BufferedWriter(fw);
						String s=a112.getText();
						bw.write(s);
						bw.flush();
						JOptionPane.showMessageDialog(null,"保存成功,已保存在当前目录a.txt中");
						//使用文件流进行操作，先将数据库内容保存在文本区中，再导入到文档中
					}
					catch(Exception e2) {
					}
				}				
			});
	}
	
//功能3编辑功能
	public void write() {
		JFrame a11=new JFrame("编辑");
		JLabel a111=new JLabel("请输入您要修改的信息");
		JLabel a112=new JLabel("请输入您要修改的内容");
		JLabel a113=new JLabel("请输入您的学号");
		JButton az=new JButton("修改");
		a111.setFont(new Font("宋体",Font.BOLD, 16));
		a112.setFont(new Font("宋体",Font.BOLD, 16));
		a113.setFont(new Font("宋体",Font.BOLD, 16));
		JTextField aa=new JTextField(10);
		JTextField bb=new JTextField(10);
		JTextField cc=new JTextField(10);
		a11.setSize(500,500);
		a11.setVisible(true);
		a11.validate();
		a11.setLayout(null);
		a11.add(a111);
		a11.add(az);
		a11.add(aa);
		a11.add(bb);
		a11.add(a112);
		a11.add(a113);
		a11.add(cc);
		a113.setBounds(30,30,200,50);
		cc.setBounds(220,30,100,50);
		a111.setBounds(30,130,200,50);
		aa.setBounds(220,130,100,50);
		a112.setBounds(30,230,200,50);
		bb.setBounds(220,230,100,50);
		az.setBounds(150,330,100,50);
		az.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
	      		      Class.forName("com.mysql.cj.jdbc.Driver");
	      		    Connection connect = DriverManager.getConnection(
	      		          "jdbc:mysql://localhost:3306/mydate?characterEncoding=utf8&useSSL=false&serverTimezone=UTC","root","2511030166");
	      		  if(aa.getText().trim().equals("姓名")) {
	      			String sql="update stu set namestu='"+bb.getText().trim()+"' where idstu='"+cc.getText().trim()+"'";
	      			Statement stmt = connect.createStatement();
	      			stmt.executeUpdate(sql);
	      			JOptionPane.showMessageDialog(null,"修改成功");
	      		  }
	      		  else if(aa.getText().trim().equals("性别")){
	      			String sql="update stu set sexstu='"+bb.getText().trim()+"' where idstu='"+cc.getText().trim()+"'";
		      			Statement stmt = connect.createStatement();
		      			stmt.executeUpdate(sql);	
		      			JOptionPane.showMessageDialog(null,"修改成功");
	      		  }
	      		  else if(aa.getText().trim().equals("年龄")){
	      			String sql="update stu set agestu='"+bb.getText().trim()+"' where idstu='"+cc.getText().trim()+"'";
	      			Statement stmt = connect.createStatement();
	      			stmt.executeUpdate(sql);
	      			JOptionPane.showMessageDialog(null,"修改成功");
	      		  }
	      		  else if(aa.getText().trim().equals("班级")){
	      			String sql="update stu set classstu='"+bb.getText().trim()+"' where idstu='"+cc.getText().trim()+"'";
	      			Statement stmt = connect.createStatement();
	      			stmt.executeUpdate(sql);
	      			JOptionPane.showMessageDialog(null,"修改成功");
	      		  }
	      		  else if(aa.getText().trim().equals("专业")){
	      			String sql="update stu set majorstu='"+bb.getText().trim()+"' where idstu='"+cc.getText().trim()+"'";
	      			Statement stmt = connect.createStatement();
	      			stmt.executeUpdate(sql);
	      			JOptionPane.showMessageDialog(null,"修改成功");
	      		  }
	      		  else if(aa.getText().trim().equals("题目")){
	      			String sql="update stu set choose='"+bb.getText().trim()+"' where idstu='"+cc.getText().trim()+"'";
	      			Statement stmt = connect.createStatement();
	      			stmt.executeUpdate(sql);
	      			JOptionPane.showMessageDialog(null,"修改成功");
	      		  }
	      		  else JOptionPane.showMessageDialog(null,"请重新输入");
	      		  connect.close();
	        	} 
	        		catch (Exception e1) {
	        			 e1.printStackTrace();
	        		}
			}
	});
	}
	//功能5删除功能
	public void delete() {
		JFrame a11=new JFrame("删除");
		JLabel a111=new JLabel("请输入您要删除的信息(学生或题目)");
		JLabel a112=new JLabel("请输入学生的学号或课程的编号");
		JButton az=new JButton("删除");
		a111.setFont(new Font("宋体",Font.BOLD, 16));
		a112.setFont(new Font("宋体",Font.BOLD, 16));
		JTextField aa=new JTextField(10);
		JTextField bb=new JTextField(10);
		a11.setSize(500,500);
		a11.setVisible(true);
		a11.validate();
		a11.setLayout(null);
		a11.add(a111);
		a11.add(az);
		a11.add(aa);
		a11.add(bb);
		a11.add(a112);
		a111.setBounds(30,50,300,50);
		aa.setBounds(340,50,100,50);
		a112.setBounds(30,230,300,50);
		bb.setBounds(340,230,100,50);
		az.setBounds(200,330,100,50);
		az.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
	      		      Class.forName("com.mysql.cj.jdbc.Driver");
	      		    Connection connect = DriverManager.getConnection(
	      		          "jdbc:mysql://localhost:3306/mydate?characterEncoding=utf8&useSSL=false&serverTimezone=UTC","root","2511030166");
	      		  if(aa.getText().trim().equals("学生")) {
	      			int i=0;
	      			Statement stmt = connect.createStatement();
	      			ResultSet r=stmt.executeQuery("select * from stu");
	      			while(r.next()) {
	      				i++;
	      			}
	      			String sql="DELETE FROM stu WHERE idstu='"+bb.getText().trim()+"'";
	      			stmt.executeUpdate(sql);
	      			int j=0;
	      			ResultSet rs = stmt.executeQuery("select * from stu");
	      			while(rs.next()) {
	      	            j++;
	      			}
	      			if(bb.getText().trim().contentEquals("")) {
	      				JOptionPane.showMessageDialog(null,"请输入学生学号");
	      		     }
	      		    else if(j==i)
	      			JOptionPane.showMessageDialog(null,"记录为空，请重新输入");
	      		    else if(j!=i)
	      		    	JOptionPane.showMessageDialog(null,"删除成功");
				}
	      		 //对数据库进行两次遍历，比对两次数据库信息的数量来判断这个信息是否存在
	      		  
	      		  else if(aa.getText().trim().equals("题目")){
	      			int i=0;
	      			Statement stmt = connect.createStatement();
	      			ResultSet r=stmt.executeQuery("select * from qus");
	      			while(r.next()) {
	      				i++;
	      			}
	      			String sql="DELETE FROM qus WHERE idqus='"+bb.getText().trim()+"'";
	      			stmt.executeUpdate(sql);
	      			int j=0;
	      			ResultSet rs = stmt.executeQuery("select * from qus");
	      			while(rs.next()) {
	      	            j++;
	      			}
	      			if(bb.getText().trim().contentEquals("")) {
	      				JOptionPane.showMessageDialog(null,"请输入题目编号");
	      		     }
	      		    else if(j==i)
	      			JOptionPane.showMessageDialog(null,"记录为空，请重新输入");
	      		    else if(j!=i)
	      		    	JOptionPane.showMessageDialog(null,"删除成功");
	      		  }
	      		  //使用两个遍历，对数据库是否存在此学号进行判断，从而输出不同的语句
	      		  
	      		  else JOptionPane.showMessageDialog(null,"请重新输入");
	      		  connect.close();
	        	} 
	        		catch (Exception e1) {
	        			
	        		}
			}
	});
	}
	//功能6统计功能
	public void statistic() {
		JFrame a11=new JFrame("统计");
		JLabel a111=new JLabel("请输入题目名称，选择此题的学生信息如下");
		JTextField aa=new JTextField(10);
		JButton bb=new JButton("确定");
		JTextArea a112=new JTextArea();
		a11.add(a112);
		a11.add(a111);
		a11.add(aa);
		a11.add(bb);
		a11.setSize(700,500);
		a11.setVisible(true);
		a11.setLayout(null);
		a111.setFont(new Font("宋体",Font.BOLD, 16));
		a111.setBounds(10,10,400,50);
		a112.setBounds(10,100,600,450);
		aa.setBounds(10,50,150,30);
		bb.setBounds(200,50,100,30);
		a11.setResizable(false);
		bb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				a112.setText("");
			try {
			    Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection connect = DriverManager.getConnection(
			          "jdbc:mysql://localhost:3306/mydate?characterEncoding=utf8&useSSL=false&serverTimezone=UTC","root","2511030166");
			  Statement stm = connect.createStatement();
			  ResultSet r = stm.executeQuery("select * from stu where choose='"+aa.getText().trim()+"'");
			  a112.append("学生信息\n");
			  int i=0;
			  while(r.next()) {  
		      a112.append("学生学号:"+r.getString("idstu")+" 学生姓名:"+r.getString("namestu")+" 学生性别:"+
						  r.getString("sexstu")+" 学生年龄:"+r.getString("agestu")+
						  " 学生班级:"+r.getString("classstu")+" 学生专业"+r.getString("majorstu")+"\n");
		      i++;
			  }
			  if(i==0)a112.append("无人选此题目\n");
			}
			  catch (Exception e1){	  			
	  		}
			}
		});
	}
//功能8读取功能
	public void read() {
		JFrame a11=new JFrame("读取");
		JLabel a111=new JLabel("以下是读取到的文件中的所有学生信息和课程设计题目信息");
		JButton b=new JButton("读取");
		JTextArea a112=new JTextArea();
		a11.add(a112);
		a11.add(a111);
		a11.add(b);
		a11.setSize(800,500);
		a11.setVisible(true);
		a11.setLayout(null);
		a111.setFont(new Font("宋体",Font.BOLD, 16));
		a111.setBounds(10,10,500,50);
		a112.setBounds(10,50,700,300);
		b.setBounds(300,380,100,50);
		a11.setResizable(false);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String s;
					FileReader fr=new FileReader("a.txt");
					BufferedReader br=new BufferedReader(fr);
					s=a112.getText();
					while((s=br.readLine())!=null) {
						a112.append(s+"\n");
					}
				}
				catch(Exception e2) {
				}
			}
			
		});
	}
	public static void main(String[] args) {
		new MAIN();
		  }
}
