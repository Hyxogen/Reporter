package com.hyxogen.reporter.handlers;

import com.hyxogen.reporter.Report;
import com.hyxogen.reporter.ReporterPlugin;

import java.util.Set;
import java.util.UUID;

public abstract class ReportHandler {

    public final ReporterPlugin PLUGIN;

    protected ReportHandler(ReporterPlugin plugin) {
        this.PLUGIN = plugin;
    }

    public abstract void init();

    public abstract void terminate();

    public abstract Set<Report> getAll();

    public abstract Report getReport(UUID id);

    public abstract Set<Report> getAllTo(UUID reported);

    public abstract Set<Report> getAllFrom(UUID reporter);

    public abstract void add(Report report);

    public abstract void remove(Report report);
}