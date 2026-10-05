package br.com.fiap.api;

import com.google.gson.annotations.SerializedName;

public class Planta {

    private String name;

    @SerializedName("Sun cost")
    private String sunCost;

    @SerializedName("Recharge")
    private String recharge;

    @SerializedName("Toughness")
    private String toughness;

    @SerializedName("Family")
    private String family;

    private String image;

    public Planta() {
    }

    public Planta(String name, String recharge, String sunCost, String toughness, String family, String image) {
        this.name = name;
        this.recharge = recharge;
        this.sunCost = sunCost;
        this.toughness = toughness;
        this.family = family;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSunCost() {
        return sunCost;
    }

    public void setSunCost(String sunCost) {
        this.sunCost = sunCost;
    }

    public String getRecharge() {
        return recharge;
    }

    public void setRecharge(String recharge) {
        this.recharge = recharge;
    }

    public String getToughness() {
        return toughness;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Planta " +
                "\nnome='" + name + '\'' +
                "\ncusto de sol='" + sunCost + '\'' +
                "\nrecarga='" + recharge + '\'' +
                "\nresistência='" + toughness + '\'' +
                "\nfamília='" + family + '\'' +
                "\nimagem='" + image + '\'';
    }
}

