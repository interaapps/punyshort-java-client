package de.interaapps.punyshort.apiclient.requests;

public class ShortenLinkRequest {
    public ShortenLinkRequest(String link, String name) {
        this.link = link;
        this.name = name;
    }

    public String link;
    public String name;

}
