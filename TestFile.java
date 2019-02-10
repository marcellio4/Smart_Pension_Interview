import org.junit.Before;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class TestFile {
	private FileLog File;

	@Before
	public void setUp() {
		File = new FileLog("C:/Users/marce/Desktop/SP Graduate Ruby test/ruby_app/webserver.log");
	}

	@Test
	public void test_fileLog_has_no_file() throws Exception {
		FileLog fs = new FileLog("");
	}
	
	@Test
	public void test_list_of_file_not_null() {
		assertFalse(File.getList().isEmpty());
	}
	
	@Test
	public void test_uniqueList_is_not_empty() {
		assertFalse(File.getUniqueList().isEmpty());
	}
	
	@Test
	public void test_pagesList_is_not_empty() {
		assertFalse(File.getPageList().isEmpty());
	}
	
	@Test
	public void test_total_pages_has_value() {
		int fl = File.TotalPages("/about 171 visits");
		assertEquals(fl, File.TotalPages("/about 171 visits"));
	}
	
	@Test
	public void test_unique_page_has_value() {
		int fl = File.UniquePage("/about/2 184.123.665.067 10 unique views");
		assertEquals(fl, File.UniquePage("/about/2 184.123.665.067 10 unique views"));
	}
	
	@Test
	public void test_unique_page_size() {
		List<String> unique = new ArrayList<>();
		for(String e:File.getUniqueList()) {
	    	unique.add(e + " " + File.UniquePage(e) + " unique views");
	    }
		assertEquals(unique.size(), 135);
		
	}

}
