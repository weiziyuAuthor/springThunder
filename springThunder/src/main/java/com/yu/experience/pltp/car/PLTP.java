package com.yu.experience.pltp.car;



/**
 * 
 * @author ziyu.wei
 * 2015��3��14�� ����10:45:39
 * 
 * 
 */
public class PLTP {
	
	/**
	 * ����spring�����Լ��������ļ�ɨ����
	 * ɨ��basePackage��������@MyBatisRepository��ʶ�� �ӿ�
	 */
	private void myBatisRepository() {
/*
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<property name="basePackage" value="com.sinoiov.pltp.find.vehicle.service.dao.mapper" />
		<property name="annotationClass" value="com.sinoiov.pltp.find.vehicle.service.dao.mapper.MyBatisRepository" />
	</bean>
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	@Documented
	@Component
	public @interface MyBatisRepository {
		String value() default "";
	}
	
	 
	@MyBatisRepository
	public interface AreaInfoMapper		
 */
	}
	
	/**
	 * ����spring�����ļ�λ��
	 */
	private void mybatisXmlConfig() {
/*
 * 
 * <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource" />
		<property name="configLocation" value="classpath:/mybatis/mybatis-config.xml"></property>
		<property name="mapperLocations">
			<value>classpath*:com/sinoiov/pltp/find/vehicle/service/dao/mapper/xml/*.xml</value>
		</property>
	</bean> 		
 */
	}
	
	/*
	 * �����ܻ���Ӱ���ױ�ı���
	 */
	private void defineEnvConstant() {
/*
 * 	<bean
		class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
		<property name="systemPropertiesModeName" value="SYSTEM_PROPERTIES_MODE_OVERRIDE" />
		<property name="ignoreResourceNotFound" value="true" />
		<property name="locations">
			<list>
				 <value>file:///${catalina.home}/etc/vehicle_service/application.properties</value>
				 <value>classpath:/jdbc.properties</value>
			</list>
		</property>
	</bean>		
 */
	}
	
	/**
	 * ��������,�����û���ʱ��
	 */
	private void readConfigHottly() {
/*
4.
 * <bean id="appConfigSource"
		class="com.sinoiov.pltp.find.vehicle.service.common.ReloadableResourceBundle">
		<property name="basenames">
			<list>
				<value>file:///${catalina.home}/etc/vehicle_service/constant</value>
			</list>
		</property>
		<property name="cacheSeconds" value="3600"/>
	</bean>		
 */
	}
	
	/**
	 * ���������ļ�������PropertiesΪ java.util.Properties
	 */
	private void loadPropertyByExtends() {
/*
 * public class Configure extends Properties {
	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(Configure.class);

	private static Configure instance = null;

	private Configure() {

		try {
			load(new FileInputStream(new File(System.getProperty("catalina.home") + "/etc/cargo/cargo.properties")));
		} catch (Throwable e) {
			logger.warn(e.getMessage(), e);
		}
	}

	public static Configure getInstance() {

		if (instance == null) {
			instance = new Configure();
		}

		return instance;
	}

	public static String getString(String key) {
		return getInstance().getProperty(key);
	}

	public static String getString(String key, String defaultValue) {
		return getInstance().getProperty(key, defaultValue);
	}

	public static int getInt(String key) {

		try {
			return Integer.valueOf(getInstance().getProperty(key));
		} catch (Throwable e) {
		}

		return 0;
	}

	public static int getInt(String key, int defaultValue) {

		try {
			return Integer.valueOf(getInstance().getProperty(key, String.valueOf(defaultValue)));
		} catch (Throwable e) {
		}

		return 0;
	}
} 		
 */
	}
	
	/**
	 * ����Spring aop��������
	 */
	private void aopSpringTransaction() {
/*
 * <bean id="transactionManager"
		class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource" />
	</bean>

	<tx:advice id="txAdvice" transaction-manager="transactionManager">
		<tx:attributes>
			<tx:method name="get*" propagation="SUPPORTS" read-only="true" />
			<tx:method name="query*" propagation="SUPPORTS" read-only="true" />
			<tx:method name="save*" propagation="SUPPORTS" read-only="true" />
			<tx:method name="*" propagation="REQUIRED" read-only="false"
				rollback-for="Exception" />
		</tx:attributes>
	</tx:advice>

	<aop:config proxy-target-class="false">
		<aop:pointcut id="txPointcut"
			expression="execution(* com.sinoiov.pltp.find.vehicle.service.logic..*(..))" />
		<aop:advisor advice-ref="txAdvice" pointcut-ref="txPointcut" />
	</aop:config>		
 */
	}
	
	private void why1() {
/*
 //���ͷ���
 public interface Main {
	<T> T getBean();
}

//������
public interface Main<T> {
	T getBean();
} 	

	
	class ArrayAlg{
		public static <T> T min(T[] a) {
			if (a == null || a.length == 0) {
				return null;
			}
			
			T smallest = a[0];
			for (int i=1; i<a.length; i++) {
				if (smallest.compareTo(a[i]) > 0) {
					smallest = a[i];
				}
			}
			return smallest;
		}
	}
	
	������ smallest ����ΪT , ����ζ�����������κ�һ����Ķ���Ҫȷ��T����������compareTo����
	����ʽ�� public static <T extends Comparable> T min(T[] a) 
	
	
//ͨ�������
Pair<? extends Employee>
��ʾ���Ͳ�����Employee������

	//ͨ����ĳ������޶�
	public static void minmaxBonus(Manager[] a, Pair<? super Manager> result){
		...
	} 
	
	//���޶�ͨ���
	Pair<?>
	
	
	



 */
	}
}
