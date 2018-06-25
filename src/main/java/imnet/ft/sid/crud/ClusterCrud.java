package imnet.ft.sid.crud;

import org.apache.log4j.Logger;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;

public class ClusterCrud {
	
	
	private TransportClient client;
	
	private static Logger logger = Logger.getLogger(ClusterCrud.class);

	
	public ClusterCrud(TransportClient client) {
		super();
		this.client = client;
	}


	public void createNewIndex(String title,XContentBuilder schema) {
		logger.info("ClusterCrud : Creation d'un nouveau index : En cours");
		CreateIndexResponse createIndex = null;
		
		if(!this.existIndex(title)) {
			createIndex = client.admin()
					.indices()
					.prepareCreate(title.toLowerCase())
					.setSource(schema)
					.execute()
					.actionGet();
			logger.info("ClusterCrud : Creation d'un nouveau index : Ok! ");
		}
		else {
			logger.warn("ClusterCrud : Creation d'un nouveau index ");

		}
	}
	
	
	public void getIndexInfo(String index) {
		
	}
	
	public void getAllIndex(String cluster) {
		
	}
	
	public void updateIndex() {
		
	}
	
	public void deleteIndex(String index) {
		
	}

	
	public boolean existIndex(String str) {
		return (client.admin().indices().prepareExists(str).execute().actionGet().isExists());
	}
}
