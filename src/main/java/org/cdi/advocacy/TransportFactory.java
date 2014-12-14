package org.cdi.advocacy;

import org.cdi.advocacy.cdi.Soap;
import org.cdi.advocacy.util.Logger;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 * Created by ernst on 14-12-14.
 */
public class TransportFactory {

    @Inject
    private final Logger logger = null;

    @Produces
    public ATMTransport createTransport(){
        logger.log("Transport factory creates Soap instance");
        return new SoapATMTransport();
    }
}
