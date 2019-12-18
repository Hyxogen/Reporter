package com.hyxogen.reporter.io;

import com.hyxogen.reporter.Report;

import java.io.File;
import java.util.Collection;

public interface IReportWriter {

    void write(Collection<? extends Report> reports, File file);
}