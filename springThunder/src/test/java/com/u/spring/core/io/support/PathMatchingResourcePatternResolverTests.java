package com.u.spring.core.io.support;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * 
 * ziyu.wei GOOD 
 * 
 */

public class PathMatchingResourcePatternResolverTests extends TestCase{


	private static final String[] CLASSES_IN_CORE_IO_SUPPORT =
			new String[] {"EncodedResource.class", "LocalizedResourceHelper.class",
										"PathMatchingResourcePatternResolver.class",
										"PropertiesLoaderSupport.class", "PropertiesLoaderUtils.class",
										"ResourceArrayPropertyEditor.class",
										"ResourcePatternResolver.class", "ResourcePatternUtils.class"};

	private static final String[] TEST_CLASSES_IN_CORE_IO_SUPPORT =
			new String[] {"PathMatchingResourcePatternResolverTests.class"};

	private static final String[] CLASSES_IN_COMMONSLOGGING =
			new String[] {"Log.class", "LogConfigurationException.class", "LogFactory.class",
										"LogFactory$1.class", "LogFactory$2.class", "LogFactory$3.class",
										"LogFactory$4.class", "LogFactory$5.class", "LogFactory$6.class",
										"LogSource.class"};

	private PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();


	public void testInvalidPrefixWithPatternElementInIt() throws IOException {
		try {
			resolver.getResources("xx**:**/*.xy");
			fail("Should have thrown FileNotFoundException");
		}
		catch (FileNotFoundException ex) {
			// expected
//			ex.printStackTrace();
		}
	}

	
	public void testSingleResourceOnFileSystem() throws IOException {
		Resource[] resources =
				resolver.getResources("com/u/spring/core/io/support/PathMatchingResourcePatternResolverTests.class");
		assertEquals(1, resources.length);
		assertProtocolAndFilename(resources[0], "file", "PathMatchingResourcePatternResolverTests.class");
	}

	
	public void testSingleResourceInJar() throws IOException {
		Resource[] resources = resolver.getResources("java/net/URL.class");
		assertEquals(1, resources.length);
		assertProtocolAndFilename(resources[0], "jar", "URL.class");
	}

	public void testClasspathStarWithPatternOnFileSystem() throws IOException {
		Resource[] resources = resolver.getResources("classpath*:org/springframework/core/io/sup*/*.class");
		// Have to exclude Clover-generated class files here,
		// as we might be running as part of a Clover test run.
		List<Resource> noCloverResources = new ArrayList<Resource>();
		for (Resource resource : resources) {
			if (!resource.getFilename().contains("$__CLOVER_")) {
				noCloverResources.add(resource);
			}
		}
		resources = noCloverResources.toArray(new Resource[noCloverResources.size()]);
		assertProtocolAndFilenames(resources, "file", CLASSES_IN_CORE_IO_SUPPORT, TEST_CLASSES_IN_CORE_IO_SUPPORT);
	}

	
	public void testClasspathWithPatternInJar() throws IOException {
		Resource[] resources = resolver.getResources("classpath:org/apache/commons/logging/*.class");
		assertProtocolAndFilenames(resources, "jar", CLASSES_IN_COMMONSLOGGING);
	}

	
	public void testClasspathStartWithPatternInJar() throws IOException {
		Resource[] resources = resolver.getResources("classpath*:org/apache/commons/logging/*.class");
		assertProtocolAndFilenames(resources, "jar", CLASSES_IN_COMMONSLOGGING);
	}

	
	public void testRootPatternRetrievalInJarFiles() throws IOException {
		Resource[] resources = resolver.getResources("classpath*:*.dtd");
		boolean found = false;
		for (Resource resource : resources) {
			if (resource.getFilename().equals("aspectj_1_5_0.dtd")) {
				found = true;
			}
		}
		assertTrue("Could not find aspectj_1_5_0.dtd in the root of the aspectjweaver jar", found);
	}


	private void assertProtocolAndFilename(Resource resource, String urlProtocol, String fileName) throws IOException {
		assertProtocolAndFilenames(new Resource[] {resource}, urlProtocol, new String[] {fileName});
	}

	private void assertProtocolAndFilenames(
			Resource[] resources, String urlProtocol, String[] fileNames1, String[] fileNames2) throws IOException {

		List<String> fileNames = new ArrayList<String>(Arrays.asList(fileNames1));
		fileNames.addAll(Arrays.asList(fileNames2));
		assertProtocolAndFilenames(resources, urlProtocol, fileNames.toArray(new String[fileNames.size()]));
	}

	private void assertProtocolAndFilenames(Resource[] resources, String urlProtocol, String[] fileNames)
			throws IOException {

		// Uncomment the following if you encounter problems with matching against the file system
		// It shows file locations.
//		String[] actualNames = new String[resources.length];
//		for (int i = 0; i < resources.length; i++) {
//			actualNames[i] = resources[i].getFilename();
//		}
//		List sortedActualNames = new LinkedList(Arrays.asList(actualNames));
//		List expectedNames = new LinkedList(Arrays.asList(fileNames));
//		Collections.sort(sortedActualNames);
//		Collections.sort(expectedNames);
//
//		System.out.println("-----------");
//		System.out.println("Expected: " + StringUtils.collectionToCommaDelimitedString(expectedNames));
//		System.out.println("Actual: " + StringUtils.collectionToCommaDelimitedString(sortedActualNames));
//		for (int i = 0; i < resources.length; i++) {
//			System.out.println(resources[i]);
//		}

		assertEquals("Correct number of files found", fileNames.length, resources.length);
		for (Resource resource : resources) {
			assertEquals(urlProtocol, resource.getURL().getProtocol());
			assertFilenameIn(resource, fileNames);
		}
	}

	private void assertFilenameIn(Resource resource, String[] fileNames) {
		for (String fileName : fileNames) {
			if (resource.getFilename().endsWith(fileName)) {
				return;
			}
		}
		fail("resource [" + resource + "] does not have a filename that matches and of the names in 'fileNames'");
	}


}
