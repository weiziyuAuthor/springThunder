package com.yu.newtech.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

public class SolrJSearch {

	private static final String SOLR_URL = "http://localhost:8983/solr";
	
	public SolrServer getSolrServer() {
		return new HttpSolrServer(SOLR_URL);
	}
	
//	public void solrJSearch() {
//		SolrServer solrServer = getSolrServer();
//	}
	
	public void search(String string) {
		SolrServer solrServer = getSolrServer();
		SolrQuery query = new SolrQuery();
		query.setQuery(string);
		
		try {
			QueryResponse rsp = solrServer.query(query);
			SolrDocumentList docs = rsp.getResults();
			System.out.println("DOC COUNT: " + docs.getNumFound());
			System.out.println("EXE_TIME: " + rsp.getQTime());
			for (SolrDocument doc : docs) {
				String name = (String) doc.getFieldValue("name");  
			    String id = (String) doc.getFieldValue("id");  
			    System.out.println(id);  
			    System.out.println(name);  
			    System.out.println(doc.getFieldValue("name_mnecode"));  
			}
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SolrJSearch solrJSearch = new SolrJSearch();
		String queryString = "contrast";
		solrJSearch.search(queryString);
	}
}
