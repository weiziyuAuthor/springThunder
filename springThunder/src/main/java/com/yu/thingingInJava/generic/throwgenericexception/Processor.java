package com.yu.thingingInJava.generic.throwgenericexception;

import java.util.List;

public interface Processor<T, E extends Exception> {

  void process(List<T> resultCollector) throws E;

}
