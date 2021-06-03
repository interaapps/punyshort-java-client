package de.interaapps.punyshort.apiclient;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import de.interaapps.punyshort.apiclient.models.Domain;
import de.interaapps.punyshort.apiclient.requests.ShortenLinkRequest;
import de.interaapps.punyshort.apiclient.response.LinkInformation;
import de.interaapps.punyshort.apiclient.response.LinkResponse;
import de.interaapps.punyshort.apiclient.response.ShortenLinkResponse;
import org.javawebstack.httpclient.HTTPClient;

import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

public class PunyshortAPI extends HTTPClient {

    private Gson gson = new Gson();

    private String defaultDomain = "pnsh.ga";

    public PunyshortAPI(String key, String server){
        setBaseUrl(server);
        cookie(new HttpCookie("auth", key));
    }

    public PunyshortAPI(String apiKey){
        this(apiKey, "https://punyshort.ga");
    }

    public PunyshortAPI(){
        this(null, "https://punyshort.ga");
    }

    public void setDefaultDomain(String defaultDomain) {
        this.defaultDomain = defaultDomain;
    }

    public Map<String, Domain> getDomains(){
        return gson.fromJson(get("/user/domains").string(), new TypeToken<Map<String, Domain>>(){}.getType());
    }

    public List<LinkResponse> getLinks(){
        return gson.fromJson(get("/user/links").string(), new TypeToken<List<LinkResponse>>(){}.getType());
    }

    public ShortenLinkResponse shorten(String link, String name, String domain){
        ShortenLinkResponse response = post("/api/v2/short", new ShortenLinkRequest(link, name)).query("domain", domain == null ? defaultDomain : domain).object(ShortenLinkResponse.class);
        response.setPunyshortAPI(this);
        return response;
    }

    public ShortenLinkResponse shorten(String link, String name){
        return shorten(link, name, null);
    }

    public ShortenLinkResponse shorten(String link){
        return shorten(link, null, null);
    }

    public boolean editLink(String id, String url){
        return post("/api/client/edit/"+id).jsonBody(new ShortenLinkRequest(url, null)).object(Boolean.class);
    }

    public boolean deleteLink(String id){
        return delete("/api/client/delete/"+id).object(Boolean.class);
    }


    public LinkInformation getLink(String name, String domain){
        try {
            LinkInformation information = get("/api/v2/getinformation/" + URLEncoder.encode(name, "utf-8")).query("domain", domain == null ? defaultDomain : domain).object(LinkInformation.class);
            information.setPunyshortAPI(this);
            return information;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkInformation getLink(String name){
        return getLink(name, null);
    }

    public static String login(String iaAuthCode){
        return new PunyshortAPI().get("/ia/auth/user/login").query("userkey", iaAuthCode).execute().cookie("auth").getValue();
    }
}
