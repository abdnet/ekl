package imnet.ft.sid.indexing;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.health.ClusterHealthStatus;
import org.elasticsearch.cluster.health.ClusterIndexHealth;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.settings.Settings.Builder;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import imnet.ft.commun.util.ElasticSearchReservedWords;
import imnet.ft.sid.entities.ESConfiguration;

public class ClientTransptES {

	private ESConfiguration configES;
    private TransportClient client ;
    private Properties elasticPro;
	
	public ClientTransptES(ESConfiguration config) {
		super();
		  	elasticPro = new Properties();
			elasticPro.setProperty("host", config.getHostIP());
			elasticPro.setProperty("port", config.getPortTransport());
			elasticPro.setProperty("cluster", config.getCluster());
			elasticPro.setProperty("transport.sniff", config.isTransportSniff());
	}
	
	public ClientTransptES() {
		  
	}
	
	
	@SuppressWarnings("resource")
	private TransportClient getElasticClient() {
	        try {
	        	Settings setting = Settings.builder()
	                    .put("cluster.name", elasticPro.getProperty("cluster"))
	                    .put("client.transport.sniff", Boolean.valueOf(elasticPro.getProperty("transport.sniff"))).build();

	            client = new PreBuiltTransportClient(setting)
	                    .addTransportAddress(new TransportAddress(InetAddress.getByName(elasticPro.getProperty("host")), Integer.valueOf(elasticPro.getProperty("port"))));
	        } catch (UnknownHostException ex) {
	        }
	        return client;
	    }
	
	
	  public TransportClient getInstant() {
	        if (client == null) {
	            client = this.getElasticClient();
	        }
	        return client;
	    }
	
	    
	    
	
}
