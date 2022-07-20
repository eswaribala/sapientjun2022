package com.sapient;

import com.sapient.models.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        Resource resource=new ClassPathResource("spring-core.xml");
        BeanFactory beanFactory=new XmlBeanFactory(resource);
        //IOC
        Vehicle vehicle= (Vehicle) beanFactory.getBean("vehicle");
        logger.info("Vehicle Object Created"+vehicle.getCost());

    }
}
