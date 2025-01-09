package com.herison.cep.core.domain;

public class Establishment {

    private String name;
    private String number;
    private String contact;
    private String site;

    public Establishment(){}

    public Establishment(String name, String number, String contact, String site) {
        this.name = name;
        this.number = number;
        this.contact = contact;
        this.site = site;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public String toString() {
        return "Establishment{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", contact='" + contact + '\'' +
                ", site='" + site + '\'' +
                '}';
    }
}
