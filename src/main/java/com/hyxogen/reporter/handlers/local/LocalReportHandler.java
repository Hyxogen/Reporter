package com.hyxogen.reporter.handlers.local;

import com.google.gson.Gson;
import com.hyxogen.reporter.Report;
import com.hyxogen.reporter.ReporterPlugin;
import com.hyxogen.reporter.handlers.ReportHandler;

import java.io.*;
import java.util.*;

public class LocalReportHandler extends ReportHandler {

    private Set<Report> reports;
    private File reportFile;
    private Gson gson;

    public LocalReportHandler(ReporterPlugin plugin) {
        super(plugin);
    }

    @Override
    public synchronized void init() {
        gson = new Gson();
        reportFile = new File(PLUGIN.getDataFolder().getAbsolutePath() + "reports.json");
        if(!reportFile.exists()) {
            try {
                reportFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        try {
            FileReader reader = new FileReader(reportFile);
            Report[] loaded = gson.fromJson(reader, Report[].class);
            reader.close();

            reports = new HashSet<>(Arrays.asList(loaded));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void terminate() {
        try {
            FileWriter writer = new FileWriter(reportFile);
            Report[] list = reports.toArray(new Report[reports.size()]);
            writer.write(gson.toJson(list));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<Report> getAll() {
        return reports;
    }

    /**
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
     *
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
     *
     *
     * @param reporter
     * @return an empty {@link HashSet} if no reports are found matching the criteria
     */
    @Override
    public Set<Report> getAllFrom(UUID reporter) {
        Set<Report> out = new HashSet<>();
        Iterator<Report> iterator = reports.iterator();

        Report report = null;
        while(iterator.hasNext() && (report = iterator.next()) != null)
            if(report.REPORTER_UUID.equals(reporter)) out.add(report);
        return out;
    }

    @Override
    public void add(Report report) {
        reports.add(report);
    }

    @Override
    public void remove(Report report) {
        reports.remove(report);
    }
}
