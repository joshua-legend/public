package data;

import javax.swing.*;

public class PoliticianVO {
    String name;
    ImageIcon image;
    String rgb;
    Party party;

    public PoliticianVO(String name, ImageIcon image, String rgb) {
        this.name = name;
        this.image = image;
        this.rgb = rgb;
    }

    public PoliticianVO(String name, ImageIcon image, String rgb, Party party) {
        this.name = name;
        this.image = image;
        this.rgb = rgb;
        this.party = party;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getImage() {
        return image;
    }

    public String getRgb() {
        return rgb;
    }

    public Party getParty() { return party;}
}

