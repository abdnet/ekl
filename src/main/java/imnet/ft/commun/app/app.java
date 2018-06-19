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
import imnet.ft.sid.Index.ImnetAnalysis;
import imnet.ft.sid.Index.ImnetAnalyzer;
import imnet.ft.sid.Index.ImnetFilter;
import imnet.ft.sid.Index.ImnetTokenizer;
import imnet.ft.sid.IndexBuilder.AnalysisBuilder;
import imnet.ft.sid.IndexBuilder.AnalyzerBuilder;
import imnet.ft.sid.IndexBuilder.FilterBuilder;
import imnet.ft.sid.IndexBuilder.TokenizerBuilder;

public class app {

	public static void main(String[] args) throws IOException {
		GeneratorObjectJson nn = new GeneratorObjectJson();
		
		 List<String> filters = Arrays.asList("lowercase","stop","dsd");

			
	
		HashMap<String, Object> filter_1_proprety = new HashMap<String, Object>() {{
				    put("type","stop");
				    put("stopwords_path","stopwords/stop_francais.txt");
				}};
				
		HashMap<String, Object> filter_2_proprety = new HashMap<String, Object>() {{
				    put("type","synonfdym");
				    put("synonyms_path","synonyms/synonyms_francais.txt");
				}};
		

		HashMap<String, Map<String,Object>> filters_lot = new HashMap<String,  Map<String,Object>>() {{
		    put("stopword",filter_1_proprety);
		    put("syno",filter_2_proprety);
					}};
					
		
		System.out.println("*********************** Filter **************************\n\n");

		ImnetFilter f1 = new FilterBuilder()
					.setFilter_object(filters_lot)
					.build();
		ImnetFilter f2 = new  FilterBuilder()
					.isDefault()
					.setdefaultfilter(filters)
					.build();
		
		
		System.out.println("************** Analyzer ********************\n\n");
		HashMap<String, Object> analyze_1_proprety = new HashMap<String, Object>() {{
		    put("type","custom");
		    put("tokenizer","standard");
		    put("filter",f1);
		}};
		 HashMap<String, Object> analyze_2_proprety = new HashMap<String, Object>() {{
			    put("type","cuswtom");
			    put("tokenizer","standard");
			    put("filter",f2);
			}};
		 HashMap<String, Map<String,Object>> analyzer_lot = new HashMap<String,  Map<String,Object>>() {{
			    put("standardAnalyze",analyze_1_proprety);
			    put("freetext",analyze_2_proprety);
			}};
			
		ImnetAnalyzer a1 = new AnalyzerBuilder()
				//.isDefault()
				//.setAnalyzer_Name("imnetAnalyseur")
				.setAnalyzers(analyzer_lot)
				//.setAnalyzer_Filters(f1.getfilterCreated())
				.build();
	
	
	
		System.out.println("****************** Tokenizer **********************\n\n");
		HashMap<String, Object> toek_options = new HashMap<String, Object>() {{
		    put("type","letter");
		    put("qs","_french_");
		}};
		
		 HashMap<String, Map<String,Object>> token= new HashMap<String,  Map<String,Object>>() {{
			    put("letter",null);
			    put("hj",toek_options);
			    
			}};
		ImnetTokenizer t1 = new TokenizerBuilder()
				.setTokenizer_options(token)
				.build();
		
		
		System.out.println("************************ Analysis ******************************\n\n");
		ImnetAnalysis analysis = new AnalysisBuilder()
				.setImnetFilter(f1)
				.setImnetTokenizer(t1)
				.setImnetAnalyzer(a1)
				.build();
		System.out.println(analysis.getXContentAnalysis().bytes().utf8ToString());
		
		
		
		
		
		
		
		
		
	}
	
	

	
	
	
	
	
}
