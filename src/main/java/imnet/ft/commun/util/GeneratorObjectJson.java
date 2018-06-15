package imnet.ft.commun.util;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.json.JsonXContent;

public class GeneratorObjectJson {
	
	XContentBuilder index;
	
	public XContentBuilder createSettings(String index,String type,Map<String,Map<String,String>> fields) throws IOException {
		XContentBuilder indexjson = XContentFactory.jsonBuilder()
				.startObject()
				.startObject(ElasticSearchReservedWords.SETTINGS.getText())
				.startObject(ElasticSearchReservedWords.INDEX.getText())
					.field(ElasticSearchReservedWords.NUMBER_OF_SHARDS.getText(),1)
					.field(ElasticSearchReservedWords.NUMBER_OF_REPLICAS.getText(),5)
				.endObject()
				.endObject();
			indexjson = createMappings(indexjson,type,fields);
		
		return indexjson.endObject();		
	}
	
	public XContentBuilder createMappings(XContentBuilder mapping,String type,Map<String,Map<String,String>> fields) {
		try {
			mapping.
					startObject(ElasticSearchReservedWords.MAPPINGS.getText())
						.startObject(type)
						.startObject(ElasticSearchReservedWords.PROPERTIES.getText());
					for(Entry<String,Map<String,String>> entry:fields.entrySet()) {
						Map<String,String> entry2 = entry.getValue();
						 mapping=this.createFields(mapping,entry.getKey(), entry.getValue());
							
					}
					return mapping.endObject().endObject().endObject();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public XContentBuilder createFields(XContentBuilder mapping,String str,Map<String,String> proprety) {
		
		try {
			//XContentBuilder mapping = XContentFactory.jsonBuilder().
			mapping.startObject(str);
			if(proprety.size()>0) {
				for(Entry<String,String> entry:proprety.entrySet()) {
					mapping.field(entry.getKey(),entry.getValue());
				}
				
				return mapping.endObject();
			}else {
				return mapping.endObject();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	
	
	
	public XContentBuilder createAnalysis() {
		return null;
	}
	
	
	public XContentBuilder createAnalyzer() {
		return null;
	}

}
