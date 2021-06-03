package de.interaapps.punyshort.apiclient.models;

import com.google.gson.annotations.SerializedName;

public class Domain {

    @SerializedName("isDefault")
    private String isDefault;
    @SerializedName("isPublic")
    private String isPublic;
    private String name;

    public String getName() {
        return name;
    }

    public String isDefault() {
        return isDefault;
    }
    public String isPublic() {
        return isPublic;
    }
}
