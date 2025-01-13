package com.herison.cep.adapter.authentication;

public enum UserRole {

    USER("user");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
