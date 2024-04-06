package ru.itis.inf304.lab5.transport.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Transport {
    private String id;
    private String threadId;
    private String lineId;
    private String name;
    @JsonProperty("Types")
    private List<String> types;
    private String type;
    private String uri;
    private String seoname;

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
