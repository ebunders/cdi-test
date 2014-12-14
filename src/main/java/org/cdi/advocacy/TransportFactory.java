package org.cdi.advocacy;

import org.cdi.advocacy.cdi.TransportConfig;
import org.cdi.advocacy.cdi.TransportType;
import org.cdi.advocacy.cdi.Transportation;
import org.cdi.advocacy.util.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import java.lang.annotation.Annotation;

/**
 * Created by ernst on 14-12-14.
 */
public class TransportFactory {


    @Inject
    private Logger logger;

    @Produces
    public ATMTransport createTransport(InjectionPoint injectionPoint){
//        logger.log("Transport factory decides what transport you will use!");
//        System.out.println("annotated " + injectionPoint.getAnnotated());
//        System.out.println("bean " + injectionPoint.getBean());
//        System.out.println("member " + injectionPoint.getMember());
//        System.out.println("qualifiers " + injectionPoint.getQualifiers());
//        System.out.println("type " + injectionPoint.getType());
//        System.out.println("isDelegate " + injectionPoint.isDelegate());
//        System.out.println("isTransient " + injectionPoint.isTransient());
//
//        Bean<?> bean = injectionPoint.getBean();
//
//        System.out.println("bean.beanClass " + bean.getBeanClass());
//        System.out.println("bean.injectionPoints " + bean.getInjectionPoints());
//        System.out.println("bean.name " + bean.getName());
//        System.out.println("bean.qualifiers " + bean.getQualifiers());
//        System.out.println("bean.scope " + bean.getScope());
//        System.out.println("bean.stereotypes " + bean.getStereotypes());
//        System.out.println("bean.types " + bean.getTypes());
//
        Annotated annotated = injectionPoint.getAnnotated();
//        System.out.println("annotated.annotations " + annotated.getAnnotations());
//        System.out.println("annotated.annotations " + annotated.getBaseType());
//        System.out.println("annotated.typeClosure " + annotated.getTypeClosure());


        StandardATMTransport standardATMTransport = new StandardATMTransport();
        standardATMTransport.setRetries(annotated.getAnnotation(TransportConfig.class).retries());
        return standardATMTransport;
    }
}
