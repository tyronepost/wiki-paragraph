package post.tyrone.wikiparagraph;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

public class WikiParagraph {
	
	private final String CONTAINING_ELEMENT = "mw-content-text"; 
	
	/**
	 * This method retrieves the html document associated with the topic passed in, then access's
	 * the introductory paragraph from the 'mw-content-text' div tag, and returns it as a plain
	 * text string.
	 * @param topic - String used to complete url and query wikipedia for web page
	 * @return
	 * @throws WikiParagraphException
	 */
	public String getParagraph(String topic) throws WikiParagraphException {
		Document doc = getDocument(topic);
		Element element = doc.getElementById(CONTAINING_ELEMENT);
		Element firstParagraph = getFirstParagraph(element.children());
		return firstParagraph.text();
	}

	/**
	 * This private method concatenates the input parameter to the hardcoded url makes an http get
	 * using the jsoup api.
	 * @param topic - String used to complete url and query wikipedia for web page
	 * @return org.jsoup.nodes.Document - represents the html document returned by the get() call.
	 * @throws WikiParagraphException
	 */
	private Document getDocument(String topic) throws WikiParagraphException {
		try {
			return Jsoup.connect("https://en.wikipedia.org/wiki/" + topic).get();
		} catch (IOException e) {
			throw new WikiParagraphException("Failed to retrieve document topic", e);
		}
	}

	/**
	 * This method grabs the first paragraph element in the collection, ignoring all other html elements.
	 * @param elements - org.jsoup.select.Elements - a collection of html elements
	 * @return
	 * @throws WikiParagraphException
	 */
	private Element getFirstParagraph(Elements elements) throws WikiParagraphException {
		for (Element ele : elements) {
			if (ele.tag().equals(Tag.valueOf("p"))) {
				return ele;
			}
		}
		throw new WikiParagraphException("No paragraph tags within the " + CONTAINING_ELEMENT + " element");
	}
}
