package com.hyxogen.reporter.handlers;

import com.hyxogen.reporter.Report;

import java.util.Set;
import java.util.UUID;

public interface IReportHandler {

    void init();

    void save();

    Set<Report> getAll();

    Report getReport(UUID id);

    Set<Report> getAllTo(UUID reported);

    Set<Report> getAllFrom(UUID reporter);

    void add(Report report);

    void remove(Report report);
}