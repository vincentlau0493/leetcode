import java.util.*;

public class WordLadder {

	public int ladderLength(String start, String end, Set<String> dict) {

		Queue<String> queue = new LinkedList<String>();
		Set<String> isVisited = new HashSet<String>();

		int step = 0;
		int len = start.length();
		queue.offer(start);
		isVisited.add(start);

		while(!queue.isEmpty()) {
			step++;
			int size = queue.size();

			for (int i=0; i<size; i++) {
				String word = queue.poll();
				char[] wordChar = word.toCharArray();

				for (int j=0; j<len; j++) {
					char tmp = wordChar[j];
					for (char c='a'; c<='z'; c++) {
						if (tmp == c) continue;

						wordChar[j] = c;
						String newWord = new String(wordChar);
						if (newWord.equals(end)) return step + 1;
						if (dict.contains(newWord)) {
							if (isVisited.contains(newWord)) continue;
							queue.offer(newWord);
							isVisited.add(newWord);
						}

					}
					wordChar[j] = tmp;

				}				
			}
		}


		return 0;
	}

}