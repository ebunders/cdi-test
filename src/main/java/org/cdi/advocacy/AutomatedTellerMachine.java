package org.cdi.advocacy;

import java.math.BigDecimal;

/**
 * Created by ernst on 14-12-14.
 */
public interface AutomatedTellerMachine {
    public abstract void deposit(BigDecimal bd);

    public abstract void withdraw(BigDecimal bd);
}
