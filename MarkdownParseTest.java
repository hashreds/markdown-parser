import static org.junit.Assert.*; // imports assertEquals
import org.junit.*; // imports JUnit library
public class MarkdownParseTest { // class declaration
    @Test // telling Java to treat this method as a JUnit test
    public void addition() { // method header
    assertEquals(2, 1 + 1); // asserEquals() checks the second argument 
                          // against the first argument
    }
}