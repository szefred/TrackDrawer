import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.List;

public class TrackDrawer {

    private BufferedImage img;
    private List<PixelPoint> pixelPoints;


    public TrackDrawer(BufferedImage img, List<PixelPoint> pixelPoints){
        this.img = img;
        this.pixelPoints = pixelPoints;
    }

    public BufferedImage draw() {
        Graphics2D graph = img.createGraphics();
        graph.setColor(Color.RED);
        graph.setStroke(new BasicStroke(3));

        PixelPoint startPoint = null;


        for(PixelPoint pixelPoint:this.pixelPoints){
            if(startPoint != null) {
                graph.draw(new Line2D.Double(
                                startPoint.getX(), startPoint.getY(),
                                pixelPoint.getX(), pixelPoint.getY()
                        )
                );
            }
            startPoint = pixelPoint;
        }
        graph.dispose();

        return img;
    }
}
