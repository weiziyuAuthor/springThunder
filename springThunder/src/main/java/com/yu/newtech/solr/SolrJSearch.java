// package com.yu.newtech.solr;
//
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.Collection;
//
// import org.apache.solr.client.solrj.SolrQuery;
// import org.apache.solr.client.solrj.SolrServer;
// import org.apache.solr.client.solrj.SolrServerException;
// import org.apache.solr.client.solrj.impl.HttpSolrServer;
// import org.apache.solr.client.solrj.response.QueryResponse;
// import org.apache.solr.common.SolrDocument;
// import org.apache.solr.common.SolrDocumentList;
// import org.apache.solr.common.SolrInputDocument;
//
// public class SolrJSearch {
//
// // private static final String SOLR_URL = "http://localhost:8983/solr";
//
// private static final String SOLR_URL = "http://localhost:8080/solr/connection1";
//
// // private static final String SOLR_URL =
// "http://10.10.32.41:8983/solr/gettingstarted_shard1_replica1";
//
// public SolrServer getSolrServer() {
// return new HttpSolrServer(SOLR_URL);
// }
//
// // public void solrJSearch() {
// // SolrServer solrServer = getSolrServer();
// // }
//
// public void search(String string) {
//		SolrServer solrServer = getSolrServer();
// SolrQuery query = new SolrQuery();
// query.setQuery(string);
//
// try {
// QueryResponse rsp = solrServer.query(query);
// SolrDocumentList docs = rsp.getResults();
// System.out.println("DOC COUNT: " + docs.getNumFound());
// System.out.println("EXE_TIME: " + rsp.getQTime());
// for (SolrDocument doc : docs) {
// String name = (String) doc.getFieldValue("name");
// String id = (String) doc.getFieldValue("id");
// System.out.println(id);
// System.out.println(name);
// System.out.println(doc.getFieldValue("name_mnecode"));
// }
// } catch (SolrServerException e) {
// e.printStackTrace();
// }
// }
//
// public void addIndex() {
//
// // server.deleteByQuery("*:*");// delete everything!
//
// // SolrInputDocument sid1 = new SolrInputDocument();
// // sid1.addField("id", "1");
// // sid1.addField("name", "weizy");
// //
// // SolrInputDocument sid2 = new SolrInputDocument();
// // sid2.addField("id", "2");
// // sid2.addField("name", "mugengyuan");
//
// SolrInputDocument sid3 = new SolrInputDocument();
// sid3.addField("id", "3");
// sid3.addField("name", "Τ����");
//
// Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
// // docs.add(sid1);
// // docs.add(sid2);
// docs.add(sid3);
//
// try {
// this.getSolrServer().add(docs);
// this.getSolrServer().commit();
// } catch (SolrServerException e) {
// e.printStackTrace();
// } catch (IOException e) {
// e.printStackTrace();
// }
//
// }
//
// public void deleteAllIndex() {
// try {
// this.getSolrServer().deleteByQuery("*:*");
// } catch (SolrServerException e) {
// e.printStackTrace();
// } catch (IOException e) {
// e.printStackTrace();
// }
//	}
//
// public static void main(String[] args) {
// SolrJSearch solrJSearch = new SolrJSearch();
// // String queryString = "Solr";
// // solrJSearch.search(queryString);
//
// solrJSearch.addIndex();
// // solrJSearch.deleteAllIndex();
// }
// }
