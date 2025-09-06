package org.cgl.springframework.beans.factory;
/**
 * Bean 工厂接口
 */
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.core.ResolvableType;
import org.springframework.lang.Nullable;

public interface MyBeanFactory {
    String FACTORY_BEAN_PREFIX = "&"; // FactoryBean 前缀
    /**
     * 根据名称获取 Bean 实例
     * @param name Bean 名称
     * @return Bean 实例
     * @throws Exception 获取 Bean 失败时抛出异常
     */
    Object getBean(String name) throws Exception;
    /**
     * 根据名称和类型获取 Bean 实例
     * @param name Bean 名称
     * @param clazz Bean 类型
     * @param <T> 泛型类型
     * @return Bean 实例
     * @throws Exception 获取 Bean 失败时抛出异常
     */
    <T> T getBean(String name,Class<?> clazz) throws Exception;
    /**
     * 根据名称和参数获取 Bean 实例
     * @param name Bean 名称
     * @param args 构造函数参数
     * @return Bean 实例
     * @throws Exception 获取 Bean 失败时抛出异常
     */
    Object getBean(String name, Object... args) throws Exception;
    /**
     * 根据类型获取 Bean 实例
     * @param requiredType Bean 类型
     * @param <T> 泛型类型
     * @return Bean 实例
     * @throws Exception 获取 Bean 失败时抛出异常
     */
    <T> T getBean(Class<T> requiredType) throws Exception;
    /**
     * 根据类型和参数获取 Bean 实例
     * @param requiredType Bean 类型
     * @param args 构造函数参数
     * @param <T> 泛型类型
     * @return Bean 实例
     * @throws Exception 获取 Bean 失败时抛出异常
     */
    <T> T getBean(Class<T> requiredType, Object... args) throws Exception;
    /**
     * 根据类型获取 ObjectProvider 实例
     * @param requiredType Bean 类型
     * @param <T> 泛型类型
     * @return ObjectProvider 实例
     */
    <T>ObjectProvider<T> getBeanProvider(Class<T> requiredType);
    /**
     * 根据 ResolvableType 获取 ObjectProvider 实例
     * @param requiredType 可解析类型
     * @param <T> 泛型类型
     * @return ObjectProvider 实例
     */
    <T> ObjectProvider<T> getBeanProvider(ResolvableType requiredType);
    /**
     * 判断是否包含指定名称的 Bean
     * @param name Bean 名称
     * @return 如果包含，返回 true；否则返回 false
     */
    boolean containsBean(String name);
    /**
     * 判断指定名称的 Bean 是否为单例
     * @param name Bean 名称
     * @return 如果是单例，返回 true；否则返回 false
     * @throws NoSuchBeanDefinitionException 如果没有找到指定名称的 Bean，抛出此异常
     */
    boolean isSingleton(String name) throws NoSuchBeanDefinitionException;
    /**
     * 判断指定名称的 Bean 是否为原型
     * @param name Bean 名称
     * @return 如果是原型，返回 true；否则返回 false
     * @throws NoSuchBeanDefinitionException 如果没有找到指定名称的 Bean，抛出此异常
     */
    boolean isPrototype(String name) throws NoSuchBeanDefinitionException;
    /**
     * 判断指定名称的 Bean 是否与给定类型匹配
     * @param name Bean 名称
     * @param typeToMatch 要匹配的类型
     * @return 如果匹配，返回 true；否则返回 false
     * @throws NoSuchBeanDefinitionException 如果没有找到指定名称的 Bean，抛出此异常
     */
    boolean isTypeMatch(String name, ResolvableType typeToMatch) throws NoSuchBeanDefinitionException;
    /**
     * 判断指定名称的 Bean 是否与给定类型匹配
     * @param name Bean 名称
     * @param typeToMatch 要匹配的类型
     * @return 如果匹配，返回 true；否则返回 false
     * @throws NoSuchBeanDefinitionException 如果没有找到指定名称的 Bean，抛出此异常
     */
    boolean isTypeMatch(String name, Class<?> typeToMatch) throws NoSuchBeanDefinitionException;
    /**
     * 获取指定名称的 Bean 的类型
     * @param name Bean 名称
     * @return Bean 的类型
     * @throws NoSuchBeanDefinitionException 如果没有找到指定名称的 Bean，抛出此异常
     */
    @Nullable
    Class<?> getType(String name) throws NoSuchBeanDefinitionException;
    /**
     * 获取指定名称的 Bean 的类型
     * @param name Bean 名称
     * @param allowFactoryBeanInit 是否允许初始化 FactoryBean
     * @return Bean 的类型
     * @throws NoSuchBeanDefinitionException 如果没有找到指定名称的 Bean，抛出此异常
     */
    @Nullable
    Class<?> getType(String name, boolean allowFactoryBeanInit) throws NoSuchBeanDefinitionException;
    /**
     * 获取指定名称的 Bean 的别名
     * @param name Bean 名称
     * @return Bean 的别名数组
     * @throws NoSuchBeanDefinitionException 如果没有找到指定名称的 Bean，抛出此异常
     */
    String[] getAliases(String name);
}
