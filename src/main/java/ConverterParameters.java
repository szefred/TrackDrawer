import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConverterParameters {

    private GeoPoint firstGeoPoint;
    private GeoPoint secondGeoPoint;
    private PixelPoint firstPixelPoint;
    private PixelPoint secondPixelPoint;

    public ConverterParameters(GeoPoint firstGeoPoint, GeoPoint secondGeoPoint, PixelPoint firstPixelPoint, PixelPoint secondPixelPoint) {
        this.firstGeoPoint = firstGeoPoint;
        this.secondGeoPoint = secondGeoPoint;
        this.firstPixelPoint = firstPixelPoint;
        this.secondPixelPoint = secondPixelPoint;
    }

    public GeoToPixelParameters prepareParameters() {
        BigDecimal latitudePerPixel = (secondGeoPoint.getLatitude().subtract(firstGeoPoint.getLatitude())).divide(new BigDecimal(firstPixelPoint.getY() - secondPixelPoint.getY()), 12, RoundingMode.HALF_UP);
        BigDecimal pointZeroLatitude = secondGeoPoint.getLatitude().add(latitudePerPixel.multiply(new BigDecimal(secondPixelPoint.getY())));
        BigDecimal longitudePerPixel = firstGeoPoint.getLongitude().subtract(secondGeoPoint.getLongitude()).divide(new BigDecimal(firstPixelPoint.getX() - secondPixelPoint.getX()), 12, RoundingMode.HALF_UP);
        BigDecimal pointZeroLongitude = secondGeoPoint.getLongitude().subtract(longitudePerPixel.multiply(new BigDecimal(secondPixelPoint.getX())));

        return new GeoToPixelParameters(latitudePerPixel, pointZeroLatitude, longitudePerPixel, pointZeroLongitude);
    }
}
