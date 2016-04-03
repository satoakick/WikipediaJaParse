package Main;

import articlefilter.ArticleFilter;
import info.bliki.wiki.dump.IArticleFilter;
import info.bliki.wiki.dump.WikiXMLParser;

public class Main {

	public static void main(String[] args) {
		// Example:
		// String bz2Filename = "c:\\temp\\<the dump file name>.xml.bz2";
		
		String bz2Filename = "/Users/username/Downloads/jawiki-latest-pages-articles.xml.bz2";
		try {
			IArticleFilter handler = new ArticleFilter();
			WikiXMLParser wxp = new WikiXMLParser(bz2Filename, handler);
			wxp.parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
