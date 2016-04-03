package articlefilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import info.bliki.wiki.dump.IArticleFilter;
import info.bliki.wiki.dump.Siteinfo;
import info.bliki.wiki.dump.WikiArticle;
import info.bliki.wiki.filter.PlainTextConverter;
import info.bliki.wiki.model.WikiModel;

public class ArticleFilter implements IArticleFilter {
	
	WikiModel wikiModel = new WikiModel("${image}", "${title}");
	
	int cnt = 1;
	
	final int limit = 100000;
	
	// output
	final String DIR = "/Users/username/dev/eclipse4.4/eclipse/workspace/WikipediaParse/files/";
	
	public void process(WikiArticle page, Siteinfo siteinfo) {
		PrintWriter pw = null;
		String fileName = DIR+arrangeFileName(page.getTitle())+".txt";
		try{
			if(cnt == limit){
				System.exit(-1);
			}
			FileOutputStream fos = new FileOutputStream(fileName);
			pw = new PrintWriter(fos);
			if (page != null && page.getText() != null && !page.getText().startsWith("#REDIRECT ")){
				String afterString = getWord(page.getText());
				if(afterString != null){
					pw.print(afterString);
					cnt++;
				} 
			}
			else {
				new File(fileName).delete();
				cnt--;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if(pw != null){
				pw.close();
			}
		}
	}
	
	private String getWord(String text) {
		return wikiModel.render(new PlainTextConverter(), text.replaceAll("[=]+[A-Za-z+\\s-]+[=]+", "").
		replaceAll("\\{\\{[A-Za-z0-9+\\s-]+\\}\\}","").
		replaceAll("(?m)<ref>.+</ref>","").
		replaceAll("(?m)<ref name=\"[A-Za-z0-9\\s-]+\">.+</ref>","").
		replaceAll("<ref>"," <ref>").
		replaceAll("DEFAULTSORT", "").replaceAll("\\{\\{.+\\}\\}", ""));
	}
	
	private String arrangeFileName(String fileName) {
		return fileName.replaceAll("/", " ");
	}
}
