package com.hyxogen.reporter.io;

import com.hyxogen.reporter.Report;

import java.io.File;
import java.util.Collection;

public interface IReportReader {

    Collection<? extends Report> getAll(File file);
}