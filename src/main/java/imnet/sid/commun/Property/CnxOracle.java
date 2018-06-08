package imnet.sid.commun.Property;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CnxOracle {
	   private static Logger log = LogManager.getLogger(CnxOracle.class);
	   static Connection connection_express = null;

	   private CnxOracle() {
		super();
		// TODO Auto-generated constructor stub
	}



	private static Connection createConnexion() {
           try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        log.info("[ INFO ] Oracle JDBC Driver Registered!");
	        connection_express = DriverManager.getConnection(
                    "jdbc:oracle:thin:@visualstudio:1521:xe", "ged", "ged");
	        
	        return (connection_express==null)?null:connection_express;
			
		} catch (ClassNotFoundException e) {
			log.warn("[ ERROR ] JDBC Driver problem");
            e.printStackTrace();
            return null;
		} catch (SQLException e) {
			log.warn("[ ERROR ] Instance Oracle problem => Check output console");
			e.printStackTrace();
			return null;
		}
	   }
	   
	   
	   
	   protected boolean closeConnexion() {
		   if( this.connection_express==null) return true;
			try {
				this.connection_express.close();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.warn("[ ERROR ] Close connetion problem => Check output console");

				return false;
			}
	   }
	   
	   
	 public static  synchronized  Connection getConnexion() {
		return (connection_express==null)?createConnexion():connection_express; 
	 }
	   
	 
	 
	   
}
