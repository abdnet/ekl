package imnet.ft.commun.app;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import imnet.ft.commun.util.ElasticSearchReservedWords;
import imnet.ft.commun.util.GeneratorObjectJson;

public class app {

	public static void main(String[] args) throws IOException {
		/*GeneratorObjectJson nn = new GeneratorObjectJson();
		 HashMap<String, String> proprety = new HashMap<String, String>() {{
		    put("type","keyword");
		    put("analyzer","standard");
		}};
		
		 HashMap<String, String> proprety2 = new HashMap<String, String>() {{
			    put("type","text");
			}};
		 HashMap<String, Map<String,String>> fields = new HashMap<String,  Map<String,String>>() {{
			    put("doc_id",proprety);
			    put("content",proprety2);
			}};
			
			HashMap<String, Map<String,String>> fields2=null;
		System.out.println(nn.createSettings("imnet","term",fields).string());
	*/
	
		XContentBuilder settings =XContentFactory.jsonBuilder()
                  .startObject()
                      //disable dynamic mapping adding, set it to false 
                      .field(ElasticSearchReservedWords.INDEX_MAPPER_DYNAMIC.getText(), false)
                      //Add analyzer settings
                      .startObject(ElasticSearchReservedWords.ANALYSIS.getText())
                          .startObject(ElasticSearchReservedWords.FILTER.getText())
                              .startObject("stopword")
                                  .field(ElasticSearchReservedWords.TYPE.getText(), ElasticSearchReservedWords.STOP.getText())    
                                  .field(ElasticSearchReservedWords.STOPWORDS_PATH.getText(), "stopwords/stop_" + "francais")
                              .endObject()
                              .startObject("snowball")
                                  .field(ElasticSearchReservedWords.TYPE.getText(), ElasticSearchReservedWords.SNOWBALL.getText())
                                  .field(ElasticSearchReservedWords.LANGUAGE.getText(), "francais")
                              .endObject()
                              .startObject("worddelimit")
                                  .field(ElasticSearchReservedWords.TYPE.getText(), ElasticSearchReservedWords.WORD_DELIMITER.getText())
                                  .field(ElasticSearchReservedWords.PROTECTED_WORDS_PATH.getText(), "worddelimiters/protectedwords_" + "protectword")
                                  .field(ElasticSearchReservedWords.TYPE_TABLE_PATH.getText(), "worddelimiters/typetable")
                                  .field("split_on_numerics", "true")
                                  .field("generate_number_parts", "true")
                                  .field("preserve_original", "true")
                              .endObject()
                              .startObject("syno")
                                  .field(ElasticSearchReservedWords.TYPE.getText(), ElasticSearchReservedWords.SYNONYM.getText())
                                  .field(ElasticSearchReservedWords.SYNONYMS_PATH.getText(), "synonyms/synonyms_" + "francais")
                                  .field(ElasticSearchReservedWords.SYNONYMS_IGNORE_CASE.getText(), true)
                                  .field(ElasticSearchReservedWords.SYNONYMS_EXPAND.getText(), true)
                              .endObject()
                              .startObject("ShingleToken")
                                  .field("type", "shingle")
                                  .field("min_shingle_size", 2)
                                  .field("max_shingle_size", 4)
                              .endObject()
                              .startObject("ngram")
                                  .field("type", "edgeNGram")
                                  .field("min_gram", 4)
                                  .field("max_gram", 30)
                              .endObject()
                        .endObject()
                          .startObject(ElasticSearchReservedWords.ANALYZER.getText())
                              .startObject("standardAnalyze")
                                  .field(ElasticSearchReservedWords.TYPE.getText(), ElasticSearchReservedWords.CUSTOM.getText())
                                  .field(ElasticSearchReservedWords.TOKENIZER.getText(), ElasticSearchReservedWords.STANDARD.getText())
                                  .field(ElasticSearchReservedWords.FILTER.getText(), new String[]{ElasticSearchReservedWords.LOWERCASE.getText(), 
                                                                              "stopword", 
                                                                              "synonyme",
                                                                              "snowball" 
                                                                              })
                              .endObject()
                              .startObject("freetext")
                                  .field(ElasticSearchReservedWords.TYPE.getText(), ElasticSearchReservedWords.CUSTOM.getText())
                                  .field(ElasticSearchReservedWords.TOKENIZER.getText(), ElasticSearchReservedWords.WHITESPACE.getText())
                                  .field(ElasticSearchReservedWords.FILTER.getText(), new String[]{ElasticSearchReservedWords.LOWERCASE.getText(), 
                                                                              "wordDelimit", 
                                                                              "stpword", 
                                                                              "synonyme",
                                                                              "snowball" 
                                                                              })
                                 .field(ElasticSearchReservedWords.CHAR_FILTER.getText(), ElasticSearchReservedWords.HTML_STRIP.getText())                                             
                              .endObject()
                              .startObject("sugg")
                                  .field(ElasticSearchReservedWords.TYPE.getText(), ElasticSearchReservedWords.CUSTOM.getText())
                                  .field(ElasticSearchReservedWords.TOKENIZER.getText(), ElasticSearchReservedWords.KEYWORD.getText())
                                  .field(ElasticSearchReservedWords.FILTER.getText(), new String[]{ElasticSearchReservedWords.LOWERCASE.getText()
//                                                                              config.getNGramTokenFilterName()
                                                                              })
                              .endObject()
                              .startObject("facett")
                                  .field(ElasticSearchReservedWords.TYPE.getText(), ElasticSearchReservedWords.CUSTOM.getText())
                                  .field(ElasticSearchReservedWords.TOKENIZER.getText(), ElasticSearchReservedWords.STANDARD.getText())
                                  .field(ElasticSearchReservedWords.FILTER.getText(), new String[]{ElasticSearchReservedWords.LOWERCASE.getText(), 
                                                                              "snowball", 
                                                                              "synonyme"
                                                                              })
                              .endObject()
                          .endObject()
                      .endObject()
                  .endObject();
		
		System.out.println(settings.bytes().utf8ToString());
	
	}
	
	
	
	
	
	
}
