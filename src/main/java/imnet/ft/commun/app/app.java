package imnet.ft.commun.app;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import imnet.ft.commun.util.ElasticSearchReservedWords;
import imnet.ft.commun.util.GeneratorObjectJson;
import imnet.ft.sid.Index.ImnetAnalyzer;
import imnet.ft.sid.Index.ImnetFilter;
import imnet.ft.sid.IndexBuilder.AnalyzerBuilder;
import imnet.ft.sid.IndexBuilder.FilterBuilder;

public class app {

	public static void main(String[] args) throws IOException {
		GeneratorObjectJson nn = new GeneratorObjectJson();
		
		 List<String> filters = Arrays.asList("lowercase","stop","dsd");

			
			HashMap<String, Map<String,String>> fields2=null;
		//System.out.println(nn.createSettings("imnet","term",fields).string());
	
//			 HashMap<String, Object> propretyf = new HashMap<String, Object>() {{
//				    put("type","custom");
//				    put("tokenizer","_french_");
//				}};
//				 HashMap<String, Object> proprety2f = new HashMap<String, Object>() {{
//					    put("type",filters);
//					}};
//				 HashMap<String, Map<String,Object>> fieldsf = new HashMap<String,  Map<String,Object>>() {{
//					    put("my_analyseur",propretyf);
//					}};
		System.out.println("*********************** Filter **************************");

//		ImnetFilter f1 = new FilterBuilder()
//					.setFilter_object(fieldsf)
//					.build();
		
		
		ImnetFilter f2 = new FilterBuilder()
				.setdefaultfilter(filters)
				.build();
		System.out.println("********"+f2.getfilterCreated().size());
		 HashMap<String, Object> proprety = new HashMap<String, Object>() {{
			    put("type","custom");
			    put("tokenizer","_french_");
			    put("filter",f2.getfilterCreated());
			}};
			 HashMap<String, Object> proprety2 = new HashMap<String, Object>() {{
				    put("type",filters);
				}};
			 HashMap<String, Map<String,Object>> fields = new HashMap<String,  Map<String,Object>>() {{
				    put("my_analyseur",proprety);
				}};
		
		
		
		System.out.println("************** Analyzer ********************");
		
		ImnetAnalyzer a1 = new AnalyzerBuilder()
				//.isDefault()
				.setAnalyzer_Name("my_analyseur")
				.setAnalyzers(fields)
				//.setAnalyzer_Filters(f2.getfilterCreated())
				.build();
		System.out.println(a1.getAnalyzerXContent().bytes().utf8ToString());
	}
	
	
	
	
	
	
	
	
}
