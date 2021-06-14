package com.github.expram;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class CrafatarFile extends Utils {

    private String url;
    private BufferedImage image;

    public CrafatarFile(String url, BufferedImage image) {
        this.setUrl(url);
        this.setImage(image);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void download(String pathname, String filename) {
        try {
            ImageIO.write(getImage(), "png", new File(pathname + filename + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
