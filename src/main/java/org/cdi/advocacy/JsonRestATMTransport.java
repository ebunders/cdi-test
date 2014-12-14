package org.cdi.advocacy;

import org.cdi.advocacy.cdi.JsonRest;

import javax.enterprise.inject.Alternative;
import java.nio.charset.Charset;

/**
 * Created by ernst on 14-12-14.
 */
@JsonRest
public class JsonRestATMTransport implements ATMTransport {
    @Override
    public void communicateWithBank(byte[] datapacket) {

        System.out.println("Communicating with bank via Json Rest transport: " + new String(datapacket, Charset.defaultCharset()) );

    }
}
