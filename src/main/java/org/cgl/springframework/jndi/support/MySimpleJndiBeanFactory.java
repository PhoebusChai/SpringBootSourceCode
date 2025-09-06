package org.cgl.springframework.jndi.support;

import org.cgl.springframework.beans.factory.MyBeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.core.ResolvableType;

import java.util.HashMap;
import java.util.Map;

public class MySimpleJndiBeanFactory implements MyBeanFactory{
    // 模拟JNDI容器
    private Map<String, Object> beans=new HashMap<>();

    /**
     * 根据名称获取 Bean 实例
     * @param name Bean 名称
     * @return Bean 实例
     * @throws Exception 获取 Bean 失败时抛出异常
     */
    @Override
    public Object getBean(String name) throws Exception {
        return beans.get(name);
    }

    @Override
    public <T> T getBean(String name, Class<?> clazz) throws Exception {
        return null;
    }

    @Override
    public Object getBean(String name, Object... args) throws Exception {
        return null;
    }
    /**
     * 根据类型获取 Bean 实例
     * @param requiredType Bean 类型
     * @param <T> 泛型类型
     * @return Bean 实例
     * @throws Exception 获取 Bean 失败时抛出异常
     */
    @Override
    public <T> T getBean(Class<T> requiredType) throws Exception {
        for (Object bean : beans.values()) {
            if (requiredType.isInstance(bean)) {
                return requiredType.cast(bean);
            }
        }
        throw new RuntimeException("没有找到类型为 " + requiredType.getName() + " 的 Bean");
    }

    @Override
    public <T> T getBean(Class<T> requiredType, Object... args) throws Exception {
        return null;
    }

    @Override
    public <T> ObjectProvider<T> getBeanProvider(Class<T> requiredType) {
        return null;
    }

    @Override
    public <T> ObjectProvider<T> getBeanProvider(ResolvableType requiredType) {
        return null;
    }

    @Override
    public boolean containsBean(String name) {
        return false;
    }

    @Override
    public boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return false;
    }

    @Override
    public boolean isPrototype(String name) throws NoSuchBeanDefinitionException {
        return false;
    }

    @Override
    public boolean isTypeMatch(String name, ResolvableType typeToMatch) throws NoSuchBeanDefinitionException {
        return false;
    }

    @Override
    public boolean isTypeMatch(String name, Class<?> typeToMatch) throws NoSuchBeanDefinitionException {
        return false;
    }

    @Override
    public Class<?> getType(String name) throws NoSuchBeanDefinitionException {
        return null;
    }

    @Override
    public Class<?> getType(String name, boolean allowFactoryBeanInit) throws NoSuchBeanDefinitionException {
        return null;
    }

    @Override
    public String[] getAliases(String name) {
        return new String[0];
    }
}
