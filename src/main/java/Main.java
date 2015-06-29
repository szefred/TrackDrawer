import pl.rozplanuj.gpx.WptType;

import javax.xml.bind.JAXBException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class Main {

//    public static String GPX_SRC = "/home/karol/projekty/Karda/TrackDrawer/src/main/resources/20150418_053002.gpx";
//    public static String MAP_IMAGE_SRC = "/home/karol/projekty/Karda/TrackDrawer/src/main/resources/h49_TP50.jpg";
//    public static String MAP_WITH_TRACK_IMAGE_SRC = "/home/karol/projekty/Karda/TrackDrawer/src/main/resources/h49_TP50track.jpg";

    public static String GPX_SRC = "/home/karol/projekty/Karda/TrackDrawer/src/main/resources/20150620_051211.gpx";
    public static String MAP_IMAGE_SRC = "/home/karol/projekty/Karda/TrackDrawer/src/main/resources/wzorcowkaTP50LT2015.jpg";
    public static String MAP_WITH_TRACK_IMAGE_SRC = "/home/karol/projekty/Karda/TrackDrawer/src/main/resources/TP50LT2015.jpg";
//    public static int X1 = 780;
//    public static int Y1 = 750;
//    public static int X2 = 100;
//    public static int Y2 = 100;
//    public static int X1 = 156;
//    public static int Y1 = 1252;
//    public static int X2 = 1442;
//    public static int Y2 = 1099;

    public static int X1 = 428;
    public static int Y1 = 612;
    public static int X2 = 1395;
    public static int Y2 = 3021;

//    public static BigDecimal LATITUDE1 = new BigDecimal(53.906536);
//    public static BigDecimal LONGITUDE1 = new BigDecimal(18.210781);
//    public static BigDecimal LATITUDE1 = new BigDecimal(53.90642);
//    public static BigDecimal LONGITUDE1 = new BigDecimal(18.21086);
//    public static BigDecimal LATITUDE2 = new BigDecimal(53.957220);
//    public static BigDecimal LONGITUDE2 = new BigDecimal(18.124394);

//    public static BigDecimal LATITUDE1 = new BigDecimal(54.430573);
//    public static BigDecimal LONGITUDE1 = new BigDecimal(18.468457);
//    public static BigDecimal LATITUDE2 = new BigDecimal(54.435874);
//    public static BigDecimal LONGITUDE2 = new BigDecimal(18.550645);


    public static BigDecimal LATITUDE1 = new BigDecimal(54.4545);
    public static BigDecimal LONGITUDE1 = new BigDecimal(18.4868);
    public static BigDecimal LATITUDE2 = new BigDecimal(54.3637);
    public static BigDecimal LONGITUDE2 = new BigDecimal(18.5449);

    public static void main(String[] args) throws IOException, JAXBException {
        System.out.println("Start.");

        GeoFileReader geoFileReader = new GeoFileReader();
        BufferedImage img = geoFileReader.read(MAP_IMAGE_SRC);

        GeoPoint firstGeoPoint = new GeoPoint(LATITUDE1, LONGITUDE1);
        GeoPoint secondGeoPoint = new GeoPoint(LATITUDE2, LONGITUDE2);

        PixelPoint firstPixelPoint = new PixelPoint(X1, Y1);
        PixelPoint secondPixelPoint = new PixelPoint(X2, Y2);

        ConverterParameters converterParameters = new ConverterParameters(firstGeoPoint, secondGeoPoint, firstPixelPoint, secondPixelPoint);
        GeoToPixelParameters geoToPixelParameters = converterParameters.prepareParameters();

        GpxSegmentGetter gpxSegmentGetter = new GpxSegmentGetter();
        List<WptType>  trkpts = gpxSegmentGetter.getSegments(GPX_SRC);

        GeoToPixelPointConverter geoToPixelPointConverter = new GeoToPixelPointConverter();
        List<PixelPoint> pixelPoints = geoToPixelPointConverter.convert(geoToPixelParameters, trkpts);

        TrackDrawer trackDrawer = new TrackDrawer(img, pixelPoints);
        BufferedImage newImg = trackDrawer.draw();

        GeoFileWriter geoFileWriter = new GeoFileWriter();
        geoFileWriter.write(newImg, MAP_WITH_TRACK_IMAGE_SRC);

        System.out.println("Finished.");
    }
}
