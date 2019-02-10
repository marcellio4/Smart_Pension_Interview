import java.util.*;

public class TestFileLog {

	public static void main(String[] args) {
		
		FileLog File = new FileLog("C:/Users/marce/Desktop/SP Graduate Ruby test/ruby_app/webserver.log");
		List<String> list = new ArrayList<>();
	    List<String> fileList = File.getPageList();
	    List<String> unique = new ArrayList<>();
	    List<String> uniqueList = File.getUniqueList(); 

	    System.out.println("The number of times a page has been viewed : ");
	     
// sort the fileList using File::TotalPages as key extractor for the comperator
	    fileList.sort(Comparator.comparing(File::TotalPages).reversed());
	    for(String e:File.getPageList() ) {
			list.add(e + " " + File.TotalPages(e) + " visits");		
	    }
	    
	    for(String e:list)
	    	System.out.println(e);
	    
	    System.out.println();
	    System.out.println("The number of times a page has been viewed, for a specific IP address : ");
	    
	    uniqueList.sort(Comparator.comparing(File::UniquePage).reversed());
	    for(String e:File.getUniqueList()) {
	    	unique.add(e + " " + File.UniquePage(e) + " unique views");
	    }
	    
	    for(String e:unique)
	    	System.out.println(e);
	    
	    System.out.println();
	    System.out.println("Total unique views : " + unique.size());
	    
	}
}
