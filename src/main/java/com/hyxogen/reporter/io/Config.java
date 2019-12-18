package com.hyxogen.reporter.io;

import java.io.File;
import java.util.HashMap;

public abstract class Config extends HashMap<Integer, Object> {

    public final File FILE;

    public Config(File file) {
        FILE = file;
    }

    public abstract void load();

    @Override
    public final Object remove(Object key) {
        throw new UnsupportedOperationException("Cannot remove entries from a config file!");
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException("Cannot remove entries from a config file!");
    }
}