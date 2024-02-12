package com.example.cardsinterface;

public class Contact {
    private String name,image;
    private boolean recent;

    public Contact(String name, String image, boolean recent) {
        this.name = name;
        this.image = image;
        this.recent = recent;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public boolean isRecent() {
        return recent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setRecent(boolean recent) {
        this.recent = recent;
    }
}
