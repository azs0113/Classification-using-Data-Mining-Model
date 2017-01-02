/*
    Created on 3/13/13
    Last Modified on 4/15/13
    
    @author: Ankit Kumar Singh
    
*/

import java.io.*;
import java.sql.*;
import java.math.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;

class Bayesian extends Frame implements ActionListener
{

//=============================||||||||FRAME||||||||=============================
Frame f;
	Label l1, l2,l3,l4,l5,l6;
	TextField t1, t2,t3,t4,t5,t6;
	Button  b4, b5;
Bayesian()
{

		try{
		
		
			
			f=new Frame();
			f.setLayout(null);
			f.setVisible(true);
			f.setBackground( Color.yellow);
			f.setSize(700, 700);
			l1=new Label("ID");
			l1.setBounds(60, 92, 100, 50);
		    l1.setFont(new Font("Centuary", Font.BOLD, 20));
			l1.setForeground(Color.blue);
			f.add(l1);
			l2=new Label("NAME");
			l2.setBounds(60, 142, 100, 50);
			l2.setFont(new Font("Centuary", Font.BOLD, 20));
			l2.setForeground(Color.blue);
			f.add(l2);
			l3=new Label("REG NO");
			l3.setBounds(60, 192, 100, 50);
			l3.setFont(new Font("Centuary", Font.BOLD, 20));
			l3.setForeground(Color.blue);
			f.add(l3);
			l4=new Label("TENTH");
			l4.setBounds(60, 242, 100, 50);
			l4.setFont(new Font("Centuary", Font.BOLD, 20));
			l4.setForeground(Color.blue);
			f.add(l4);
			l5=new Label("TWELFTH");
			l5.setBounds(60, 292, 100, 50);
			l5.setFont(new Font("Centuary", Font.BOLD, 20));
			l5.setForeground(Color.blue);
			f.add(l5);
		    l6=new Label("ACADEMIC STATUS");
			l6.setFont(new Font("Centuary", Font.BOLD, 20));
			l6.setForeground(Color.blue);
			l6.setBounds(60, 490, 200, 50);
			f.add(l6);
			
			
			
			
			t1=new TextField();
			t1.setBounds(190, 100, 100, 30);
			t1.setFont(new Font("Centuary", Font.BOLD, 20));
		    t1.setForeground(Color.green);
			f.add(t1);
			t2=new TextField();
			t2.setBounds(190, 150, 100, 30);
			t2.setFont(new Font("Centuary", Font.BOLD, 20));
		    t2.setForeground(Color.green);
			f.add(t2);
			t3=new TextField();
			t3.setBounds(190, 200, 100, 30);
			t3.setFont(new Font("Centuary", Font.BOLD, 20));
		    t3.setForeground(Color.green);
			f.add(t3);
			t4=new TextField();
			t4.setBounds(190, 250, 100, 30);
			t4.setFont(new Font("Centuary", Font.BOLD, 20));
		    t4.setForeground(Color.green);
			f.add(t4);
			t5=new TextField();
			t5.setBounds(190, 300, 100, 30);
			t5.setFont(new Font("Centuary", Font.BOLD, 20));
		    t5.setForeground(Color.green);
			f.add(t5);
			t6=new TextField();
			t6.setBounds(280, 500, 300, 30);
			t6.setFont(new Font("Centuary", Font.BOLD, 20));
		    t6.setForeground(Color.red);
			f.add(t6);
           
			
			b4= new Button("CLOSE");
			b4.setBounds(250, 400, 75, 40);
			b4.setBackground( Color.orange);
			b4.setFont(new Font("Centuary", Font.BOLD, 20));
		    b4.setForeground(Color.blue);
			f.add(b4);
			b4.addActionListener(this);
			
			
			
			b5= new Button("EXECUTE");
			b5.setBounds(100, 400, 100, 40);
			b5.setBackground( Color.orange);
			b5.setFont(new Font("Centuary", Font.BOLD, 20));
		    b5.setForeground(Color.blue);
			f.add(b5);
			b5.addActionListener(this);
			
		
			}catch(Exception e){}
		
		
		}//ends Constructor	
	
public void actionPerformed(ActionEvent ae){

		try{
			int i=1;
			System.out.print("SNo.\t"+"ID\t"+"NAME\t\t"+"REGNO\t\t"+"TENTH\t"+"TWELTH\n");
			if(ae.getSource()==b4){
				
				
				//c.close();
				f.dispose();
				
		
				}
			
			
			
			   else if(ae.getSource()==b5){
			       double tenth1=0;
                   double twelth1=0;
                   String good,avg;
String tenth11,twelth11;
tenth11=twelth11=null;
                   good="good";
                   avg="avg";
			          String id=t1.getText();
			        System.out.print("\n");
					   System.out.print(i++ +"\t");
					System.out.print(id+"\t ");
				      String name=t2.getText();
					System.out.print(name+"\t   " );	
					  String regno=t3.getText();
					System.out.print(regno+"\t      ");
					     tenth1=Double.parseDouble(t4.getText());
					System.out.print(tenth1+"\t ");
					  twelth1=Double.parseDouble(t5.getText());
					System.out.print(twelth1+"\t ");
					
					if((tenth1 >= 80.3) && (twelth1 >= 80.3) )
{
tenth11=good;
twelth11=good;
}
else if((tenth1 < 80.3) && (twelth1 >= 80.3))
{
tenth11=avg;
twelth11=good;
}
else if((twelth1 < 80.3) && (tenth1 < 80.3))
{
tenth11=avg;
twelth11=avg;
}
else if((tenth1>=80.3) && (twelth1<80.3))
{
tenth11=good;
twelth11=avg;
}
System.out.println("------------------------------------------------");
System.out.println("tenth="+tenth11+"\t"+"twelth="+twelth11);
System.out.println("------------------------------------------------");

System.out.println("\t \t \n \t \t  \tProgram for studyaft Classification \t  \t \n");

//----------------------------------------------------------------------------

System.out.println("---------------------step1:counting no. of students in each step----------------");

try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection connect = DriverManager.getConnection("jdbc:odbc:tester");

Statement sest = connect.createStatement();

float counter1=0,counter2=0, counttngps=0;

ResultSet rs0 = sest.executeQuery("SELECT * FROM studyaft ");
while(rs0.next())
{
int gp1=rs0.getInt("grp");
if(gp1==1)
{ 
counter1++;//no. of students in grp1
}
}
System.out.println("Total no. of students in grp1: \t"+counter1);

ResultSet rs1 = sest.executeQuery("SELECT * FROM studyaft ");
while(rs1.next())
{
int gp2=rs1.getInt("grp");
if(gp2==2)
{ 
counter2++;//no. of students in grp2
}
}
System.out.println("Total no. of students in grp2: \t "+counter2+"\n");

System.out.println("----------------------------Total no. of grps---------------------------------\n");

ResultSet rs2 = sest.executeQuery("SELECT * FROM studyaft ");
while(rs2.next())
{
int tngps=rs2.getInt("grp");//tngps:total no. of grps
if(tngps!=0)
{ 
counttngps++;
}
}
System.out.println("Total no. of students: \t"+counttngps+"\n");

System.out.println("--------------------computing probability of grp1 and grp2----------------------\n");


float pry=0,prn=0;//P(at_risk= yes) and P(at_risk = no) 
pry=counter2/counttngps;
System.out.println("P(at_risk= yes(grp2)):: Probability of at risk yes="+pry);
prn=counter1/counttngps;
System.out.println("P(at_risk= no(grp1)):: Probability of at risk no=  "+prn+"\n");

System.out.println("--------------------count based on class and grp1 -----------------------------\n");
if((tenth11.equals("avg"))&&(twelth11.equals("avg")))//start of if1
{
//System.out.println(name);
float ca2=0, ca1=0, cg2=0, cg1=0;
ResultSet rs3 = sest.executeQuery("SELECT * FROM studyaft ");
while(rs3.next())
{
String s10=rs3.getString("tenth11");
int sg=rs3.getInt("grp");
if(s10.equals("avg")&& sg==2)
{ 
ca2++;//no. of students with  tenth marks avg and also in at risk yes
}
}

System.out.println("p of tenth avg and at risk yes:grp2=\t"+ca2);


System.out.println("------------------------------------------1111--------------------------------------");

ResultSet rs4 = sest.executeQuery("SELECT * FROM studyaft ");
while(rs4.next())
{
String s11=rs4.getString("tenth11");
int sg=rs4.getInt("grp");
if(s11.equals("avg")&& sg==1)
{ 
ca1++;//no. of students with  tenth marks avg and also in at risk no
}
}
System.out.println("p of tenth avg and at risk no:grp1=\t"+ca1);

System.out.println("------------------------------------------1111--------------------------------------");

ResultSet rs5 = sest.executeQuery("SELECT * FROM studyaft ");
while(rs5.next())
{
String s12=rs5.getString("twelth11");
int sg=rs5.getInt("grp");
if(s12.equals("avg")&& sg==2)
{ 
cg2++;//no. of students with  twelth marks avg and also in at risk yes
}
}
System.out.println("p of twelth avg and at risk yes:grp2=\t"+cg2);


System.out.println("------------------------------------------1111--------------------------------------");

ResultSet rs6 = sest.executeQuery("SELECT * FROM studyaft ");
while(rs6.next())
{
String s13=rs6.getString("twelth11");
int sg=rs6.getInt("grp");
if(s13.equals("avg")&& sg==1)
{ 
cg1++;//no. of students with  twelth marks avg and also in at risk no
}
}
System.out.println("p of twelth avg and at risk no:grp1=\t"+cg1);

System.out.println("------------------------------------end of count1--------------------------------------------");


System.out.println("--------------------Probability based on class and grp1 ------------------------\n");

float pa2 = ca2/counter2;//P(5TH SEM(tenth)=AVG|at_risk= yes)=2/2 
System.out.println("Probability of tenth avg and grp2:yes =\t   "+ca2+"/"+counter2+"   =  "+pa2);

float pa1 = ca1/counter1;//P(5TH SEM(tenth)=AVG|at_risk= no)=1/3
System.out.println("Probability of tenth avg and grp1:no =\t   "+ca1+"/"+counter1+"   =  "+pa1);

float pg2 = cg2/counter2;//P(6TH SEM(twelth)=AVG|at_risk= yes) = 1/2
System.out.println("Probability of twelth avg and grp2:yes =  "+cg2+"/"+counter2+"   =  "+pg2);

float pg1 =cg1/counter1;//P(6TH SEM(twelth)=AVG|at_risk= no) = 2/3
System.out.println("Probability of twelth avg and grp1:no =\t  "+cg1+"/"+counter1+"   =  "+pg1);

System.out.println("\n-----------------------------decision:pxyes:pxno-1------------------------------\n");


float pxyes2=pa2*pg2;//P(X|at_risk = yes) = P(5TH SEM(tenth)=Avg|at_risk= yes) * P(6TH SEM(twelth)=Avg|at_risk=yes):::(1/2)*(2/2):::0.5

System.out.println("Probability of X at risk: yes=\t" +pxyes2);//P(X|at_risk = yes)

float pxno1=pa1*pg1;//P(X|at_risk = no) = P(5TH SEM(tenth)=Avg|at_risk= no) *  P(6TH SEM(twelth)=Avg|at_risk=no):::(1/3)*(2/3):::0.22

System.out.println("Probability of X at risk: no=\t" +pxno1);//P(X|at_risk = no) 

System.out.println("completed all computations, now final step find if student at risk or not \n " );


System.out.println("--------------------------------------------------------------------------------");

double inrisk =(pxyes2)*(pry);
System.out.println("Probability of student in risk:\t" +inrisk);
double notinrisk = (pxno1)*(prn);
System.out.println("Probability of student not in risk:\t" +notinrisk);
if(inrisk > notinrisk)
{

System.out.println("\n-----------------------------STUDENT IS AT RISK-------------------------------\n");
t6.setText("      STUDENT IS AT RISK");
//System.exit(0);
}
else
{
System.out.println("\n-----------------------------STUDENT IS NOT AT RISK---------------------------\n");
t6.setText("  STUDENT IS NOT AT RISK");
//System.exit(0);
}
}//end of if1

System.out.println("-------------------------------end of probability1------------------------------------------------");

System.out.println("--------------------count based on class and grp2 -----------------------------\n");
if((tenth11.equals("good"))&&(twelth11.equals("good")))//start of if2
{
float ca22=0, ca12=0, cg22=0, cg12=0;
ResultSet rs32 = sest.executeQuery("SELECT * FROM studyaft ");
while(rs32.next())
{
String s102=rs32.getString("tenth11");
int sg2=rs32.getInt("grp");
if(s102.equals("good")&& sg2==2)
{ 
ca22++;//no. of students with  tenth marks good and also in at risk yes
}
}

System.out.println("p of tenth good and at risk yes:grp2=\t"+ca22);


System.out.println("------------------------------------------2222--------------------------------------");

ResultSet rs42 = sest.executeQuery("SELECT * FROM studyaft ");
while(rs42.next())
{
String s112=rs42.getString("tenth11");
int sg2=rs42.getInt("grp");
if(s112.equals("good")&& sg2==1)
{ 
ca12++;//no. of students with  tenth marks good and also in at risk no
}
}
System.out.println("p of tenth good and at risk no:grp1=\t"+ca12);

System.out.println("------------------------------------------2222--------------------------------------");

ResultSet rs52 = sest.executeQuery("SELECT * FROM studyaft ");
while(rs52.next())
{
String s122=rs52.getString("twelth11");
int sg2=rs52.getInt("grp");
if(s122.equals("good")&& sg2==2)
{ 
cg22++;//no. of students with  twelth marks good and also in at risk yes
}
}
System.out.println("p of twelth good and at risk yes:grp2=\t"+cg22);


System.out.println("-----------------------------------------2222---------------------------------------");

ResultSet rs62 = sest.executeQuery("SELECT * FROM studyaft ");
while(rs62.next())
{
String s132=rs62.getString("twelth11");
int sg2=rs62.getInt("grp");
if(s132.equals("good")&& sg2==1)
{ 
cg12++;//no. of students with  twelth marks good and also in at risk no
}
}
System.out.println("p of twelth good and at risk no:grp1=\t"+cg12);

System.out.println("------------------------------------end of count2--------------------------------------------");


System.out.println("--------------------Probability based on class and grp2 ------------------------\n");

float pa22 = ca22/counter2;//P(5TH SEM(tenth)=good|at_risk= yes)=2/2 
System.out.println("Probability of tenth good and grp2:yes =\t   "+ca22+"/"+counter2+"   =  "+pa22);

float pa12 = ca12/counter1;//P(5TH SEM(tenth)=good|at_risk= no)=1/3
System.out.println("Probability of tenth good and grp1:no =\t   "+ca12+"/"+counter1+"   =  "+pa12);

float pg22 = cg22/counter2;//P(6TH SEM(twelth)=good|at_risk= yes) = 1/2
System.out.println("Probability of twelth good and grp2:yes =  "+cg22+"/"+counter2+"   =  "+pg22);

float pg12 =cg12/counter1;//P(6TH SEM(twelth)=good|at_risk= no) = 2/3
System.out.println("Probability of twelth good and grp1:no =\t  "+cg12+"/"+counter1+"   =  "+pg12);

System.out.println("\n-----------------------------decision:pxyes:pxno:222222------------------------------\n");


float pxyes22=pa22*pg22;//P(X|at_risk = yes) = P(5TH SEM(tenth)=Avg|at_risk= yes) * P(6TH SEM(twelth)=Avg|at_risk=yes):::(1/2)*(2/2):::0.5

System.out.println("Probability of X at risk: yes=\t" +pxyes22);//P(X|at_risk = yes)

float pxno12=pa12*pg12;//P(X|at_risk = no) = P(5TH SEM(tenth)=Avg|at_risk= no) *  P(6TH SEM(twelth)=Avg|at_risk=no):::(1/3)*(2/3):::0.22

System.out.println("Probability of X at risk: no=\t" +pxno12);//P(X|at_risk = no) 

System.out.println("completed all computations, now final step find if student at risk or not \n " );


System.out.println("--------------------------------------------------------------------------------");

double inrisk2 =(pxyes22)*(pry);
System.out.println("Probability of student in risk:\t" +inrisk2);
double notinrisk2 = (pxno12)*(prn);
System.out.println("Probability of student not in risk:\t" +notinrisk2);
if(inrisk2 > notinrisk2)
{

System.out.println("\n-----------------------------STUDENT IS AT RISK-------------------------------\n");
t6.setText("      STUDENT IS AT RISK");
//System.exit(0);
}
else
{
System.out.println("\n-----------------------------STUDENT IS NOT AT RISK---------------------------\n");
t6.setText("  STUDENT IS NOT AT RISK");
//System.exit(0);
}

}//end of if2
System.out.println("-----------------------------------end of probability2---------------------------------------------");

System.out.println("--------------------||||||||||||||||||||||||||||||||||||||||||| -----------------------------\n");

System.out.println("--------------------count based on class and grp3 -----------------------------\n");
if((tenth11.equals("good"))&&(twelth11.equals("avg")))//start of if3
{
//System.out.println(name);
float ca222=0, ca122=0, cg222=0, cg122=0;
ResultSet rs322 = sest.executeQuery("SELECT * FROM studyaft ");
while(rs322.next())
{
String s1022=rs322.getString("tenth11");
int sg22=rs322.getInt("grp");
if(s1022.equals("good")&& sg22==2)
{ 
ca222++;//no. of students with  tenth marks good and also in at risk yes grp2
}
}

System.out.println("p of tenth good and at risk yes:grp2=\t"+ca222);

System.out.println("------------------------------------------3333--------------------------------------");

ResultSet rs422 = sest.executeQuery("SELECT * FROM studyaft ");
while(rs422.next())
{
String s1122=rs422.getString("tenth");
int sg22=rs422.getInt("grp");
if(s1122.equals("good")&& sg22==1)
{ 
ca122++;//no. of students with  tenth marks good and also in at risk no grp1
}
}
System.out.println("p of tenth good and at risk no:grp1=\t"+ca122);

System.out.println("------------------------------------------3333--------------------------------------");

ResultSet rs522 = sest.executeQuery("SELECT * FROM studyaft ");
while(rs522.next())
{
String s1222=rs522.getString("twelth11");
int sg22=rs522.getInt("grp");
if(s1222.equals("avg")&& sg22==2)
{ 
cg222++;//no. of students with  twelth marks avg and also in at risk yes grp2
}
}
System.out.println("p of twelth avg and at risk yes:grp2=\t"+cg222);


System.out.println("------------------------------------------3333--------------------------------------");

ResultSet rs622 = sest.executeQuery("SELECT * FROM studyaft ");
while(rs622.next())
{
String s1322=rs622.getString("twelth11");
int sg22=rs622.getInt("grp");
if(s1322.equals("avg")&& sg22==1)
{ 
cg122++;//no. of students with  twelth marks avg and also in at risk no grp1
}
}
System.out.println("p of twelth avg and at risk no:grp1=\t"+cg122);

System.out.println("------------------------------------end of count3--------------------------------------------");


System.out.println("--------------------Probability based on class and grp3 ------------------------\n");

float pa222 = ca222/counter2;//P(5TH SEM(tenth)=good|at_risk= yes)=2/2 
System.out.println("Probability of tenth good and grp2:yes =\t   "+ca222+"/"+counter2+"   =  "+pa222);

float pa122 = ca122/counter1;//P(5TH SEM(tenth)=good|at_risk= no)=1/3
System.out.println("Probability of tenth good and grp1:no =\t   "+ca122+"/"+counter1+"   =  "+pa122);

float pg222 = cg222/counter2;//P(6TH SEM(twelth)=AVG|at_risk= yes) = 1/2
System.out.println("Probability of twelth avg and grp2:yes =  "+cg222+"/"+counter2+"   =  "+pg222);

float pg122 =cg122/counter1;//P(6TH SEM(twelth)=AVG|at_risk= no) = 2/3
System.out.println("Probability of twelth avg and grp1:no =\t  "+cg122+"/"+counter1+"   =  "+pg122);

System.out.println("\n-----------------------------decision:pxyes:pxno-3-----------------------------\n");


float pxyes222=pa222*pg222;//P(X|at_risk = yes) = P(5TH SEM(tenth)=Avg|at_risk= yes) * P(6TH SEM(twelth)=Avg|at_risk=yes):::(1/2)*(2/2):::0.5

System.out.println("Probability of X at risk: yes=\t" +pxyes222);//P(X|at_risk = yes)

float pxno122=pa122*pg122;//P(X|at_risk = no) = P(5TH SEM(tenth)=Avg|at_risk= no) *  P(6TH SEM(twelth)=Avg|at_risk=no):::(1/3)*(2/3):::0.22

System.out.println("Probability of X at risk: no=\t" +pxno122);//P(X|at_risk = no) 

System.out.println("completed all computations, now final step find if student at risk or not \n " );


System.out.println("--------------------------------------------------------------------------------");

double inrisk22 =(pxyes222)*(pry);
System.out.println("Probability of student in risk:\t" +inrisk22);
double notinrisk22= (pxno122)*(prn);
System.out.println("Probability of student not in risk:\t" +notinrisk22);
if(inrisk22 > notinrisk22)
{

System.out.println("\n-----------------------------STUDENT IS AT RISK-------------------------------\n");
t6.setText("      STUDENT IS AT RISK");
//System.exit(0);
}
else
{
System.out.println("\n-----------------------------STUDENT IS NOT AT RISK---------------------------\n");
t6.setText("  STUDENT IS NOT AT RISK");
//System.exit(0);
}

}//end of if3

System.out.println("-------------------------------end of probability3------------------------------------------------");
System.out.println("--------------------|||||||||||||||||||||||||||||||||||||||||||33 -----------------------------\n");
System.out.println("--------------------|||||||||||||||||||||||||||||||||||||||||||4start -----------------------------\n");


System.out.println("--------------------count based on class and grp 4 -----------------------------\n");
if((tenth11.equals("avg"))&&(twelth11.equals("good")))//start of if1
{
//System.out.println(name);
float ca2222=0, ca1222=0, cg2222=0, cg1222=0;
ResultSet rs3222 = sest.executeQuery("SELECT * FROM studyaft ");
while(rs3222.next())
{
String s10222=rs3222.getString("tenth11");
int sg222=rs3222.getInt("grp");
if(s10222.equals("avg")&& sg222==2)
{ 
ca2222++;//no. of students with  tenth marks avg and also in at risk yes grp2
}
}

System.out.println("p of tenth avg and at risk yes:grp2=\t"+ca2222);

System.out.println("------------------------------------------4444--------------------------------------");

ResultSet rs4222 = sest.executeQuery("SELECT * FROM studyaft ");
while(rs4222.next())
{
String s11222=rs4222.getString("tenth");
int sg222=rs4222.getInt("grp");
if(s11222.equals("avg")&& sg222==1)
{ 
ca1222++;//no. of students with  tenth marks avg and also in at risk no grp1
}
}
System.out.println("p of tenth avg and at risk no:grp1=\t"+ca1222);

System.out.println("------------------------------------------4444--------------------------------------");

ResultSet rs5222 = sest.executeQuery("SELECT * FROM studyaft ");
while(rs5222.next())
{
String s12222=rs5222.getString("twelth11");
int sg222=rs5222.getInt("grp");
if(s12222.equals("good")&& sg222==2)
{ 
cg2222++;//no. of students with  twelth marks good and also in at risk yes grp2
}
}
System.out.println("p of twelth good and at risk yes:grp2=\t"+cg2222);


System.out.println("------------------------------------------4444--------------------------------------");

ResultSet rs6222 = sest.executeQuery("SELECT * FROM studyaft ");
while(rs6222.next())
{
String s13222=rs6222.getString("twelth11");
int sg222=rs6222.getInt("grp");
if(s13222.equals("good")&& sg222==1)
{ 
cg1222++;//no. of students with  twelth marks good and also in at risk no grp1
}
}
System.out.println("p of twelth good and at risk no:grp1=\t"+cg1222);

System.out.println("------------------------------------end of count4--------------------------------------------");


System.out.println("--------------------Probability based on class and grp4 ------------------------\n");

float pa2222 = ca2222/counter2;//P(5TH SEM(tenth)=AVG|at_risk= yes)=2/2 
System.out.println("Probability of tenth avg and grp2:yes =\t   "+ca2222+"/"+counter2+"   =  "+pa2222);

float pa1222 = ca1222/counter1;//P(5TH SEM(tenth)=AVG|at_risk= no)=1/3
System.out.println("Probability of tenth avg and grp1:no =\t   "+ca1222+"/"+counter1+"   =  "+pa1222);

float pg2222 = cg2222/counter2;//P(6TH SEM(twelth)=good|at_risk= yes) = 1/2
System.out.println("Probability of twelth good and grp2:yes =  "+cg2222+"/"+counter2+"   =  "+pg2222);

float pg1222 =cg1222/counter1;//P(6TH SEM(twelth)=good|at_risk= no) = 2/3
System.out.println("Probability of twelth good and grp1:no =\t  "+cg1222+"/"+counter1+"   =  "+pg1222);

System.out.println("\n-----------------------------decision:pxyes:pxno-4-----------------------------\n");


float pxyes2222=pa2222*pg2222;//P(X|at_risk = yes) = P(5TH SEM(tenth)=Avg|at_risk= yes) * P(6TH SEM(twelth)=good|at_risk=yes):::(1/2)*(2/2):::0.5

System.out.println("Probability of X at risk: yes=\t" +pxyes2222);//P(X|at_risk = yes)

float pxno1222=pa1222*pg1222;//P(X|at_risk = no) = P(5TH SEM(tenth)=Avg|at_risk= no) *  P(6TH SEM(twelth)=good|at_risk=no):::(1/3)*(2/3):::0.22

System.out.println("Probability of X at risk: no=\t" +pxno1222);//P(X|at_risk = no) 

System.out.println("completed all computations, now final step find if student at risk or not \n " );


System.out.println("--------------------------------------------------------------------------------");

double inrisk222 =(pxyes2222)*(pry);
System.out.println("Probability of student in risk:\t" +inrisk222);
double notinrisk222 = (pxno1222)*(prn);
System.out.println("Probability of student not in risk:\t" +notinrisk222);
if(inrisk222 > notinrisk222)
{

System.out.println("\n-----------------------------STUDENT IS AT RISK-------------------------------\n");
t6.setText("      STUDENT IS AT RISK");
//System.exit(0);
}
else
{
System.out.println("\n-----------------------------STUDENT IS NOT AT RISK---------------------------\n");
t6.setText("  STUDENT IS NOT AT RISK");
//System.exit(0);
}

}//end of if1

System.out.println("-------------------------------end of probability1------------------------------------------------");
}//end of try
catch(Exception e) 
{System.out.println(e);}

			}  
		}//end of try
		catch(Exception e){}
		}//end of action
//===============================||||||||||||||||||||||END OF FRAME|||||||||||||||||||||
public static void main(String[] args) 
{
new Bayesian();
}//end of public
}//end of class


