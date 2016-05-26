package com.yu.spring.beans.factory.xml;

import org.w3c.dom.Document;

public interface BeanDefinitionDocumentReader {

	void registerBeanDefinitions(Document doc, XmlReaderContext readerContext);
}
