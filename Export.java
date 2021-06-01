import edu.duke.*;
import org.apache.commons.csv.*;
/**
 * Write a description of Export here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Export {
    public String countryInfo(CSVParser parser, String country){
        String countries = null;
        for (CSVRecord record: parser){
            String info = record.get("Country");
            if(info.contains(country)){
            countries = String.format("%s: %s: %s",country , record.get("Exports"), record.get("Value (dollars)"));
            }//else {
            //countries = "NOT FOUND";
            //}
        }
        return countries;
    }
    
    public void  listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        FileResource fr = new FileResource();
        parser = fr.getCSVParser();
        exportItem1 = "cotton";
        exportItem2 = "flowers";
                for (CSVRecord record: parser){
            String export = record.get("Exports");
            if(export.contains(exportItem1) && export.contains(exportItem2)){
               String country = record.get("Country");
               System.out.println(country); 
            }
        }
        
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int count = 0;
        for (CSVRecord record: parser){
            String export = record.get("Exports");
            if(export.contains(exportItem)){
            count++;
            }
        
        }
        return count;
    }
    
    public void bigExporters(CSVParser parser, String amount){
        int numOfValue = amount.length();
        for(CSVRecord record: parser){
        int length = record.get("Value (dollars)").length();
        if (length > numOfValue){
            System.out.println(String.format("%s %s", record.get("Country"), record.get("Value (dollars)")));
        }
        } 
    }
    
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "cotton ", "flowers");
        parser = fr.getCSVParser();
	System.out.println(countryInfo(parser , "Nauru"));
	parser = fr.getCSVParser();
	System.out.println(numberOfExporters(parser, "cocoa"));
	parser = fr.getCSVParser();
	bigExporters(parser, "$999,999,999,999");
    }
}
