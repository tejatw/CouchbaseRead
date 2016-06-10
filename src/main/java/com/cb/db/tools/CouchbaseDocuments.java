package com.cb.db.tools;

import com.couchbase.client.java.document.json.JsonObject;

/**
 * @author Teja Wuppumandla 21 Feb 2016
 * 
 */

public class CouchbaseDocuments {

	public static void getDocumentById(String documentId){

		JsonObject documentIdResult;

		try{

			documentIdResult = CouchbaseConnection.bucketCB.get(documentId).content();
			if(documentIdResult.isEmpty()){
				System.out.println("Document with Id " + documentId + " is not found in the Database");
			}
			else{
				PrettyPrintDocument.prettyPrintDocument(documentIdResult);
			}
		}
		catch(Exception e){
			System.out.println("Document with Id " + documentId + " is not found in the Database");
		}
	}

	
}
