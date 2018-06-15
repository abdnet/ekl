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
			  "five_token_limit" //Limite le nombre de jetons indexés par document et par champ.
			  );


}
