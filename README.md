# WikipediaJaParse

# What
- The parse tool for wikipedia (japanese)
- You can get the text without wiki description.

# Usage
- Download jawiki-latest-pages-articles.xml.bz2 from https://dumps.wikimedia.org/jawiki/latest/
  - [Remark] The size of jawiki-latest-pages-articles.xml.bz2 is about 2GB!
- Edit src/WikipediaParse.java below:
```
public class WikipediaParse {
                // Example:
                // String bz2Filename = "c:\\temp\\<the dump file name>.xml.bz2";

-               String bz2Filename = "/Users/username/Downloads/jawiki-latest-pages-articles.xml.bz2";
+               String bz2Filename = "/your/path/to/jawiki-latest-pages-articles.xml.bz2";
```

- Compile
```
$ cd WikipediajaParse
$ ant
```

- Execute
```
$ cd WikipediajaParse
$ java -cp "./classes/:lib/*"  WikipediaParse <the number of title>
```

- Result
  - If you execute `java -cp "./classes/:lib/*"  WikipediaParse 1000`, you can get 1000 files in the `WikipediaJaParse/files`
  - Filename is from the each of wikipedia title.
