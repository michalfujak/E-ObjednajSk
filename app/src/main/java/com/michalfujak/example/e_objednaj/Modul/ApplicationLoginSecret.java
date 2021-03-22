package com.michalfujak.example.e_objednaj.Modul;

public class ApplicationLoginSecret
{
    // variable
    public int id;
    public int uuid;
    public String email;
    public String urlNonce;
    public String urlPrivateKey;
    public String token;

    // Set and Get, response

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrlNonce() {
        return urlNonce;
    }

    public void setUrlNonce(String urlNonce) {
        this.urlNonce = urlNonce;
    }

    public String getUrlPrivateKey() {
        return urlPrivateKey;
    }

    public void setUrlPrivateKey(String urlPrivateKey) {
        this.urlPrivateKey = urlPrivateKey;
    }
}
