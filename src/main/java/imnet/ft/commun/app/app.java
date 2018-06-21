package imnet.ft.commun.app;

import java.io.IOException;

import imnet.ft.sid.indexing.IndexSchemaStandard;

public class app {

	public static void main(String[] args) {
		IndexSchemaStandard schema = new IndexSchemaStandard();
		System.out.println(schema.settingBuilderInit().bytes().utf8ToString());

		
}
}
