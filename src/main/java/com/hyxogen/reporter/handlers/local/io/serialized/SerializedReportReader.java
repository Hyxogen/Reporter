package com.hyxogen.reporter.handlers.local.io.serialized;

import com.hyxogen.reporter.Report;
import com.hyxogen.reporter.io.IReportReader;

import java.io.*;
import java.util.Collection;
import java.util.HashSet;

public class SerializedReportReader implements IReportReader {

    /**
     * @param file
     * @return null if file could not be found
     */
    @Override
    public Collection<? extends Report> getAll(File file) {
        try {
            FileInputStream fileInput = new FileInputStream(file);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            HashSet<Report> reports = (HashSet<Report>) objectInput.readObject();

            objectInput.close();
            fileInput.close();

            return reports;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
