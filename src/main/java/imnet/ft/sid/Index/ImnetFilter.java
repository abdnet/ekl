package imnet.ft.sid.Index;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import imnet.ft.commun.util.ElasticSearchReservedFilters;
import imnet.ft.commun.util.ElasticSearchReservedWords;

public class ImnetFilter {
	
	private String filter_name;
	private boolean isDefault;
	private Map<String,Map<String,Object>> filter_object; 
	private List<String> defaultfilter=new ArrayList<String>() ;
	
	private List<String> filterCreated =new ArrayList<String>();
	private boolean isObject,isValid;


	
	
	public ImnetFilter(String filter_name, boolean filter_default, Map<String, Map<String, Object>> filter_object,
			List<String> defaultfilter) {
		super();
		filter_name = filter_name;
		this.isDefault = filter_default;
		this.filter_object = filter_object;
		this.defaultfilter = defaultfilter;
	}
	
	

	public List<String> getfilterCreated() {
		return filterCreated;
	}

	public void setfilterCreated(List<String> filterCreated) {
		this.filterCreated = filterCreated;
	}
	public boolean isObject() {
		return isObject;
	}
	public void setObject(boolean isObject) {
		this.isObject = isObject;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public List<String> getdefaultfilter() {
		return this.defaultfilter;
	}
	public void setdefaultfilter(List<String> defaultfilter) {
		this.defaultfilter = defaultfilter;
	}



	public String getFilter_name() {
		return this.filter_name;
	}



	public boolean isDefault() {
		return this.isDefault;
	}



	public Map<String, Map<String, Object>> getFilter_object() {
		return this.filter_object;
	}



	public List<String> getDefaultfilter() {
		return this.defaultfilter;
	}



	public List<String> getFilterCreated() {
		return this.filterCreated;
	}



	public XContentBuilder getFilterXContent(XContentBuilder filter) throws IOException {
					if(this.isDefault && this.defaultfilter.size()>0) {
							this.isdefaultfilter();
							filter.field(ElasticSearchReservedWords.FILTER.getText(), this.getdefaultfilter());
							this.isObject=false;
							this.isValid=true;
							return filter.endObject();
					}
					else {	

							if(this.filter_object!=null) {
								isdefaultfilter();
								filter.startObject(ElasticSearchReservedWords.FILTER.getText());
								//filter.startObject("filter");
								for(Entry<String,Map<String,Object>> entry:this.filter_object.entrySet()) {
									filter.startObject(entry.getKey());//filter name object <start>
									Map<String,Object> option= entry.getValue();
									for(Entry<String,Object> entry2:option.entrySet()) {
										filter.field(entry2.getKey(),entry2.getValue());
									}
									this.filterCreated.add(entry.getKey());
									filter.endObject();//filter name object <end>
								}
								this.isObject=true;
								this.isValid=true;
								return filter.endObject();//Filter object <end>
								}	
					}
				return filter;			
	}
	public void isdefaultfilter() {
		ArrayList<String> filters = new ArrayList<String>();
		for (String filter : this.getdefaultfilter()) {
			if(ElasticSearchReservedFilters.filters.contains(filter))
				filters.add(filter);
			else
				System.out.println("[ WARN ] le filter * "+filter+" * n'est pas valide");
		}
		this.setdefaultfilter(filters);
		this.setfilterCreated(filters);
	}



	@Override
	public String toString() {
		return "ImnetFilter [filter_name=" + filter_name + ", isDefault=" + isDefault + ", filter_object="
				+ filter_object + ", defaultfilter=" + defaultfilter + ", filterCreated=" + filterCreated
				+ ", isObject=" + isObject + ", isValid=" + isValid + "]";
	}
	
	
	
	
}
