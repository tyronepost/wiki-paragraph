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
	
	@Test
	public void testTopic_Cat() throws IOException {
		String expected = "The domestic cat[1][2] (Felis catus or Felis silvestris catus)[2]"
				+ "[4] is a small, typically furry, domesticated, and carnivorous mammal. They "
				+ "are often called house cats when kept as indoor pets or simply cats when "
				+ "there is no need to distinguish them from other felids and felines.[6] "
				+ "Cats are often valued by humans for companionship and for their ability to "
				+ "hunt vermin. There are more than 70 cat breeds; different associations "
				+ "proclaim different numbers according to their standards. The International "
				+ "Progressive Cat Breeders Alliance (IPCBA) recognizes 73 cat breeds while "
				+ "TICA (The International Cat Association) recognizes 58, CFA (The Cat Fanciers' "
				+ "Association) recognizes 44 and Federation International Feline (FIFE) "
				+ "recognizes 43.[7]";
		
		WikiParagraph wikiParagraph = new WikiParagraph();
		String actual = wikiParagraph.getParagraph("cat");	
		assertEquals(expected, actual);
	}
}
