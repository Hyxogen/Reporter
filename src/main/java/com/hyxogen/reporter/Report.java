package com.hyxogen.reporter;

import java.io.Serializable;
import java.util.UUID;

public class Report implements Serializable {

    public final UUID REPORT_ID;

    public final UUID REPORTED_UUID;
    public final UUID REPORTER_UUID;
    private String notes;

    public Report(UUID reported, UUID reporter) {
        this(reported, reporter, null, UUID.randomUUID());
    }

    public Report(UUID reported, UUID reporter, String notes) {
        this(reported, reporter, notes, UUID.randomUUID());
    }

    public Report(UUID reported, UUID reporter, String notes, UUID reportID) {
        this.REPORTED_UUID = reported;
        this.REPORTER_UUID = reporter;
        this.notes = notes;
        this.REPORT_ID = reportID;
    }
}