package post.tyrone.wikiparagraph;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WikiParagraphTest {

	WikiParagraph wikiParagraph;
	
	@Before
	public void setUp() {
		wikiParagraph = new WikiParagraph();	
	}
	
	@Test
	public void testTopic_Dog() throws Exception {
		String expected = "The domestic dog (Canis lupus familiaris or Canis familiaris) "
				+ "is a domesticated canid which has been selectively bred for millennia for "
				+ "various behaviors, sensory capabilities, and physical attributes.[2]";
		
		String actual = wikiParagraph.getParagraph("dog");	
		assertEquals(expected, actual);
	}
	
	@Test
	public void testTopic_Cat() throws Exception {
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
		
		String actual = wikiParagraph.getParagraph("cat");	
		assertEquals(expected, actual);
	}
	
	@Test
	public void testTopic_BlackHole() throws Exception {
		String expected = "A black hole is a geometrically defined region of spacetime exhibiting "
				+ "such strong gravitational effects that nothing—including particles and "
				+ "electromagnetic radiation such as light—can escape from inside it.[1] The theory "
				+ "of general relativity predicts that a sufficiently compact mass can deform spacetime "
				+ "to form a black hole.[2][3] The boundary of the region from which no escape is possible "
				+ "is called the event horizon. Although crossing the event horizon has enormous effect on "
				+ "the fate of the object crossing it, it appears to have no locally detectable features. "
				+ "In many ways a black hole acts like an ideal black body, as it reflects no light.[4][5] "
				+ "Moreover, quantum field theory in curved spacetime predicts that event horizons emit "
				+ "Hawking radiation, with the same spectrum as a black body of a temperature inversely "
				+ "proportional to its mass. This temperature is on the order of billionths of a kelvin "
				+ "for black holes of stellar mass, making it essentially impossible to observe.";
		
		String actual = wikiParagraph.getParagraph("Black_hole");	
		assertEquals(expected, actual);
	}
	
	@Test(expected = WikiParagraphException.class)
	public void testWikiParagraphException() throws Exception {
		wikiParagraph.getParagraph("Blalksd");
	}
}
