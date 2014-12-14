package org.cdi.advocacy;

import org.cdi.advocacy.cdi.TransportConfig;
import org.cdi.advocacy.util.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;

/**
 * This version shows how to handle runtime selection of proper implementation
 * It uses default qualifiers, and the @PostConstruct CDI callback to make the switch.
 * The thing is: all three are instantiated, one is used. Seems a bit messy to me.
 * This is obviously a case for a @Produce factory method. Too contrived.
 * But still....
 */
@Named("atm")
public class AutomatedTellerMachineImpl implements AutomatedTellerMachine{


    @Inject
    private Logger logger;

    @Inject
    @TransportConfig(retries = 2)
    private ATMTransport transport;

    @Override
    public void deposit(BigDecimal bd) {
        logger.log("deposit called");
        transport.communicateWithBank(("depositing" +bd.toString()).getBytes());
    }

    @Override
    public void withdraw(BigDecimal bd) {
        logger.log("withdraw called");
        transport.communicateWithBank(("withdrawing" + bd.toString()).getBytes());
    }
}
