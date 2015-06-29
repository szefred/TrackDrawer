import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GeoFileReader {

    public BufferedImage read(String src) throws IOException {
        File imageFile = new File(src);
        BufferedImage img = ImageIO.read(imageFile);

        return img;
    }
}
