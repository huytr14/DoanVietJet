package com.sinhvien.doan.Class;
public class News {
    private int ResourceId;
    private String name;

    public News(int resourceId, String name) {
        ResourceId = resourceId;
        this.name = name;
    }

    public int getResourceId() {
        return ResourceId;
    }

    public String getName() {
        return name;
    }

    public void setResourceId(int resourceId) {
        ResourceId = resourceId;
    }

    public void setName(String name) {
        this.name = name;
    }
}