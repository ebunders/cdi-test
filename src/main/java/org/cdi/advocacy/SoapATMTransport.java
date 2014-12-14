package org.cdi.advocacy;

import org.cdi.advocacy.cdi.TransportType;
import org.cdi.advocacy.cdi.Transportation;
import org.cdi.advocacy.util.AbstractTransport;

import java.nio.charset.Charset;

/**
 * Created by ernst on 14-12-14.
 */
@Transportation(type= TransportType.SOAP)
public class SoapATMTransport extends AbstractTransport {
    @Override
    public void communicateWithBank(byte[] datapacket) {
        System.out.println("Communicating with bank via Soap transport: " + new String(datapacket, Charset.defaultCharset()) );
        System.out.println("retrying: " + retries + " times");
    }
}
