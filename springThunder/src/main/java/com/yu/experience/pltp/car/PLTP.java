package com.yu.experience.pltp.car;



/**
 *
 * @author ziyu.wei 2015年3月14日 上午10:45:39
 *
 *
 */
public class PLTP {

  /**
   * 利用spring定义自己的配置文件扫描器 扫描basePackage下所有以@MyBatisRepository标识的 接口
   */
  private void myBatisRepository() {
    /*
     * <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer"> <property name="basePackage"
     * value="com.sinoiov.pltp.find.vehicle.service.dao.mapper" /> <property name="annotationClass"
     * value="com.sinoiov.pltp.find.vehicle.service.dao.mapper.MyBatisRepository" /> </bean>
     * 
     * @Retention(RetentionPolicy.RUNTIME)
     * 
     * @Target(ElementType.TYPE)
     * 
     * @Documented
     * 
     * @Component public @interface MyBatisRepository { String value() default ""; }
     * 
     * 
     * @MyBatisRepository public interface AreaInfoMapper
     */
  }

  /**
   * 定义spring配置文件位置
   */
  private void mybatisXmlConfig() {
    /*
     * 
     * <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean"> <property
     * name="dataSource" ref="dataSource" /> <property name="configLocation"
     * value="classpath:/mybatis/mybatis-config.xml"></property> <property name="mapperLocations">
     * <value>classpath*:com/sinoiov/pltp/find/vehicle/service/dao/mapper/xml/*.xml</value>
     * </property> </bean>
     */
  }

  /*
   * 定义受环境影响易变的变量
   */
  private void defineEnvConstant() {
    /*
     * <bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
     * <property name="systemPropertiesModeName" value="SYSTEM_PROPERTIES_MODE_OVERRIDE" />
     * <property name="ignoreResourceNotFound" value="true" /> <property name="locations"> <list>
     * <value>file:///${catalina.home}/etc/vehicle_service/application.properties</value>
     * <value>classpath:/jdbc.properties</value> </list> </property> </bean>
     */
  }

  /**
   * 环境配置,并设置缓存时间
   */
  private void readConfigHottly() {
    /*
     * 4. <bean id="appConfigSource"
     * class="com.sinoiov.pltp.find.vehicle.service.common.ReloadableResourceBundle"> <property
     * name="basenames"> <list> <value>file:///${catalina.home}/etc/vehicle_service/constant</value>
     * </list> </property> <property name="cacheSeconds" value="3600"/> </bean>
     */
  }

  /**
   * 加载配置文件，其中Properties为 java.util.Properties
   */
  private void loadPropertyByExtends() {
    /*
     * public class Configure extends Properties { private static final long serialVersionUID = 1L;
     * 
     * private static Logger logger = LoggerFactory.getLogger(Configure.class);
     * 
     * private static Configure instance = null;
     * 
     * private Configure() {
     * 
     * try { load(new FileInputStream(new File(System.getProperty("catalina.home") +
     * "/etc/cargo/cargo.properties"))); } catch (Throwable e) { logger.warn(e.getMessage(), e); } }
     * 
     * public static Configure getInstance() {
     * 
     * if (instance == null) { instance = new Configure(); }
     * 
     * return instance; }
     * 
     * public static String getString(String key) { return getInstance().getProperty(key); }
     * 
     * public static String getString(String key, String defaultValue) { return
     * getInstance().getProperty(key, defaultValue); }
     * 
     * public static int getInt(String key) {
     * 
     * try { return Integer.valueOf(getInstance().getProperty(key)); } catch (Throwable e) { }
     * 
     * return 0; }
     * 
     * public static int getInt(String key, int defaultValue) {
     * 
     * try { return Integer.valueOf(getInstance().getProperty(key, String.valueOf(defaultValue))); }
     * catch (Throwable e) { }
     * 
     * return 0; } }
     */
  }

  /**
   * 利用Spring aop控制事务
   */
  private void aopSpringTransaction() {
    /*
     * <bean id="transactionManager"
     * class="org.springframework.jdbc.datasource.DataSourceTransactionManager"> <property
     * name="dataSource" ref="dataSource" /> </bean>
     * 
     * <tx:advice id="txAdvice" transaction-manager="transactionManager"> <tx:attributes> <tx:method
     * name="get*" propagation="SUPPORTS" read-only="true" /> <tx:method name="query*"
     * propagation="SUPPORTS" read-only="true" /> <tx:method name="save*" propagation="SUPPORTS"
     * read-only="true" /> <tx:method name="*" propagation="REQUIRED" read-only="false"
     * rollback-for="Exception" /> </tx:attributes> </tx:advice>
     * 
     * <aop:config proxy-target-class="false"> <aop:pointcut id="txPointcut"
     * expression="execution(* com.sinoiov.pltp.find.vehicle.service.logic..*(..))" /> <aop:advisor
     * advice-ref="txAdvice" pointcut-ref="txPointcut" /> </aop:config>
     */
  }

  private void why1() {
    /*
     * //泛型方法 public interface Main { <T> T getBean(); }
     * 
     * //泛型类 public interface Main<T> { T getBean(); }
     * 
     * 
     * class ArrayAlg{ public static <T> T min(T[] a) { if (a == null || a.length == 0) { return
     * null; }
     * 
     * T smallest = a[0]; for (int i=1; i<a.length; i++) { if (smallest.compareTo(a[i]) > 0) {
     * smallest = a[i]; } } return smallest; } }
     * 
     * 分析： smallest 类型为T , 这意味着它可以是任何一个类的对象。要确信T所属的类有compareTo方法 处理方式： public static <T extends
     * Comparable> T min(T[] a)
     * 
     * 
     * //通配符类型 Pair<? extends Employee> 表示类型参数是Employee的子类
     * 
     * //通配符的超类型限定 public static void minmaxBonus(Manager[] a, Pair<? super Manager> result){ ... }
     * 
     * //无限定通配符 Pair<?>
     */
  }
}
