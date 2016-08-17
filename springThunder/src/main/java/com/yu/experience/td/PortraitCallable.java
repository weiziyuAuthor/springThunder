// package com.yu.experience.td;
//
// import java.util.HashMap;
// import java.util.Map;
// import java.util.concurrent.Callable;
//
// import net.sf.json.JSON;
//
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
//
//
// /**
// *
// * @author ziyu.wei@tendcloud.com
// *
// * 2016年8月17日 上午11:05:49
// *
// * 最大并行化运行， 待总体返回后，进行处理
// *
// */
// /*
// *
// * public static Map<String, Object> doPortraitTask(PortraitCallable portraitCallable) {
// * FutureTask<Map<String, Object>> futureTask = new FutureTask<>(portraitCallable);
// * executor.submit(futureTask); Map<String, Object> map = null; try { map = futureTask.get(); }
// * catch (InterruptedException | ExecutionException e) { e.printStackTrace(); } return map; }
// */
// public class PortraitCallable implements Callable<Map<String, Object>> {
//
// private static final Logger logger = LoggerFactory.getLogger(PortraitCallable.class);
//
// private PortraitReq req;
// private String indexName;
// private String indexBitmap;
//
// private PortraitCallable() {
//
// }
//
// public PortraitCallable(final PortraitReq req, final String indexName, final String indexBitmap)
// {
// this.req = req;
// this.indexName = indexName;
// this.indexBitmap = indexBitmap;
// }
//
// @Override
// public Map<String, Object> call() throws Exception {
//
// final Map<String, Integer> countMap =
// BitmapClientUtil.PortraitClient().portraitCount(req.getType(), req.getDate(), "",
// this.indexBitmap);
// if (countMap != null && countMap.size() > 0) {
// Map<String, Object> map = new HashMap<String, Object>();
// map.put("countMap", countMap);
// map.put("portraitReq", req);
// map.put("indexName", indexName);
// if (logger.isDebugEnabled()) {
// logger.debug("portrait__PortraitCallable pid:{}, indexName:{}, date:{},  indexBitmap:{}, portraitReq:{}",
// req.getPid(), indexName, req.getDate(), this.indexBitmap, JSON.toJSONString(req));
// }
// return map;
// }
// logger.error("portrait__PortraitCallable pid:{}, date:{}, indexBitmap:{} countMap is null",
// req.getPid(),
// req.getDate(), this.indexBitmap);
// return null;
// }
//
// }
