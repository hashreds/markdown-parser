import static org.junit.Assert.*; // imports assertEquals
import org.junit.*; // imports JUnit library

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest { // class declaration
   
    @Test // telling Java to treat this method as a JUnit test
    public void addition() { // method header
    assertEquals(2, 1 + 1); // asserEquals() checks the second argument 
                          // against the first argument
    }

    @Test
    public void testTestFile1() throws java.io.IOException {
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expectedLinks = new ArrayList<String>();
        expectedLinks.add("https://something.com");
        expectedLinks.add("some-page.html");
        assertEquals(expectedLinks, links);
    }

    @Test
    public void testMyExample() throws java.io.IOException {
        Path fileName = Path.of("myExamples.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expectedLinks = new ArrayList<String>();
        expectedLinks.add("https://funsite.com");
        expectedLinks.add("e(ncyclopedia.ed");
        expectedLinks.add("abc def ghi");
        assertEquals(expectedLinks, links);
    }

    @Test
    public void testEmptyTestFile() throws java.io.IOException {
        Path fileName = Path.of("empty-test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expectedLinks = new ArrayList<String>();
        expectedLinks.add("no links found");
        assertEquals(expectedLinks, links);
    }

    //@Test
    public void testCodeSnippets() throws IOException {
        String contents = Files.readString(Path.of("test-code-snippets.md"));
        List<String> expect = List.of("`google.com", "google.com", "ucsd.edu");
        //System.out.println(contents);
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testWackyBrackets() throws IOException {
        String contents = Files.readString(Path.of("test-wacky-brackets.md"));
        List<String> expect = List.of("a.com", "a.com(())", "example.com");
        //System.out.println(contents);
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
    
    //@Test
    public void testLongTitles() throws IOException {
        String contents = Files.readString(Path.of("test-long-title.md"));
        List<String> expect = List.of("https://www.twitter.com", 
        "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule", 
        "https://cse.ucsd.edu/");
        //System.out.println(contents);
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
}