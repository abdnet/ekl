package app;

import java.io.IOException;

import org.elasticsearch.common.xcontent.NamedXContentRegistry;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentParser;
import org.elasticsearch.common.xcontent.XContentType;

import imnet.ft.sid.Index.ImnetMapping;
import imnet.ft.sid.IndexBuilder.MappingBuilder;
import imnet.ft.sid.entities.MyFields;

public class appTest {
	
	
	public static void main(String[] args) {
		
		MyFields field1 = new MyFields()
				.setFiled_name("document_id")
				.setField_type("integer")
				.setField_analyzer("test")
				.setField_stored(true)
				.setField_indexed(true);
		
		ImnetMapping fields = new MappingBuilder()
				.setFields(field1)
				.setField_others_option(null)
				.build();
		
	
		try {
			XContentBuilder settingsXContent= XContentFactory.jsonBuilder();
			
			XContentBuilder analyzerbis= XContentFactory.jsonBuilder().startObject();
			analyzerbis.field("sdds");
			XContentParser mappingsParser = XContentFactory.xContent(XContentType.JSON).createParser(NamedXContentRegistry.EMPTY,fields.getFieldsXContent(settingsXContent).bytes().utf8ToString());
			analyzerbis.copyCurrentStructure(mappingsParser).endObject();
					System.out.println(fields.getFieldsXContent(analyzerbis).bytes().utf8ToString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
