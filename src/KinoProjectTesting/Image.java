package KinoProjectTesting;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {

    public void addImage(){

        BufferedImage img = null;
        try {
            File image = new File("C:\\Users\\melwi\\IdeaProjects\\DHBW\\src\\KinoProjectTesting\\Images\\F1 2020 (DirectX 12) 18.03.2021 14_38_29.png");
            System.out.println(image.getName());
            img = ImageIO.read(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File outfile = new File("C:\\Users\\melwi\\IdeaProjects\\DHBW\\src\\KinoProjectTesting\\Images\\saved.png");
        try {
            ImageIO.write(img,"png",outfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Image image = new Image();
        image.addImage();
    }
}
