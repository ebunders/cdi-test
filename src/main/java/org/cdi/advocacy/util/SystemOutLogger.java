package org.cdi.advocacy.util;

import java.util.Date;

/**
 * Created by ernst on 14-12-14.
 */
public class SystemOutLogger implements Logger {
    @Override
    public void log(String msg) {
        System.out.println(new Date().toString() + ">> " + msg);
    }
}
