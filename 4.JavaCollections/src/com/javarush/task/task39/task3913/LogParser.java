package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;

import java.nio.file.Path;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class LogParser implements IPQuery {

    private Path path;

    public LogParser(Path logDir) {
        this.path = logDir;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        if (after == null) return getUniqueIPs(null, before).size();
        else if (before == null) return getUniqueIPs(after, null).size();
        else return getUniqueIPs(null, null).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> set = new HashSet<>();

        return set;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return null;
    }
}