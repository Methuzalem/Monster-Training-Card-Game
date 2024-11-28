package main.Application.MTCG.entity;


import java.util.UUID;

public class User {

    private String id;
    private String username;
    private String password;
    private int coins;
    private int elo = 0;
    private int wins = 0;
    private int losses = 0;
    private String token;


    public User(String username, String password) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.coins = 20;
    }

    public String getId() {

        return id;
    }

    public String getUsername() {

        return username;
    }

    public String getPassword() {

        return password;
    }

    public int getCoins() {

        return coins;
    }

    public void setCoins(int coins) {

        this.coins = coins;
    }

    public String getToken() {

        return token;
    }

    public void setToken(String token) {

        this.token = token;
    }
}