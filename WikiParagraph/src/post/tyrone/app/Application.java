package post.tyrone.app;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import post.tyrone.wikiparagraph.WikiParagraph;
import post.tyrone.wikiparagraph.WikiParagraphException;

public class Application {

	public static void main(String[] args) {
		if (args.length > 0) {
			runWith(args);
		} else {
			promptUser();
		}
	}

	private static void promptUser() {
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				out.print("Enter a topic: ");
				String inputString = scanner.nextLine();
				if (!inputString.isEmpty()) {
					String[] scannedInput = inputString.split(" ");
					runWith(scannedInput);
					return;
				}
			}
		}
	}

	private static void runWith(String[] strArr) {
		List<String> strList = Arrays.asList(strArr);
		String input = concatTopic(strList);
		printParagraph(input);
	}

	private static String concatTopic(List<String> argList) {
		Iterator<String> iterator = argList.iterator();
		String input = iterator.next();
		while (iterator.hasNext()) {
			input += "_" + iterator.next();
		}
		return input;
	}

	private static void printParagraph(String input) {
		try {
			WikiParagraph wikiParagraph = new WikiParagraph();
			String paragraph = wikiParagraph.getParagraph(input);
			out.println(paragraph);
		} catch (WikiParagraphException e) {
			out.print("NOT FOUND");
		}
	}
}
