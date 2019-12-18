package com.hyxogen.reporter.handlers.local.io;

import com.google.gson.Gson;
import com.hyxogen.reporter.Report;
import com.hyxogen.reporter.io.IReportWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class JSONReportWriter implements IReportWriter {

    @Override
    public void write(Collection<? extends Report> reports, File file) {
        Report[] save_list = reports.toArray(new Report[reports.size()]);
        FileWriter writer = null;

        try {
            writer = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        gson.toJson(gson.toJson(save_list), Report[].class, writer);
    }
}
