package imnet.ft.commun.util;

import java.util.Arrays;
import java.util.List;

public interface ElasticSearchReservedFilters {
	
	
	  static final List<String> filters = Arrays.asList(
			  "standard",
			  "asciifolding",
			  "synonym_graph",
			  "lowercase",
			  "uppercase",
			  "nGram",
			  "edgeNGram",
			  "porter_stem",
			  "stop",
			  "keyword_marker",
			  "phonetic",
			  "synonym",
			  "reverse",
			  "elision",
			  "truncate",
			  "pattern_capture", //pour l'adresse mail ou postal
			  "trim",
			  "five_token_limit" //Limite le nombre de jetons index�s par document et par champ.
			  );


	  static final List<String> tokenizer = Arrays.asList(
			  "standard",
			  "asciifolding",
			  "synonym_graph",
			  "lowercase",
			  "uppercase",
			  "nGram",
			  "edgeNGram",
			  "porter_stem",
			  "stop",
			  "keyword_marker",
			  "phonetic",
			  "synonym",
			  "reverse",
			  "elision",
			  "truncate",
			  "pattern_capture", //pour l'adresse mail ou postal
			  "trim",
			  "five_token_limit" //Limite le nombre de jetons index�s par document et par champ.
			  );
	  
	  
	  static final List<String> analyzers = Arrays.asList(
			  "standard",
			  "simple",
			  "whitespace",
			  "stop",
			  "keyword",
			  "keyword",
			  "pattern",
			  "fingerprint"
			  );
	  
	  static final List<String> analyzers_options = Arrays.asList(
			  "type",
			  "tokenizer",
			  "filter",
			  "char_filter"
			  );
	  
}
