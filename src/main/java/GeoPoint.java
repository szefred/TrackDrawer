import java.math.BigDecimal;

/**
 * Created by karol on 10.05.15.
 */
public class GeoPoint {
    private BigDecimal latitude;
    private BigDecimal longitude;

    public GeoPoint(BigDecimal latitude, BigDecimal longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }
}
