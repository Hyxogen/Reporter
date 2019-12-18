package com.hyxogen.reporter.handlers.local.io.serialized;

import com.hyxogen.reporter.Report;
import com.hyxogen.reporter.io.IReportWriter;

import java.io.*;
import java.util.Collection;
import java.util.HashSet;

public class SerializedReportWriter implements IReportWriter {

    @Override
    public void write(Collection<? extends Report> reports, File file) {
        try {
            FileOutputStream fileOutput = new FileOutputStream(file);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

            HashSet<? extends Report> saved_list = new HashSet<>(reports);

            objectOutput.writeObject(saved_list);

            objectOutput.close();
            fileOutput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
