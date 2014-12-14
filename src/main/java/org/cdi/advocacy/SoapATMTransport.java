package org.cdi.advocacy;

import org.cdi.advocacy.cdi.Soap;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import java.nio.charset.Charset;

/**
 * Created by ernst on 14-12-14.
 */
@Default
public class SoapATMTransport implements ATMTransport {
    @Override
    public void communicateWithBank(byte[] datapacket) {
        System.out.println("Communicating with bank via Soap transport: " + new String(datapacket, Charset.defaultCharset()) );
    }
}
