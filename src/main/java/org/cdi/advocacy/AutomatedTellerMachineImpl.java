package org.cdi.advocacy;

import org.cdi.advocacy.cdi.JsonRest;
import org.cdi.advocacy.cdi.Soap;
import org.cdi.advocacy.cdi.Standard;
import org.cdi.advocacy.util.Logger;

import javax.annotation.PostConstruct;
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

    private ATMTransport transport;

    @Inject @Soap
    private ATMTransport soapTransport;

    @Inject @JsonRest
    private ATMTransport jsonTransport;

    @Inject @Standard
    private ATMTransport standardTransport;

    //These could be looked up in a DB, JNDI or a properties file.
    private boolean useJSON = false;
    private boolean behindFireWall = true;

    @PostConstruct
    protected void init() {
        //Look up values for useJSON and behindFireWall

        if (!behindFireWall) {
            transport = standardTransport;
        } else {
            if (useJSON) {
                transport = jsonTransport;
            } else {
                transport = soapTransport;
            }
        }

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
