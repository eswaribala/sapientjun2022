package com.sapient.utility;

import com.sapient.models.Owner;
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
        Vehicle vehicle1= (Vehicle) beanFactory.getBean("vehicle1");
        logger.info("Vehicle1 Object Created,"+vehicle1);

        Vehicle vehicle2=(Vehicle) beanFactory.getBean("vehicle1");
        logger.info("Vehicle2 Object Created,"+vehicle2);
        //modifying property

        vehicle2.setMake("Hyundai");

        logger.info("Vehicle1 Object Created,"+vehicle1);
        logger.info("Vehicle2 Object Created,"+vehicle2);

        Owner owner= (Owner) beanFactory.getBean("owner");
        for(Vehicle vehicle: owner.getVehicleList()){
            logger.info("Vehicle of the Owner,"+vehicle);
        }


    }
}
