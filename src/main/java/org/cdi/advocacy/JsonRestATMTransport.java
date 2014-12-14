package org.cdi.advocacy;

import org.cdi.advocacy.cdi.TransportType;
import org.cdi.advocacy.cdi.Transportation;

import java.nio.charset.Charset;

/**
 * Created by ernst on 14-12-14.
 */
@Transportation(type = TransportType.JSON)
public class JsonRestATMTransport implements ATMTransport {
    @Override
    public void communicateWithBank(byte[] datapacket) {

        System.out.println("Communicating with bank via Json Rest transport: " + new String(datapacket, Charset.defaultCharset()) );

    }
}
