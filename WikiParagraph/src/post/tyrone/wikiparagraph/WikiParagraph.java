package post.tyrone.wikiparagraph;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

public class WikiParagraph {
	
	private final String CONTAINING_ELEMENT = "mw-content-text"; 
	public String getParagraph(String topic) throws WikiParagraphException {
		Document doc = getDocument(topic);
		Element element = doc.getElementById(CONTAINING_ELEMENT);
		Element firstParagraph = getFirstParagraph(element.children());
		return firstParagraph.text();
	}

	private Document getDocument(String topic) throws WikiParagraphException {
		try {
			Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/" + topic).get();
			return doc;
		} catch (IOException e) {
			throw new WikiParagraphException("Failed to retrieve document topic", e);
		}
	}

	private Element getFirstParagraph(Elements elements) throws WikiParagraphException {
		for (Element ele : elements) {
			if (ele.tag().equals(Tag.valueOf("p"))) {
				return ele;
			}
		}
		throw new WikiParagraphException("No paragraph tags within the " + CONTAINING_ELEMENT + "element");
	}
}
