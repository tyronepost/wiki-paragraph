package post.tyrone.app;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import post.tyrone.wikiparagraph.WikiParagraph;
import post.tyrone.wikiparagraph.WikiParagraphException;

public class Application {

	/**
	 * main method.  Will run with command arguments, or begin prompting the user.
	 * @param args - command line args.
	 */
	public static void main(String[] args) {
		if (args.length > 0) {
			runWith(args);
		} else {
			promptUser();
		}
	}

	/**
	 * Executes If the user is prompted.  Will continue to prompt user until a valid 
	 * string is entered.
	 */
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

	/**
	 * Converts the string array (cmd args or scanned input) into a list and concatenates 
	 * the contents together, then prints the paragraph
	 * @param strArr - array of strings that make up the query topic.  Either input prompted
	 * for by the user, or command line arguments.
	 */
	private static void runWith(String[] strArr) {
		List<String> strList = Arrays.asList(strArr);
		String topic = concatTopic(strList);
		printParagraph(topic);
	}

	/**
	 * Takes a list of strings, and if they are greater than one, concatenates
	 * the tokens together delimited by an underscore
	 * @param strList - list of tokens that make up the query topic
	 * @return
	 */
	private static String concatTopic(List<String> strList) {
		Iterator<String> iterator = strList.iterator();
		String topic = iterator.next();
		while (iterator.hasNext()) {
			topic += "_" + iterator.next();
		}
		return topic;
	}

	/**
	 * Retrieves the introductory paragraph from the WikiParagraph module and prints it.
	 * If a WikiParagraphException is thrown, a NOT FOUND is output.
	 * @param topic - string used to query Wikipedia
	 */
	private static void printParagraph(String topic) {
		try {
			WikiParagraph wikiParagraph = new WikiParagraph();
			String paragraph = wikiParagraph.getParagraph(topic);
			out.println(paragraph);
		} catch (WikiParagraphException e) {
			out.println("NOT FOUND");
		}
	}
}
