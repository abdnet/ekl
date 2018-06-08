package imnet.sid.fulltext.dao;

import java.sql.Connection;

import imnet.sid.commun.Property.CnxOracle;
import imnet.sid.fulltext.entities.Document;

public class DocuementDao implements DAO<Document>{
	
	private Connection connection =CnxOracle.getConnexion();
	
	

	public Document create(Document obj) {
		// TODO Auto-generated method stub
		return null;
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
	

}
