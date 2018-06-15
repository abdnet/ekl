package imnet.ft.sid.entities;

public class ESConfiguration {
	
	private String cluster;
	private String hostIP;
	private Double portCLI;
	private Double portTransport;
	private String Name;
	private int node;
	private int shard;
	
	
	
	
	public ESConfiguration(String cluster, String hostIP, Double portCLI, Double portTransport, String name, int node,
			int shard) {
		super();
		this.cluster = cluster;
		this.hostIP = hostIP;
		this.portCLI = portCLI;
		this.portTransport = portTransport;
		Name = name;
		this.node = node;
		this.shard = shard;
	}




	public ESConfiguration() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getCluster() {
		return cluster;
	}




	public void setCluster(String cluster) {
		this.cluster = cluster;
	}




	public String getHostIP() {
		return hostIP;
	}




	public void setHostIP(String hostIP) {
		this.hostIP = hostIP;
	}




	public Double getPortCLI() {
		return portCLI;
	}




	public void setPortCLI(Double portCLI) {
		this.portCLI = portCLI;
	}




	public Double getPortTransport() {
		return portTransport;
	}




	public void setPortTransport(Double portTransport) {
		this.portTransport = portTransport;
	}




	public String getName() {
		return Name;
	}




	public void setName(String name) {
		Name = name;
	}




	public int getNode() {
		return node;
	}




	public void setNode(int node) {
		this.node = node;
	}




	public int getShard() {
		return shard;
	}




	public void setShard(int shard) {
		this.shard = shard;
	}




	@Override
	public String toString() {
		return "ClusterES [cluster=" + cluster + ", hostIP=" + hostIP + ", portCLI=" + portCLI + ", portTransport="
				+ portTransport + ", Name=" + Name + ", node=" + node + ", shard=" + shard + "]";
	}
	
	
	
	
	
	

}
