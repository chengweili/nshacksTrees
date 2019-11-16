import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.csvreader.CsvReader;


public class Location {

    String longitude, latitude;
    String lineOneAddress, listing;
    String zip;

    public Location()
    {
        zip = "0";
        longitude = "0";
        latitude = "0";
        lineOneAddress = "";
        listing = "";
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }

    public String getZip()
    {
        return zip;
    }

    public void setLineOneAddress(String lineOneAddress)
    {
        this.lineOneAddress = lineOneAddress;
    }

    public String getLineOneAddress()
    {
        return lineOneAddress;
    }

    /**
     * Extra listing information that Client wants to list
     * @param listing set listing
     */
    public void setListing(String listing)
    {
        this.listing = listing;
    }

    /**
     * Get listing information provided by client
     * @return listing information
     */
    public String getListing()
    {
        return listing;
    }

    public String getLongitude()
    {
        return longitude;
    }

    public String getLatitude()
    {
        return latitude;
    }

    public void zipToCord()
    {
        try {
            /**
             JavaCVS api is required in order to read this, it can
             be found at http://sourceforge.net/projects/javacsv/
             **/
            CsvReader products = new CsvReader("zips.csv");
            /** a cvs containing all the zip codes and latitudes
             and longitudes can be found at:
             http://sourceforge.net/projects/zips/files/zips/zips.csv.zip/
             **/
            products.readHeaders();
            int numOfHeaders = products.getHeaderCount();
            System.out.println("Number of headers" + numOfHeaders);
            try {
                while (products.readRecord())
                {

                    String lookedupZip = products.get(products.getHeader(0));
                    if (lookedupZip.equals(zip)) {
                        latitude = products.get(products.getHeader(2));
                        longitude = products.get(products.getHeader(3));
                    }

                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /**
     * Writes information in Location class to text file for saving
     * @throws IOException
     */
    public void writeListing() throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter("listings.txt", true));
        //FileWriter fileWriter = new FileWriter("/listings.txt");
        String fileContent = "*start*";
        writer.write(fileContent);
        writer.newLine();
        fileContent = latitude + " " + longitude;
        writer.write(fileContent);
        writer.newLine();
        fileContent = zip + "";
        writer.write(fileContent);
        writer.newLine();
        fileContent = lineOneAddress;
        writer.write(fileContent);
        writer.newLine();
        fileContent = listing;
        writer.write(fileContent);
        writer.newLine();
        fileContent = "*end*";
        writer.write(fileContent);
        writer.newLine();
        writer.newLine();
        writer.close();
    }


}
