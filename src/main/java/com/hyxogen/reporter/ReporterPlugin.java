package com.hyxogen.reporter;

import com.hyxogen.reporter.handlers.ReportHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class ReporterPlugin extends JavaPlugin {

    private ReportHandler reportHandler;

    public void onEnable() {

    }

    public void onDisable() {

    }

    public ReportHandler getReportHandler() {
        return reportHandler;
    }
}
