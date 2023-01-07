package com.example.matdesign;

public class Contact {
    private String name;
    private String email;
    private String imageURL;

    public Contact(String name, String email, String imageURL) {
        this.name = name;
        this.email = email;
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
