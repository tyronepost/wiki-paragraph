package post.tyrone.wikiparagraph;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WikiParagraph {
	
	public String getParagraph(String topic) throws IOException {
		Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/" + topic).get();
		Element element = doc.getElementById("mw-content-text");
		Elements children = filterElements(element);
		Element child = children.first();
		return child.text();
	}

	private Elements filterElements(Element element) {
		Elements children = element.children().not("div").not("table");
		return children;
	}
}
