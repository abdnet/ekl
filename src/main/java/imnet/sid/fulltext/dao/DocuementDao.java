package imnet.sid.fulltext.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import imnet.sid.commun.Property.CnxOracle;
import imnet.sid.commun.util.OracleData;
import imnet.sid.fulltext.entities.Document;

public class DocuementDao implements DAO<Document>{
	
	private Connection connection =CnxOracle.getConnexion();
	
	

	public boolean create(Document obj) {
		  System.out.println("[ INFO ] Processus de persistence");

		 try {
			PreparedStatement insert_doc = connection.prepareStatement(OracleData.DB_ADD_ONE_DOC);
			if(obj.isValid()) {
				insert_doc.setString(1, obj.getDocuement_title());
				insert_doc.setString(2, obj.getDocuement_author());
				insert_doc.setString(3, obj.getDocuement_path());
				insert_doc.setDate(4, obj.getDate_archive());
				insert_doc.setString(5, obj.getDocuement_lang());
				insert_doc.setString(6,obj.getDocuement_type());
				insert_doc.executeUpdate();
				
				System.out.println("\t[ INFO ] Le doc "+obj.getDocuement_title() +" a été bien ajoute");
				return true;
			}else {
				System.out.println("\t[ ERROR ] Objet document \n"+obj);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

		return false;
	}

	public Document update(Document objet) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int obj) {
		// TODO Auto-generated method stub
		
	}

	public Document read(int obj) {
		
		
		
		return null;
	}

	public int getSequence() {
			//
		try {
			PreparedStatement get_sequence_T = connection.prepareStatement(OracleData.DB_T_ID_SEQUENCE);
			ResultSet id =get_sequence_T.executeQuery();
      	  while(id.next()) {
      		  System.out.println("\t[ INFO ] current id "+id.getInt(1));
      		  return id.getInt(1);
      	  }
      		  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	
	

}
