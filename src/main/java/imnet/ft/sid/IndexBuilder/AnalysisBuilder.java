package imnet.ft.sid.IndexBuilder;

import imnet.ft.sid.Index.ImnetAnalysis;
import imnet.ft.sid.Index.ImnetAnalyzer;
import imnet.ft.sid.Index.ImnetCharFilter;
import imnet.ft.sid.Index.ImnetFilter;
import imnet.ft.sid.Index.ImnetTokenizer;

public class AnalysisBuilder {

	private ImnetAnalyzer imnetAnalyzer;
	private ImnetTokenizer imnetTokenizer;
	private ImnetCharFilter imnetCharFilter;
	private ImnetFilter imnetFilter;
	
	
	
	public AnalysisBuilder setImnetAnalyzer(ImnetAnalyzer imnetAnalyzer) {
		this.imnetAnalyzer = imnetAnalyzer;
		return this;
	}
	public AnalysisBuilder setImnetTokenizer(ImnetTokenizer imnetTokenizer) {
		this.imnetTokenizer = imnetTokenizer;
		return this;
	}
	public AnalysisBuilder setImnetCharFilter(ImnetCharFilter imnetCharFilter) {
		this.imnetCharFilter = imnetCharFilter;
		return this;
	}
	public AnalysisBuilder setImnetFilter(ImnetFilter imnetFilter) {
		this.imnetFilter = imnetFilter;
		return this;
	}
	
	
	public ImnetAnalysis build() {
		return new ImnetAnalysis(imnetAnalyzer, imnetTokenizer, imnetCharFilter, imnetFilter);
	}
	
	
}
