/*
    Created on 3/13/13
    Last Modified on 4/15/13
    
    @author: Ankit Kumar Singh
    
*/

import java.sql.*;
class insertion{
public static void main(String[] args){
String name[]=new String[100];double tenth[]=new double[100];double twelth[]=new double[100];//Main array
String s1[]=new String[100];
String s2[]=new String[100];
String s3[]=new String[100];

int p=1;
        try{
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   
           Connection con = DriverManager.getConnection("jdbc:odbc:tester");
		
           Statement stmt=con.createStatement();
			Statement st=con.createStatement();
		   
		 ResultSet rs=stmt.executeQuery("SELECT * FROM studyaft");
while (rs.next())
{
s1[p]=rs.getString("Name");
s2[p]=rs.getString("tenth");
s3[p]=rs.getString("twelth");
name[p]=s1[p];
tenth[p]=Double.parseDouble(s2[p].trim());
twelth[p]=Double.parseDouble(s3[p].trim());
if(tenth[p] < 80.3 && twelth[p] < 80.3)
{		  		 
st.executeUpdate("UPDATE studyaft SET tenth11='avg',twelth11='avg' where tenth="+tenth[p]+"AND twelth="+twelth[p] );
System.out.println("-----------------111111----------avg--avg------"+p+"\n");
				 } 

else if(tenth[p] < 80.3 && twelth[p] > 80.3)
{		  		  
st.executeUpdate("UPDATE studyaft SET tenth11='avg',twelth11='good' where tenth="+tenth[p]+"AND twelth="+twelth[p]);
System.out.println("-----------------2222222---------avg--good-----"+p+"\n");
				 }  

else if(tenth[p] >  80.3 && twelth[p] < 80.3)
{		  		
st.executeUpdate("UPDATE studyaft SET tenth11='good',twelth11='avg' where tenth="+tenth[p]+"AND twelth="+twelth[p]);
System.out.println("-----------------333333------good--avg--------"+p+"\n");
				 }  

else if(tenth[p] > 80.3 && twelth[p] > 80.3)
{		  	
st.executeUpdate("UPDATE studyaft SET tenth11='good',twelth11='good' where  tenth="+tenth[p]+"AND twelth="+twelth[p]);
System.out.println("-----------------444444------good--good--------"+p+"\n");
}  	
System.out.println(p+"\t"+name[p]+"\t"+tenth[p]+"\t"+twelth[p]);
p++;

} //end of while
con.close(); 
}
        catch(Exception e){
        System.out.println(e);
        }
    }
}