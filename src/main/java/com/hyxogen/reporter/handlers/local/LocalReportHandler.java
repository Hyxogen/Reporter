package com.hyxogen.reporter.handlers.local;

import com.hyxogen.reporter.Report;
import com.hyxogen.reporter.handlers.IReportHandler;
import com.hyxogen.reporter.io.IReportReader;
import com.hyxogen.reporter.io.IReportWriter;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

public class LocalReportHandler implements IReportHandler {

    public final IReportReader READER;
    public final IReportWriter WRITER;
    public final File REPORT_FILE;

    private Set<Report> reports = new HashSet<>();

    public LocalReportHandler(IReportReader reader, IReportWriter writer, File file) {
        READER = reader;
        WRITER = writer;
        REPORT_FILE = file;
    }

    @Override
    public synchronized void init() {
        reports.addAll(READER.getAll(REPORT_FILE));
    }

    @Override
    public void save() {
        WRITER.write(reports, REPORT_FILE);
    }

    /**
     * Get all reports stored in memory
     *
     * @return an empty {@link Set} if no reports are stored in memory
     */
    @Override
    public Set<Report> getAll() {
        return reports;
    }

    /**
     * Get report with specific using the unique id
     *
     * @param id
     * @return null if no reports with id is found
     */
    @Override
    public Report getReport(UUID id) {
        Iterator<Report> iterator = reports.iterator();

        Report report = null;
        while(iterator.hasNext() && (report = iterator.next()) != null)
            if(report.REPORT_ID.equals(id)) return report;
        return null;
    }

    /**
     * Gets all the reports that have been sent to the user
     * @param reported
     * @return an empty {@link HashSet} if no reports are found matching the criteria
     */
    @Override
    public Set<Report> getAllTo(UUID reported) {
        Set<Report> out = new HashSet<>();
        Iterator<Report> iterator = reports.iterator();

        Report report = null;
        while(iterator.hasNext() && (report = iterator.next()) != null)
            if(report.REPORTED_UUID.equals(reported)) out.add(report);
        return out;
    }

    /**
     * Get all the reports that the user has sent to others
     * @param reporter
     * @return an empty {@link HashSet} if no reports are found matching the criteria
     */
    @Override
    public Set<Report> getAllFrom(UUID reporter) {
        Set<Report> out = new HashSet<>();
        Iterator<Report> iterator = reports.iterator();

        Report report = null;
        while (iterator.hasNext() && (report = iterator.next()) != null)
            if (report.REPORTER_UUID.equals(reporter)) out.add(report);
        return out;
    }

    /**
     * Add a report to the database to be stored
     *
     * @param report
     */
    @Override
    public void add(Report report) {
        reports.add(report);
    }

    /**
     * Permanently remove a report from memory and storage
     *
     * @param report
     */
    @Override
    public void remove(Report report) {
        reports.remove(report);
    }
}
