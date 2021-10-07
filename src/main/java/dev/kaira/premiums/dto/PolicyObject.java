package dev.kaira.premiums.dto;

import java.util.Collections;
import java.util.List;

public class PolicyObject {
    private String name;
    private List<SubObject> subObjects = Collections.EMPTY_LIST;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubObject> getSubObjects() {
        return subObjects;
    }

    public void setSubObjects(List<SubObject> subObjects) {
        this.subObjects = subObjects;
    }
}
