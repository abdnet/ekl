package imnet.ft.sid.IndexBuilder;

import org.elasticsearch.common.xcontent.XContentBuilder;

import imnet.ft.sid.Index.ImnetAnalysis;

public class SettingsBuilder {

		private int shards=1;
		private int replicas=5;
		private ImnetAnalysis analysis;
		
		
		
		
		public int getShards() {
			return shards;
		}
		public int getReplicas() {
			return replicas;
		}
		public ImnetAnalysis getAnalysis() {
			return analysis;
		}
	
		
		
		@Override
		public String toString() {
			return "SettingsBuilder [shards=" + shards + ", replicas=" + replicas + ", analysis=" + analysis + "]";
		}
		
		
		public XContentBuilder getXContentSettings() {
			
			return null;
			
		}
		
}
