import java.util.ArrayList;
import latlng.LatLng;

public class SearchMenu {

    ArrayList<Location> locations;
    ArrayList<Double> distances;
    String currentZip;

    public SearchMenu()
    {
        locations = new ArrayList<Location>();
        distances = new ArrayList<Double>();
        currentZip = "0";
    }


    /**
     * Distance in KM
     */
    public void getDistances()
    {
        Location currentLocation = new Location();
        currentLocation.setZip(currentZip);
        currentLocation.zipToCord();
        for (int i = 0; i < locations.size(); i++)
        {
            double distance = LatLng.calculateDistance(locations.get(i).getCoordinates(), currentLocation.getCoordinates());
            distances.add(i, distance);
        }
    }

    /**
     * Distance in KM
     * @param distance desired distance radius
     */
    public void printLocations(int distance)
    {
        for (int i = 0; i < distances.size(); i++)
        {
            if (distances.get(i) < distance)
            {
                System.out.println(locations.get(i).toString());
            }
        }
    }





}
