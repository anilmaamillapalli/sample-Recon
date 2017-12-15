import java.sql.*;
public class AttributeUpdated {
	
	
	
		//JDBC dirver name and database URL
		static String JDBC_DRIVER;
		static String DB_URL;
		static String USER;
		static String PASS;
		static Connection conn;

		AttributeUpdated(){};
		public AttributeUpdated(String jDriver,String dbUrl,String user,String pass){

				this.JDBC_DRIVER=jDriver;
				this.DB_URL=dbUrl;
				this.USER=user;
				this.PASS=pass;
				try{
					Class.forName(JDBC_DRIVER);
					System.out.println("Connection to database");
					conn = DriverManager.getConnection(DB_URL,USER,PASS);
				}catch(Exception e){e.printStackTrace();}
		}

		public String passwordchange(String lid,String attVal,String attributeName){
			Statement stmt =null;
			
			System.out.println("0");
			
			try{
				stmt=conn.createStatement();
				System.out.println("1");
				//String sql="UPDATE logintable set"+attName=+"'"+attVal+"'"+where userid=+"'"+lid+"'";
				System.out.println(sql);
				stmt.executeUpdate(sql);
	                	return "CHANGEDFN";
			
			}catch(Exception e){e.printStackTrace();}
			
		return "ERROR";
		}




		public static void main(String[] args){

	//	FirstNameChangeUser pwdusr=new FirstNameChangeUser("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","Passw0rd");
		
			//String b=pwdusr.passwordchange("user1","abcdefgh","FIRSTNAME");
	                       String lid="user1";
				String attVal="abcdefgh";
				String attName="FIRSTNAME";
			String sql="UPDATE logintable set"+attName+"='"+attVal+"'where userid='"+lid+"'";
				System.out.println(sql);
		//System.out.println(b);
		}
	}



