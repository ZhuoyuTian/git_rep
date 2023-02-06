import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedImage image = null;
        //read image
        try{
            File input_file = new File("/Users/tianzoe/Desktop/git_rep/imageProcessing/river-forest-scene.png");
            image = ImageIO.read(input_file);
            BufferedImage img_change = changeImage(image);
            ImageIO.write(img_change, "png", new File("Test2.png"));
        }catch (IOException e) {
            System.out.println("Error: " + e);
        }

        System.out.println("Hello world!");
    }

    private static BufferedImage changeImage(BufferedImage image){
        int width = image.getWidth();
        int height = image.getHeight();
        WritableRaster raster = image.getRaster();
        for (int xx = 0; xx < width; xx++) {
            for (int yy = 0; yy < height; yy++) {
                int[] pixels = raster.getPixel(xx, yy, (int[]) null);
                pixels[0] = pixels[0]+16;
                pixels[1] = pixels[1]+1;
                pixels[2] = pixels[2]+16;
                raster.setPixel(xx, yy, pixels);
            }
        }
        return image;
    }
}