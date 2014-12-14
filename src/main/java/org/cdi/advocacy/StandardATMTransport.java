package org.cdi.advocacy;

import org.cdi.advocacy.cdi.Standard;

import javax.enterprise.inject.Default;
import java.nio.charset.Charset;

/**
 * Created by ernst on 14-12-14.
 */
@Standard
public class StandardATMTransport implements ATMTransport {
    @Override
    public void communicateWithBank(byte[] datapacket) {
        System.out.println("Communicating with bank via Standard transport: " + new String(datapacket, Charset.defaultCharset()) );
    }
}
