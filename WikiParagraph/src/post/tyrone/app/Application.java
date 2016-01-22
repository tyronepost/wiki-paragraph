package post.tyrone.app;

import static java.lang.System.out;

import java.util.Scanner;

import post.tyrone.wikiparagraph.WikiParagraph;
import post.tyrone.wikiparagraph.WikiParagraphException;

public class Application {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)){
			WikiParagraph wikiParagraph = new WikiParagraph();
			out.print("Enter a topic: ");
			String input = scanner.nextLine();
			String paragraph = wikiParagraph.getParagraph(input);
			out.println(paragraph);
		} catch (WikiParagraphException e) {
			out.print("NOT FOUND");
		}
	}
}
