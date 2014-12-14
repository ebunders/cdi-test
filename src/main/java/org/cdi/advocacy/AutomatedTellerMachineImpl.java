package org.cdi.advocacy;

import org.cdi.advocacy.cdi.Soap;
import org.cdi.advocacy.util.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;

/**
 * Created by ernst on 14-12-14.
 */
@Named("atm")
public class AutomatedTellerMachineImpl implements AutomatedTellerMachine{
    private final ATMTransport transport;

    @Inject
    private Logger logger;

    @Inject
    public AutomatedTellerMachineImpl(ATMTransport transport) {
        this.transport = transport;
    }

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
