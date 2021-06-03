## Punyshort Java APIClient

```java
import de.interaapps.punyshort.apiclient.PunyshortAPI;
import de.interaapps.punyshort.apiclient.response.LinkInformation;
import de.interaapps.punyshort.apiclient.response.ShortenLinkResponse;

class Test {
    public static void main(String[] args) {
        PunyshortAPI punyshortAPI = new PunyshortAPI();
        // Simplified auth: new PunyshortAPI("auth cookie on punyshort.ga")

        ShortenLinkResponse shortenedLink = punyshortAPI.shorten("https://developers.interaapps.de");
        System.out.println("Shortened Link: " + shortenedLink.getFullLink());

        LinkInformation information = shortenedLink.getLinkInformation();

        System.out.println("Get clicks: " + information.getClicks());

        // Login required:
        information.editURL("https://interaapps.de");
        
        information.delete();

        // Get all shortened links on account
        punyshortAPI.getLinks().forEach(link -> {
            System.out.println(link.getLink());
        });
        
        // Get all domains you can access
        punyshortAPI.getDomains().forEach((name, domain) -> {
            System.out.println(name);
        });
        
        // Shorten url with custom domain
        System.out.println(punyshortAPI.shorten("https://developers.interaapps.de", "coollink", "https://go.interaapps.de"));
        // link: https://go.interaapps.de/coollink -> https://developers.interaapps.de
    }
}
```

## Installation
```xml
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

	<dependency>
	    <groupId>com.github.interaapps</groupId>
	    <artifactId>punyshort-java-client</artifactId>
	    <version>1.1 <!-- TAG --></version>
	</dependency>
```
