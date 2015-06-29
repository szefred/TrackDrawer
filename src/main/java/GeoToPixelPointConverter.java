import pl.rozplanuj.gpx.WptType;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class GeoToPixelPointConverter {

    public List<PixelPoint> convert(GeoToPixelParameters geoToPixelParameters, List<WptType> trkpts) {
        List<PixelPoint> pixelPoints= new ArrayList<>();

        for(WptType trkpt:trkpts) {
            pixelPoints.add(convert(geoToPixelParameters, trkpt));
        }

        return pixelPoints;
    }

    private PixelPoint convert(GeoToPixelParameters geoToPixelParameters, WptType trkpt){
        int x = trkpt.getLon().subtract(geoToPixelParameters.getPointZeroLongitude()).divide(geoToPixelParameters.getLongitudePerPixel(), 2, RoundingMode.HALF_EVEN).intValue();
        int y = geoToPixelParameters.getPointZeroLatitude().subtract(trkpt.getLat()).divide(geoToPixelParameters.getLatitudePerPixel(), 2, RoundingMode.HALF_EVEN).intValue();

        return new PixelPoint(x, y);
    }
}
