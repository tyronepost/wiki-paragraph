package post.tyrone.wikiparagraph;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class WikiParagraphTest {

	@Test
	public void testTopic_Dog() throws IOException {

		String expected = "The domestic dog (Canis lupus familiaris or Canis familiaris) "
				+ "is a domesticated canid which has been selectively bred for millennia for "
				+ "various behaviors, sensory capabilities, and physical attributes.[2]";
		WikiParagraph wikiParagraph = new WikiParagraph();
		String actual = wikiParagraph.getParagraph("dog");
		assertEquals(expected, actual);
	}
}
