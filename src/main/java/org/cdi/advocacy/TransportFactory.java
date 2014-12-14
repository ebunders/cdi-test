package org.cdi.advocacy;

import org.cdi.advocacy.cdi.TransportType;
import org.cdi.advocacy.cdi.Transportation;
import org.cdi.advocacy.util.Logger;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 * Created by ernst on 14-12-14.
 */
public class TransportFactory {

    //These could be looked up in a DB, JNDI or a properties file.
    private boolean useJSON = false;
    private boolean behindFireWall = true;

    @Inject
    private Logger logger;

    @Produces
    public ATMTransport createTransport(
            @Transportation(type= TransportType.SOAP) ATMTransport soapTransport,
            @Transportation(type= TransportType.STANDARD) ATMTransport standardTransport,
            @Transportation(type= TransportType.JSON) ATMTransport jsonRestTransport){
        logger.log("Transport factory decides what transport you will use!");
        if (!behindFireWall) {
            logger.log(">> using standard");
            return standardTransport;
        } else {
            if (useJSON) {
                logger.log(">> using json rest");
                return jsonRestTransport;
            } else {
                logger.log(">> using soap");
                return soapTransport;
            }
        }
    }
}
