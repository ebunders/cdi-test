package org.cdi.advocacy;

/**
 * Created by ernst on 14-12-14.
 */
public interface ATMTransport {
    public void communicateWithBank(byte[] datapacket);

    public void setRetries(int retries);
}
