package org.cdi.advocacy;

import javax.enterprise.inject.Alternative;
import java.nio.charset.Charset;

/**
 * Created by ernst on 14-12-14.
 */
@Alternative
public class JsonRestATMTransport implements ATMTransport {
    @Override
    public void communicateWithBank(byte[] datapacket) {

        System.out.println("Communicating with bank via Json Rest transport: " + new String(datapacket, Charset.defaultCharset()) );

    }
}