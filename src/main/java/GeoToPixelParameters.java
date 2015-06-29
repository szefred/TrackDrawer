import java.math.BigDecimal;

public class GeoToPixelParameters {
    private BigDecimal latitudePerPixel;
    private BigDecimal pointZeroLatitude;
    private BigDecimal longitudePerPixel;
    private BigDecimal pointZeroLongitude;

    public GeoToPixelParameters(BigDecimal latitudePerPixel, BigDecimal pointZeroLatitude, BigDecimal longitudePerPixel, BigDecimal pointZeroLongitude) {
        this.latitudePerPixel = latitudePerPixel;
        this.pointZeroLatitude = pointZeroLatitude;
        this.longitudePerPixel = longitudePerPixel;
        this.pointZeroLongitude = pointZeroLongitude;
    }

    public BigDecimal getLatitudePerPixel() {
        return latitudePerPixel;
    }

    public BigDecimal getPointZeroLatitude() {
        return pointZeroLatitude;
    }

    public BigDecimal getLongitudePerPixel() {
        return longitudePerPixel;
    }

    public BigDecimal getPointZeroLongitude() {
        return pointZeroLongitude;
    }
}
