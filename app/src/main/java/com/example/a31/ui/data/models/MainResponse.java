
package com.example.a31.ui.data.models;

import java.util.List;

import com.example.a31.ui.data.models.character.Info;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainResponse<T> {

    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("results")
    @Expose
    private List<T> results = null;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
