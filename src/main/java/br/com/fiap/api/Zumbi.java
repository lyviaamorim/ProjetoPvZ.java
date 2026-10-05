package br.com.fiap.api;

public class Zumbi {

    private String name;
    private String toughness;
    private String speed;
    private String stamina;
    private String description;
    private String image;

    public Zumbi() {
    }

    public Zumbi(String name, String toughness, String speed, String stamina, String description, String image) {
        this.name = name;
        this.toughness = toughness;
        this.speed = speed;
        this.stamina = stamina;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToughness() {
        return toughness;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getStamina() {
        return stamina;
    }

    public void setStamina(String stamina) {
        this.stamina = stamina;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Zumbi " +
                "\nnome='" + name + '\'' +
                "\nresistência='" + toughness + '\'' +
                "\nvelocidade='" + speed + '\'' +
                "\nvigor='" + stamina + '\'' +
                "\ndescrição='" + description + '\'' +
                "\nimagem='" + image + '\'';
    }
}