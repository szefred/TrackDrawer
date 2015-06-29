import pl.rozplanuj.gpx.GpxType;
import pl.rozplanuj.gpx.TrkType;
import pl.rozplanuj.gpx.TrksegType;
import pl.rozplanuj.gpx.WptType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by karol on 10.05.15.
 */
public class GpxSegmentGetter {

    public List<WptType> getSegments(String src) throws JAXBException {
        JAXBContext jc = null;
        jc = JAXBContext.newInstance("pl.rozplanuj.gpx");
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        GpxType root = (GpxType)((javax.xml.bind.JAXBElement) unmarshaller.unmarshal(new File(src))).getValue();
        List<TrkType> tracks = root.getTrk();
        List<TrksegType> segments = null;
        for(TrkType trk:tracks){
            segments = trk.getTrkseg();
        }

        List<WptType> allTkpts = new ArrayList<>();

        List<WptType> trkpts = null;
        for(TrksegType trkseg:segments) {
            trkpts = trkseg.getTrkpt();
            allTkpts.addAll(trkpts);
        }

        return allTkpts;
    }
}
