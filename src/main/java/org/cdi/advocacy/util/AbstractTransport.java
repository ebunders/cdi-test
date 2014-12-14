package org.cdi.advocacy.util;

import org.cdi.advocacy.ATMTransport;

/**
 * Created by ernst on 14-12-14.
 */
public abstract class AbstractTransport implements ATMTransport {
    protected int retries = 5;
    @Override
    public final void setRetries(int retries) {
        this.retries = retries;
    }
}
