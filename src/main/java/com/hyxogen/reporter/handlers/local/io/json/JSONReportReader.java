package com.hyxogen.reporter.handlers.local.io.json;

import com.google.gson.Gson;
import com.hyxogen.reporter.Report;
import com.hyxogen.reporter.io.IReportReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

public class JSONReportReader implements IReportReader {

    /**
     * @param file
     * @return null if file could not be found
     */
    @Override
    public Collection<? extends Report> getAll(File file) {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader(file);

            Report[] reports = gson.fromJson(reader, Report[].class);
            reader.close();
            return Arrays.asList(reports);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
