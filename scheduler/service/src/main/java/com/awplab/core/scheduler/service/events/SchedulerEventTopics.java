package com.awplab.core.scheduler.service.events;

import com.awplab.core.common.EventAdminHelper;
import org.quartz.Scheduler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by andyphillips404 on 3/8/15.
 */
public final class SchedulerEventTopics {
    private SchedulerEventTopics() {
    }

    public static final String BASE = "com/awplab/core/scheduler/events";

    public static final String ANY = BASE + "/*";

    public static final String MANAGER_STARTED = BASE + "/MANAGER_STARTED";
    public static final String MANAGER_STOPPED = BASE + "/MANAGER_STOPPED";

    public static final String JOB_SCHEDULED = BASE + "/JOB_SCHEDULED";
    public static final String JOB_UNSCHEDULED = BASE + "/JOB_UNSCHEDULED";
    public static final String TRIGGER_FINALIZED = BASE + "/TRIGGER_FINALIZED";
    public static final String TRIGGER_PAUSED = BASE + "/TRIGGER_PAUSED";
    public static final String TRIGGERS_PAUSED = BASE + "/TRIGGERS_PAUSED";
    public static final String TRIGGER_RESUMED = BASE + "/TRIGGER_RESUMED";
    public static final String TRIGGERS_RESUMED = BASE + "/TRIGGERS_RESUMED";
    public static final String JOB_ADDED = BASE + "/JOB_ADDED";
    public static final String JOB_DELETED = BASE + "/JOB_DELETED";
    public static final String JOB_PAUSED = BASE + "/JOB_PAUSED";
    public static final String JOBS_PAUSED = BASE + "/JOBS_PAUSED";
    public static final String JOB_RESUMED = BASE + "/JOB_RESUMED";
    public static final String JOBS_RESUMED = BASE + "/JOBS_RESUMED";
    public static final String SCHEDULER_ERROR = BASE + "/SCHEDULER_ERROR";
    public static final String SCHEDULER_IN_STANDBY_MODE = BASE + "/SCHEDULER_IN_STANDBY_MODE";
    public static final String SCHEDULER_STARTED = BASE + "/SCHEDULER_STARTED";
    public static final String SCHEDULER_STARTING = BASE + "/SCHEDULER_STARTING";
    public static final String SCHEDULER_SHUTDOWN = BASE + "/SCHEDULER_SHUTDOWN";
    public static final String SCHEDULER_SHUTTING_DOWN = BASE + "/SCHEDULER_SHUTTING_DOWN";
    public static final String SCHEDULING_DATA_CLEARED = BASE + "/SCHEDULING_DATA_CLEARED";


    public static final String JOB_WAS_EXECUTED = BASE + "/JOB_WAS_EXECUTED";
    public static final String JOB_TO_BE_EXECUTED = BASE + "/JOB_TO_BE_EXECUTED";
    public static final String JOB_EXECUTION_VETOED = BASE + "/JOB_EXECUTION_VETOED";

    public static final String TRIGGER_FIRED = BASE + "/TRIGGER_FIRED";
    public static final String TRIGGER_MIS_FIRED = BASE + "/TRIGGER_MIS_FIRED";
    public static final String TRIGGER_COMPLETE = BASE + "/TRIGGER_COMPLETE";

    public static final String SCHEDULER_REGISTERED = BASE + "/SCHEDULER_REGISTERED";
    public static final String SCHEDULER_UNREGISTERED = BASE + "/SCHEDULER_UNREGISTERED";


    public static void postEvent(String topic) {
        postEvent(null, topic, new HashMap<>());
    }

    public static void postEvent(Scheduler scheduler, String topic) {
        postEvent(scheduler, topic, new HashMap<>());
    }

    public static void postEvent(Scheduler scheduler, String topic, Map<String, Object> data) {
        Map<String, Object> newData = new HashMap<>();
        newData.put(SchedulerEventData.SCHEDULER, scheduler);
        EventAdminHelper.postEvent(topic, newData);
    }

}
