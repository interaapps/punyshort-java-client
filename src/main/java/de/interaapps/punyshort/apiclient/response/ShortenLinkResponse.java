package de.interaapps.punyshort.apiclient.response;

import de.interaapps.punyshort.apiclient.PunyshortAPI;

public class ShortenLinkResponse {
    private int error;
    private String domain;
    private String fullLink;
    private String link;

    private transient PunyshortAPI punyshortAPI;

    public String getDomain() {
        return domain;
    }

    public String getLink() {
        return link;
    }

    public int getError() {
        return error;
    }

    public String getFullLink() {
        return fullLink;
    }

    public void setPunyshortAPI(PunyshortAPI punyshortAPI) {
        this.punyshortAPI = punyshortAPI;
    }

    public LinkInformation getLinkInformation(){
        return punyshortAPI.getLink(link, domain);
    }
}
