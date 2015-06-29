import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GeoFileWriter {
    public void write( BufferedImage img, String src) throws IOException {
        ImageIO.write(img, "jpg", new File(src));
    }
}
