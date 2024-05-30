import java.util.Queue;
import java.util.Stack;

public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		Stack<HtmlTag> openTags = new Stack<>();

		while (!tags.isEmpty()) {
			HtmlTag currentTag = tags.poll();

			if (currentTag.isOpenTag()) {
				openTags.push(currentTag);
			} else if (!currentTag.isSelfClosing()) {
				if (openTags.isEmpty() || !openTags.peek().matches(currentTag)) {
					return openTags.isEmpty() ? null : openTags;
				}
				openTags.pop();
			}
		}

		return openTags.isEmpty() ? new Stack<>() : openTags;
	}
}
