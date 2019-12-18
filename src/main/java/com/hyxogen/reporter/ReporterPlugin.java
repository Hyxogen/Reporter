package com.hyxogen.reporter;

import com.hyxogen.reporter.handlers.IReportHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class ReporterPlugin extends JavaPlugin {

    private IReportHandler reportHandler;

    public void onEnable() {
        reportHandler.init();
    }

    public void onDisable() {
        reportHandler.save();
    }

    public IReportHandler getReportHandler() {
        return reportHandler;
    }
}
