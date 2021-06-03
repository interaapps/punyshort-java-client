package de.interaapps.punyshort.apiclient.response;

import java.sql.Timestamp;
import java.util.Map;

public class LinkInformation {
    private String id;
    private int clicks;
    private boolean isMine;
    private String domain;
    private String url;
    private Map<String, Integer> countries;
    private Map<String, Integer> browser;
    private Map<String, Integer> os;
    private Map<String, Integer> click;
    private Timestamp created;

    public String getDomain() {
        return domain;
    }

    public int getClickCount() {
        return clicks;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, Integer> getBrowsers() {
        return browser;
    }

    public Map<String, Integer> getClicks() {
        return click;
    }

    public Map<String, Integer> getCountries() {
        return countries;
    }

    public Map<String, Integer> getOperatingSystems() {
        return os;
    }

    public Timestamp getCreated() {
        return created;
    }
}
