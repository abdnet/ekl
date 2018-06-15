package imnet.ft.sid.IndexBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import imnet.ft.commun.util.ElasticSearchReservedFilters;
import imnet.ft.commun.util.ElasticSearchReservedWords;

public class FilterBuilder {
	
	private String filter_name;
	private String filter_type;
	private Map<String,Object> filter_options = null;
	private boolean filter_default ;
	private Map<String,Map<String,Object>> filter_object; 
	private List<String> Defaultfilter = new ArrayList<String>();
	private boolean isObject,isValid;
	
	public FilterBuilder(String filter_name, String filter_type, Map<String, Object> filter_options,
			boolean filter_default) {
		super();
		this.filter_name = filter_name;
		this.filter_type = filter_type;
		this.filter_options = filter_options;
		this.filter_default = filter_default;
	}




	public FilterBuilder(String filter_name, String filter_type, boolean filter_default) {
		super();
		this.filter_name = filter_name;
		this.filter_type = filter_type;
		this.filter_default = filter_default;
	}




	public FilterBuilder(String filter_name) {
		super();
		this.filter_name = filter_name;
		this.filter_default = true;
	}




	public String getFilter_name() {
		return filter_name;
	}




	public FilterBuilder setFilter_name(String filter_name) {
		this.filter_name = filter_name;
		return this;
	}




	public String getFilter_type() {
		return filter_type;
	}




	public FilterBuilder setFilter_type(String filter_type) {
		this.filter_type = filter_type;
		return this;
	}




	public Map<String, Object> getFilter_options() {
		return filter_options;
	}




	public FilterBuilder setFilter_options(Map<String, Object> filter_options) {
		this.filter_options = filter_options;
		return this;
	}




	public boolean isFilter_default() {
		return filter_default;
	}




	public FilterBuilder setFilter_default(boolean filter_default) {
		this.filter_default = filter_default;
		return this;
	}
	
	
	
	public List<String> getDefaultfilter() {
		return Defaultfilter;
	}




	public FilterBuilder setDefaultfilter(List<String> defaultfilter) {
		Defaultfilter = defaultfilter;
		return this;
	}




	public Map<String,Map<String,Object>> getFilterGenerator(){
		
		if(!this.getFilter_name().equals("")) {
				if(this.filter_default) {
					this.filter_object.put(this.getFilter_name(), this.getFilter_options());
				}
				else {
					if(ElasticSearchReservedFilters.filters.contains(this.getFilter_name())) {
						this.filter_object.put(this.getFilter_name(),this.getFilter_options());
					}
				}
			
		}else {
			return null;
		}
		
		return this.filter_object;
	}
	
	
	public XContentBuilder getFilterXContent() {

				try {
					XContentBuilder filter= XContentFactory.jsonBuilder();
					if(this.filter_default && this.filter_options==null && ElasticSearchReservedFilters.filters.contains(this.filter_name)) {
							filter.field(ElasticSearchReservedWords.FILTER.getText(), this.getDefaultfilter());
							this.isObject=false;
							this.isValid=true;
							return filter;
					}
					else {
							if(this.filter_options!=null) {
								filter.startObject(ElasticSearchReservedWords.FILTER.getText())
									.startObject(this.filter_name.toLowerCase());
								for(Entry<String,Object> entry:this.filter_options.entrySet()) {
										filter.field(entry.getKey(),entry.getValue());
								}
								this.isObject=true;
								this.isValid=true;
								return filter.endObject().endObject();
								
							}
							
						
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// TODO: handle exception
			
		

		
		return null;
		
	}




	public boolean isObject() {
		return isObject;
	}

	public boolean isValid() {
		return isValid;
	}




	


	
	
	
}
