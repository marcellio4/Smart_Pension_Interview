import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * Reading .log file and display most, less visits pages along site with 
 * unique visits per file.
 * 
 * @author Marcel Zacharias
 * 
 */

public class FileLog {
	
	/**
	 * @param FileName store the path of our file
	 * @param List that stored the data from our file
	 * @param page that stores our unique pages
	 * @param finalList contains only unique pages with IP addresses 
	 */
	private String FileName;
	private List<String> List = new ArrayList<>();	
	private List<String> page = new ArrayList<>();	
	private List<String> finalList = new ArrayList<>();
	
	/**
	 * Constructor read the file, storing unique pages and the whole document 
	 * @param FileName holds path of the file
	 */
	public FileLog(String FileName) {
		this.FileName = FileName;
		try{
			   FileInputStream fstream = new FileInputStream(this.FileName);
			   BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			   String strLine;
			   /* read log line by line */
			   while ((strLine = br.readLine()) != null)   {
				    List.add(strLine);
			   }
			   fstream.close();
			} catch (Exception e) {
			     System.err.println("Error: " + e.getMessage());
			}
		//adding only pages that exist once and not multiple times
	    for (String word : List){
	        String[] words = word.split("\\s+");
	        for (String element : words){
	        	Pattern p = Pattern.compile("[a-z]");
	        	Matcher m = p.matcher(element);
	        	if (m.find())
	        		if(!page.contains(element)) {
	        			page.add(element);
	        		}
	        }
	    }
	}
	
	
	/**
	 * @return List of our data that are copied from the original file
	 */
	public List<String> getList() {
		return List;
	}
	
	/**
	 * @return finalList holds only unique pages with unique IP addresses 
	 */
	public List<String> getUniqueList(){
		 //get rid of duplicates 
	    for(String e:List) {
	    	if(!finalList.contains(e)) {
    			finalList.add(e);
    		}
    	}
	    return finalList;
	}
	
	/**
	 * @return page holds only unique pages
	 */
	public List<String> getPageList(){
		return page;
	}
	
	/**Count sum of particular page that appear in our log file
	 * @param name that much the count of particular page
	 * @return sum of the particular page is in our List
	 */
	public int TotalPages(String name) {
		int sum = 0;
		for(String element : List) {
				if(element.contains(name))
					sum++;
			}
		return sum;
	}
	
	/**
	 * Count total pages of unique page that appears in our data log file
	 * @param name of the data 
	 * @return total amount of pages in log file
	 */
	public int UniquePage(String name) {
		int total = 0;
		for(String element : List) {
			if(element.equals(name))
				total++;
		}
		return total;
	}

}
