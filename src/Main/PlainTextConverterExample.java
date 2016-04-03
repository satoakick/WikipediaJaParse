package Main;

import info.bliki.wiki.filter.PlainTextConverter;
import info.bliki.wiki.model.WikiModel;

public class PlainTextConverterExample {

	public static void main(String[] args) {
		
		
	        String plainStr = "{{Infobox Language}}";
	        System.out.print(getWord(plainStr));
	}
	private static String getWord(String text) {
		return text.
		replaceAll("\\{\\{[A-Za-z0-9+\\s-]+\\}\\}","").
		replaceAll("(?m)<ref>.+</ref>","").
		replaceAll("(?m)<ref name=\"[A-Za-z0-9\\s-]+\">.+</ref>","").
		replaceAll("<ref>"," <ref>").
		replaceAll("DEFAULTSORT", "").replaceAll("\\{\\{.+\\}\\}", "");
	}
}
