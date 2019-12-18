package com.hyxogen.reporter;

import com.hyxogen.reporter.handlers.IReportHandler;
import com.hyxogen.reporter.io.Config;
import org.bukkit.plugin.java.JavaPlugin;

public class ReporterPlugin extends JavaPlugin {

    private IReportHandler reportHandler;
    private Config config;

    public void onEnable() {
        reportHandler.init();
    }

    public void onDisable() {
        reportHandler.save();
    }

    public IReportHandler getReportHandler() {
        return reportHandler;
    }

    public Config getPluginConfig() { return config; }
}
