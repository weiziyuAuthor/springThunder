package com.yu.spring.beans.factory.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.beans.factory.parsing.FailFastProblemReporter;
import org.springframework.beans.factory.parsing.NullSourceExtractor;
import org.springframework.beans.factory.parsing.ProblemReporter;
import org.springframework.beans.factory.parsing.ReaderEventListener;
import org.springframework.beans.factory.parsing.SourceExtractor;
import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;
import org.springframework.beans.factory.xml.DefaultNamespaceHandlerResolver;
import org.springframework.beans.factory.xml.DelegatingEntityResolver;
import org.springframework.beans.factory.xml.NamespaceHandlerResolver;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.core.NamedThreadLocal;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.xml.XmlValidationModeDetector;
import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;

import com.yu.spring.beans.factory.support.AbstractBeanDefinitionReader;
import com.yu.spring.beans.factory.support.BeanDefinitionRegistry;
import com.yu.spring.good.clazz.Constants;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

	public static final int VALIDATION_NONE = XmlValidationModeDetector.VALIDATION_NONE;

	public static final int VALIDATION_AUTO = XmlValidationModeDetector.VALIDATION_AUTO;

	public static final int VALIDATION_DTD = XmlValidationModeDetector.VALIDATION_DTD;

	public static final int VALIDATION_XSD = XmlValidationModeDetector.VALIDATION_XSD;

	private static final Constants constants = new Constants(XmlBeanDefinitionReader.class);

	private int validationMode = VALIDATION_AUTO;

	private boolean namespaceAware = false;
	
	//GOOD
	private Class<?> documentReaderClass = DefaultBeanDefinitionDocumentReader.class;
	
	private ProblemReporter problemReporter = new FailFastProblemReporter();
	
	private ReaderEventListener eventListener = new EmptyReaderEventListener();
	
	private SourceExtractor sourceExtractor = new NullSourceExtractor();
	
	private NamespaceHandlerResolver namespaceHandlerResolver;
	
	private DocumentLoader documentLoader = new DefaultDocumentLoader();
	
	private EntityResolver entityResolver;
	
//	TODO
//	private ErrorHandler errorHandler = new SimpleSaxErrorHandler(logger);
	private ErrorHandler errorHandler = null;
	
	private final XmlValidationModeDetector validationModeDetector = new XmlValidationModeDetector();
	
	private final ThreadLocal<Set<EncodedResource>> resourcesCurrentlyBeingLoaded =
			new NamedThreadLocal<Set<EncodedResource>>("XML bean definition resources currently being loaded");
	
	public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
		super(registry);
	}
	
	public void setValidating(boolean validating) {
		this.validationMode = validating ? VALIDATION_AUTO : VALIDATION_NONE;
		this.namespaceAware = !validating;
	}
	
	public void setValidationModeName(String validationModeName) {
		setValidationMode(constants.asNumber(validationModeName).intValue());
	}
	
	public void setValidationMode(int validationMode) {
		this.validationMode = validationMode;
	}
	
	public int getValidationMode() {
		return this.validationMode;
	}
	
	public void setNamespaceAware(boolean namespaceAware) {
		this.namespaceAware = namespaceAware;
	}
	
	public boolean isNamespaceAware() {
		return this.namespaceAware;
	}
	
	public void setProblemReporter(ProblemReporter problemReporter) {
		this.problemReporter = (problemReporter != null ? problemReporter : new FailFastProblemReporter());
	}
	
	public void setEventListener(ReaderEventListener eventListener) {
		this.eventListener = (eventListener != null ? eventListener : new EmptyReaderEventListener());
	}
	
	public void setSourceExtractor(SourceExtractor sourceExtractor) {
		this.sourceExtractor = (sourceExtractor != null ? sourceExtractor : new NullSourceExtractor());
	}
	
	public void setNamespaceHandlerResolver(NamespaceHandlerResolver namespaceHandlerResolver) {
		this.namespaceHandlerResolver = namespaceHandlerResolver;
	}
	
	public void setDocumentLoader(DocumentLoader documentLoader) {
		this.documentLoader = (documentLoader != null ? documentLoader : new DefaultDocumentLoader());
	}
	
	public void setEntityResolver(EntityResolver entityResolver) {
		this.entityResolver = entityResolver;
	}
	
	protected EntityResolver getEntityResolver() {
		if (this.entityResolver == null) {
			ResourceLoader resourceLoader = getResourceLoader();
			if (resourceLoader != null) {
				this.entityResolver = new ResourceEntityResolver(resourceLoader);
			}
			else {
				this.entityResolver = new DelegatingEntityResolver(getBeanClassLoader());
			}
		}
		return this.entityResolver;
	}
	
	public void setErrorHandler(ErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
	}

	public void setDocumentReaderClass(Class<?> documentReaderClass) {
		if (documentReaderClass == null || !BeanDefinitionDocumentReader.class.isAssignableFrom(documentReaderClass)) {
			throw new IllegalArgumentException(
					"documentReaderClass must be an implementation of the BeanDefinitionDocumentReader interface");
		}
		this.documentReaderClass = documentReaderClass;
	}
	
	public int loadBeanDefinitions(Resource resource) {
		try {
			return loadBeanDefinitions(new EncodedResource(resource));
		} catch (Exception e) {
			return 0;
		}
	}

	public int loadBeanDefinitions(EncodedResource encodeResource) throws Exception {
		Set<EncodedResource> currentResources = this.resourcesCurrentlyBeingLoaded.get();
		if (currentResources == null) {
			currentResources = new HashSet<EncodedResource>();
			this.resourcesCurrentlyBeingLoaded.set(currentResources);
		} 
		if (!currentResources.add(encodeResource)) {
			throw new Exception("detected cyclic loading of " + encodeResource + " check your import definitions");
		}
		
		InputStream inputStream = encodeResource.getResource().getInputStream();
		InputSource inputSource = new InputSource(inputStream);
		if (encodeResource.getEncoding() != null) {
			inputSource.setEncoding(encodeResource.getEncoding());
		}
		
		return doLoadBeanDefinitions(inputSource, encodeResource.getResource());
	}
	
	protected int doLoadBeanDefinitions(InputSource inputSource, Resource resource) {
		try {
			Document doc = doLoadDocument(inputSource, resource);
			return registerBeanDefinitions(doc, resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int registerBeanDefinitions(Document doc, Resource resource) {
		BeanDefinitionDocumentReader documentReader = createBeanDefinitionDocumentReader();
		int countBefore = getRegistry().getBeanDefinitionCount();
		documentReader.registerBeanDefinitions(doc, createReaderContext(resource));
		return getRegistry().getBeanDefinitionCount() - countBefore;
	}
	
	public XmlReaderContext createReaderContext(Resource resource) {
		return new XmlReaderContext(resource, this.problemReporter, this.eventListener,
				this.sourceExtractor, this, getNamespaceHandlerResolver());
	}
	
	public NamespaceHandlerResolver getNamespaceHandlerResolver() {
		if (this.namespaceHandlerResolver == null) {
			this.namespaceHandlerResolver = createDefaultNamespaceHandlerResolver();
		}
		return this.namespaceHandlerResolver;
	}
	
	protected NamespaceHandlerResolver createDefaultNamespaceHandlerResolver() {
		return new DefaultNamespaceHandlerResolver(getResourceLoader().getClassLoader());
	}

	
	protected BeanDefinitionDocumentReader createBeanDefinitionDocumentReader() {
		return BeanDefinitionDocumentReader.class.cast(BeanUtils.instantiateClass(this.documentReaderClass));
	}
	protected Document doLoadDocument(InputSource inputSource, Resource resource) throws Exception {
		return this.documentLoader.loadDocument(inputSource, getEntityResolver(), 
				errorHandler, getValidationModeForResource(resource), isNamespaceAware());
	}
	
	protected int getValidationModeForResource(Resource resource) {
		int validationModeToUse = getValidationMode();
		if (validationModeToUse != VALIDATION_AUTO) {
			return validationModeToUse;
		}
		int detectedMode = detectValidationMode(resource);
		if (detectedMode != VALIDATION_AUTO) {
			return detectedMode;
		}
		return VALIDATION_XSD;
	}
	
	protected int detectValidationMode(Resource resource) {
		if (resource.isOpen()) {
			throw new BeanDefinitionStoreException(
					"Passed-in Resource [" + resource + "] contains an open stream: " +
					"cannot determine validation mode automatically. Either pass in a Resource " +
					"that is able to create fresh streams, or explicitly specify the validationMode " +
					"on your XmlBeanDefinitionReader instance.");
		}

		InputStream inputStream;
		try {
			inputStream = resource.getInputStream();
		}
		catch (IOException ex) {
			throw new BeanDefinitionStoreException(
					"Unable to determine validation mode for [" + resource + "]: cannot open InputStream. " +
					"Did you attempt to load directly from a SAX InputSource without specifying the " +
					"validationMode on your XmlBeanDefinitionReader instance?", ex);
		}

		try {
			return this.validationModeDetector.detectValidationMode(inputStream);
		}
		catch (IOException ex) {
			throw new BeanDefinitionStoreException("Unable to determine validation mode for [" +
					resource + "]: an error occurred whilst reading from the InputStream.", ex);
		}
	}
}
