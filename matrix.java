/*
    Created on 3/13/13
    Last Modified on 4/15/13
    
    @author: Ankit Kumar Singh
    
*/
import java.sql.*;
class matrix{
public static void main(String[] args)  {
String name[]=new String[50];double tenth[]=new double[50];double twelth[]=new double[50];//Main array
String s1[]=new String[50];
String s2[]=new String[50];
String s3[]=new String[50];
Connection con=null;
ResultSet rs=null;
int p=0;
try
{

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

con=DriverManager.getConnection("jdbc:odbc:tester");

}//end of try

catch (Exception sqle)
{System.out.println("Unable to load driver...");}
try
{
String queryString=("SELECT * FROM studyaft");
Statement stmt=con.createStatement();
rs=stmt.executeQuery(queryString);
try
{
System.out.println("No \tName\tTenth\tTwelth");
while (rs.next())
{
s1[p]=rs.getString("Name");
s2[p]=rs.getString("tenth");
s3[p]=rs.getString("twelth");
name[p]=s1[p];
tenth[p]=Double.parseDouble(s2[p].trim());
twelth[p]=Double.parseDouble(s3[p].trim());

System.out.println(p+"\t"+name[p]+"\t"+tenth[p]+"\t"+twelth[p]);
p++;
} //end of while
}//end of try
catch(NullPointerException ne){}
}//end of try
catch (SQLException sqle)
{System.out.println("Some SQL error occured.");}
System.out.println("-------------------------------------------------------------------------------- ");
 System.out.println("value of p(no. of columns):"+p);
 
System.out.println("-------------------------------------------------------------------------------- ");
double [][] array;
 array= new double[2][p];
for (int u = 0; u < p; u++)
 {

  array[0][u] = tenth[u];
  array[1][u] = twelth[u];
 }
  for (int u = 0; u < 2; u++)
 {
 System.out.print("[");
  for (int v = 0; v < p; v++)
  {

  System.out.print(array[u][v]+"\t");
  } System.out.println(" ]");
 }
System.out.println("-------------------------------------------------------------------------------- ");
  System.out.println("Row size= " + array.length);
  System.out.println("Column size = " + array[1].length);
  
System.out.println("-------------------------------------------------------------------------------- ");
  //getdata();
  outputArray(array);
  
  }
  
 public static void outputArray(double[][] array) {
 int rowSize = array.length;
 int columnSize = array[0].length;
 for(int i = 0; i <= array.length-1; i++) {
 System.out.print("[");
 for(int j = 0; j <= array[0].length-1; j++) {
 System.out.print("  ("+i+j+") "+ array[i][j]);
 }
 System.out.println(" ]");
 }

double c11[][]=new double[50][50];double c12[][]=new double[50][50];//centroid 1
double c21[][]=new double[50][50];double c22[][]=new double[50][50];//centroid 2

c11[0][0]=array[0][0];c12[0][1]=array[1][0];
c21[0][0]=array[0][1];c22[0][1]=array[1][1];
           
		 System.out.println("--------------------------------------------------------");
	      System.out.println("old centroid 1: ("+c11[0][0]+","+c12[0][1]+")");
	       
	      
		 
		 System.out.println("old centroid 2: ("+c21[0][0]+","+c22[0][1]+")");
	       
		   
		   
	double d0[]=new double[50];
	double d1[]=new double[50];
	
	double g0[][]=new double[50][50];
	double g1[][]=new double[50][50];
	
	
	
	
	int n=array[0].length;	   
	
System.out.println("--------------------D0 and G0 formation starts-----------------");
System.out.println("");

try
{

double newcenter[]=new double[50];
double newcenter2[]=new double[50];
double new2centerx[]=new double[50];
double new2centery[]=new double[50];
 newcenter[0]=0;
 new2centerx[0]=0;
 new2centery[0]=0;
 newcenter2[0]=0;
  newcenter[1]=0;
 new2centerx[1]=0;
 new2centery[1]=0;
 newcenter2[1]=0;
 

int x=1;
while(x<=100)
{
int t1=0,t2=0;

int m=1;
 for(int j = 0; j <=array[1].length-1; j++) {
d0[n]=Math.sqrt(Math.pow(( c11[0][0]-array[0][j] ), 2) + Math.pow((c12[0][1] - array[1][j]), 2));	
d1[n]=Math.sqrt(Math.pow(( c21[0][0]-array[0][j] ), 2) + Math.pow((c22[0][1] - array[1][j]), 2));		
System.out.println("  (d0"+n+")"+d0[n]+"\t\t");
System.out.println("  (d1"+n+")"+d1[n]);
if(d0[n]<d1[n])
{
t1++;
g0[n][x]=1;
g1[n][x]=0;
System.out.println("(g0"+n+x+")"+g0[n][x]+" \t ");
System.out.println("(g1"+n+x+")"+g1[n][x]+"  ");

System.out.println("----------------------group1 member :------------"+array[0][j]+","+array[1][j]+"----"+"-group-1");

try{

           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection con = DriverManager.getConnection("jdbc:odbc:tester");
           Statement st=con.createStatement();
		    int i=st.executeUpdate("UPDATE studyaft SET grp=1 WHERE id=" +m);
           System.out.println("Row is added in grp1");
           con.close(); 
		   
           }
        catch(Exception e){
        System.out.println(e);
        }
m++;
newcenter[x] = (newcenter[x]+array[0][j]);
newcenter2[x] = newcenter2[x]+array[1][j];
}

else if(d0[n]>d1[n])
{
t2++;
g0[n][x]=0;
g1[n][x]=1;
System.out.println("(g0"+n+x+")"+g0[n][x]+" \t ");
System.out.println("(g1"+n+x+")"+g1[n][x]+"  ");

System.out.println("----------------------group2 member :------------"+array[0][j]+","+array[1][j]+"----"+"-group-2");

try{



           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection con = DriverManager.getConnection("jdbc:odbc:tester");
           Statement st=con.createStatement();
		   int i=st.executeUpdate("UPDATE studyaft SET grp=2 WHERE id=" +m);
           System.out.println("Row is added in grp2");
           con.close(); 
           }
        catch(Exception e){
        System.out.println(e);
        }
		m++;
new2centerx[x] = new2centerx[x]+array[0][j];
new2centery[x] = new2centery[x]+array[1][j];


}

n--;
	  }//end of for2
	   System.out.print(" ");
//}//end of for1
//||||||||||||||||||||||||||||we need to put if condition for comparison here |||||||||||||||||||||||||||||||

newcenter[x] =newcenter[x]/t1;
newcenter2[x] =newcenter2[x]/t1;
new2centerx[x] =new2centerx[x]/t2;
new2centery[x] =new2centery[x]/t2;
System.out.println("-------------------------------------------------------- ");

System.out.print("new centeroid1 (x,y):  ");
System.out.println("("+newcenter[x]+","+newcenter2[x]+")");
System.out.print("new centeroid2 (x,y):  ");
System.out.println("("+new2centerx[x]+","+new2centery[x]+")");

System.out.println("-------------------------------------------------------- ");
c11[0][0]=newcenter[x];c12[0][1]=newcenter2[x];
c21[0][0]=new2centerx[x];c22[0][1]=new2centery[x];


//System.out.println("--------------------------part2---------------------------------------------------- ");

System.out.println("----------------------------------------------------------------------------------- ");
n=array[0].length;

/*System.out.println("centroidx of 1st time:"+(x-1)+":"+newcenter[x-1]);
System.out.println("centroidx of 2nd time:"+x+":"+newcenter[x]);
System.out.println("centroidx of 1st time:"+(x-1)+":"+new2centerx[x-1]);
System.out.println("centroidx of 2nd time:"+x+":"+new2centerx[x]);

System.out.println("centroidy of 1st time:"+(x-1)+":"+newcenter2[x-1]);
System.out.println("centroidy of 2nd time:"+x+":"+newcenter2[x]);
System.out.println("centroidy of 1st time:"+(x-1)+":"+new2centery[x-1]);
System.out.println("centroidy of 2nd time:"+x+":"+new2centery[x]);*/

if((newcenter[x-1]==newcenter[x]) && (newcenter2[x-1]==newcenter2[x]) && (new2centerx[x-1]==new2centerx[x]) && (new2centery[x-1]==new2centery[x]))
{
System.out.println("the end");
break;
}
x++;

System.out.println("----------------------members in group1---------------------------------- ");

System.out.println("group1: "+t1 );
System.out.println("------------------------members in group2-------------------------------- ");
System.out.println("group2: "+t2);
System.out.println("-------------------------------------------------------- ");
System.out.println("-------------------no of iterations---------"+x);
}//end of while

}//end of try


catch(Exception e)
{}
System.out.println("--------------------D0 and G0 matrix formed-----------------");
}//end of public void main
}//end of class
