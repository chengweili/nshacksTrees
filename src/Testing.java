import java.io.IOException;

public class Testing {

    public static void main(String [] args) throws IOException
    {
        Location locationTest = new Location();
        locationTest.setZip("10005");
        locationTest.setLineOneAddress("234 OnePlace");
        locationTest.setListing("Please plant trees!");
        //locationTest.writeListing();
        locationTest.zipToCord();
        System.out.println(locationTest.getLatitude() + " " + locationTest.getLongitude());
    }

}
