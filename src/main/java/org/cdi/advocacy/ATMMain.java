package org.cdi.advocacy;

import org.cdisource.beancontainer.BeanContainer;
import org.cdisource.beancontainer.BeanContainerManager;

import java.math.BigDecimal;

/**
 * Created by ernst on 14-12-14.
 */
public class ATMMain {
    static BeanContainer beanContainer =  BeanContainerManager.getInstance();

    public static void main(String[] args) {
        AutomatedTellerMachine atm = beanContainer.getBeanByType(AutomatedTellerMachine.class);
        atm.withdraw(new BigDecimal(10.05));
        atm.deposit(new BigDecimal(15.00));
    }
}
