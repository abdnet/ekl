package imnet.ft.sid.Index;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import imnet.ft.commun.util.ElasticSearchReservedFilters;
import imnet.ft.commun.util.ElasticSearchReservedWords;

public class ImnetAnalyzer {
	
	private boolean isDefault=false;
	private String analyzer_Name=null;
	private String analyzer_Type =null;
	private String analyzer_Tokenizer=null;
	private List<String> analyzer_Filters=null;
	private ImnetCharFilter analyzer_CharFilter;
	private Map<String,Map<String,Object>> analyzers =null;
	
	
	
	public ImnetAnalyzer(boolean isDefault, String analyzer_Name, String analyzer_Type, String analyzer_Tokenizer,
			List<String> analyzer_Filters,ImnetCharFilter analyzer_CharFilter,Map<String,Map<String,Object>> analyzers) {
		super();
		this.isDefault = isDefault;
		this.analyzer_Name = analyzer_Name;
		this.analyzer_Type = analyzer_Type;
		this.analyzer_Tokenizer = analyzer_Tokenizer;
		this.analyzer_Filters = analyzer_Filters;
		this.analyzer_CharFilter=analyzer_CharFilter;
		this.analyzers=analyzers;
	}	
	
	
	public boolean isDefault() {
		return isDefault;
	}


	public String getAnalyzer_Name() {
		return analyzer_Name;
	}


	public String getAnalyzer_Type() {
		return analyzer_Type;
	}


	public String getAnalyzer_Tokenizer() {
		return analyzer_Tokenizer;
	}


	public List<String> getAnalyzer_Filters() {
		return analyzer_Filters;
	}


	public ImnetCharFilter getAnalyzer_CharFilter() {
		return analyzer_CharFilter;
	}


	public XContentBuilder getAnalyzerXContent(XContentBuilder analyzers) throws IOException {
					if(this.isDefault) {
							//analyzers.field(ElasticSearchReservedWords.ANALYZER.getText(),this.analyzer_Type);
							return analyzers.endObject();
					}
				else {
						
					
					analyzers.startObject(ElasticSearchReservedWords.ANALYZER.getText());
					 System.out.println("analyzer debug 00");

							 if(this.analyzers.size()<=1&&!this.analyzers.get(this.analyzer_Name).get(ElasticSearchReservedWords.TYPE.getText()).equals("custom")) {
								 for(Entry<String,Map<String,Object>> entry:this.analyzers.entrySet()) {
									 analyzers.startObject(entry.getKey());
									 Map<String,Object> option = entry.getValue();
									 for(Entry<String,Object> entry2:option.entrySet()) {
										 System.out.println("analyzer debug 0");

										 if(entry2.getKey().equals("type")) {
											 if(ElasticSearchReservedFilters.analyzers.contains(entry2.getValue())&&!entry2.getValue().equals("custom")) {
												 analyzers.field(ElasticSearchReservedWords.TYPE.getText(),entry2.getValue());
											 }
											 else {
												 	System.out.println("[ WARN ] Analyzer <"+entry2.getValue()+"> n'est pas valide"); 
												 	return null;
												 	
											 		}
										 }else {
											 if(entry2.getKey().equals("filter")) {
												 System.out.println("analyzer debug");
												 analyzers.field(ElasticSearchReservedWords.FILTER.getText(),this.generatorFilterRaw((ImnetFilter)entry2.getValue()));
												 analyzers.field(entry2.getKey(),this.getAnalyzer_Filters());
											 }else {
												 System.out.println("analyzer debug2");

												 analyzers.field(entry2.getKey(),entry2.getValue());

											 }
										 }
									 }
									 analyzers.endObject();

								 }
								 
							 }else {
								 for(Entry<String,Map<String,Object>> entry:this.analyzers.entrySet()) {
									 analyzers.startObject(entry.getKey());
									 Map<String,Object> option = entry.getValue();
									 for(Entry<String,Object> entry2:option.entrySet()) {
										 if(ElasticSearchReservedFilters.analyzers_options.contains(entry2.getKey())) {
											 //vérification de tokenzer
											 //verification char filter
											 if(entry2.getKey().equals("filter")) {												 
												 analyzers.field(ElasticSearchReservedWords.FILTER.getText(),this.generatorFilterRaw((ImnetFilter)entry2.getValue()));
											 }else{
											 analyzers.field(entry2.getKey(),entry2.getValue());}
										 }
									 }
									 analyzers.endObject();

								 }

							 }
						
				}
				
				
				

		return analyzers.endObject();
		
	}


		public List<String> generatorFilterRaw(ImnetFilter ff) throws IOException {
			ImnetFilter f=ff;
			
			
			f.getFilterXContent();
			return f.getFilterCreated();
		}
	@Override
	public String toString() {
		return "ImnetAnalyzer [isDefault=" + isDefault + ", analyzer_Name=" + analyzer_Name + ", analyzer_Type="
				+ analyzer_Type + ", analyzer_Tokenizer=" + analyzer_Tokenizer + ", analyzer_Filters="
				+ analyzer_Filters + ", analyzer_CharFilter=" + analyzer_CharFilter + ", analyzers=" + analyzers + "]";
	}
	
	
	

}
