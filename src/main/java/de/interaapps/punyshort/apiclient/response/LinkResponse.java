package de.interaapps.punyshort.apiclient.response;

public class LinkResponse {
    private int clicks;
    private String domain;
    private String link;
    private String name;
    private String shorten;

    public String getName() {
        return name;
    }

    public int getClicks() {
        return clicks;
    }

    public String getDomain() {
        return domain;
    }

    public String getLink() {
        return link;
    }

    public String getShorten() {
        return shorten;
    }
}
