package com.yu.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ziyu.wei@tendcloud.com
 *
 *         2016年11月28日 下午7:38:26
 *
 *         设置虚拟机参数 -Xms:100m -Xmx:100m -XX:+UseSerialGC
 */

public class MonitorMemoryTest {

  public static void fillHeap(int num) throws InterruptedException {
    List<OOMObject> list = new ArrayList<OOMObject>();
    for (int i = 0; i < num; i++) {
      // 稍做延迟，令监视曲线的变化更加明显
      Thread.sleep(50);
      list.add(new OOMObject());
    }
    System.gc();
  }

  public static void main(String[] args) throws InterruptedException {
    fillHeap(1000);
  }

}


/**
 * 内存占位符， 一个OOMObject大约占64KB
 *
 * @author ziyu.wei@tendcloud.com
 *
 *         2016年11月28日 下午7:40:48
 */
class OOMObject {
  public byte[] placeholder = new byte[64 * 1024];
}