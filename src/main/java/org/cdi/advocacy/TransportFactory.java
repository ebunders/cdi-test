package org.cdi.advocacy;

import org.cdi.advocacy.cdi.Soap;
import org.cdi.advocacy.util.Logger;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 * Created by ernst on 14-12-14.
 */
public class TransportFactory {

    //These could be looked up in a DB, JNDI or a properties file.
    private boolean useJSON = true;
    private boolean behindFireWall = true;

    @Inject
    private final Logger logger = null;

    @Produces
    public ATMTransport createTransport(){
        logger.log("Transport factory decides what transport you will use!");
        if (!behindFireWall) {
            logger.log(">> using standard");
            return new StandardATMTransport();
        } else {
            if (useJSON) {
                logger.log(">> using json rest");
                return new JsonRestATMTransport();
            } else {
                logger.log(">> using soap");
                return new SoapATMTransport();
            }
        }
    }
}
