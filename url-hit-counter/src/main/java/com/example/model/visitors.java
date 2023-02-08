package com.example.model;

public class visitors {
    private String username;
    private Integer count;

    visitors(){}
    public visitors(Integer count)
    {
        this.count=count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    public visitors(String username, Integer count) {
        this.username = username;
        this.count = count;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }




    @Override
    public String toString() {
        return "Visitor{" +
                "username='" + username + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
