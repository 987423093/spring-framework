package org.springframework.beans.factory;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * @author zhoutao
 * @date 2019/8/21
 */
public class UseIOC {

    @Test
    public void userIOC(){

        //加载资源
        ClassPathResource resource = new ClassPathResource("bean.xml");
        //获取bean工厂
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //根据BeanFactory创建一个BeanDefinitionReader对象
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        //装载资源
        reader.loadBeanDefinitions(resource);
    }

    @Test
    public void testCharacterLetter(){

        System.out.println(Boolean.TRUE.equals(Character.isLetter('a')));

    }
}
