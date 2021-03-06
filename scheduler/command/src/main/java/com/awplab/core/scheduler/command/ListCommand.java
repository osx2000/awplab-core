package com.awplab.core.scheduler.command;


import com.awplab.core.scheduler.service.SchedulerManager;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.fusesource.jansi.Ansi;
import org.quartz.Scheduler;

/**
 * Created by andyphillips404 on 2/25/15.
 */
@Command(scope = "scheduler", name="list")
@Service
public class ListCommand implements Action {

    @Reference
    SchedulerManager schedulerManager = null;

    @Override
    public Object execute() throws Exception {



        for (Scheduler scheduler : schedulerManager.getSchedulers()) {
            System.out.println(Ansi.ansi().fg(Ansi.Color.WHITE).bold().a(scheduler.getSchedulerName()).reset().toString());
            System.out.println(scheduler.getMetaData().toString());
        }

        return null;
    }

}
