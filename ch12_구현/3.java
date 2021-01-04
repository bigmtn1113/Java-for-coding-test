/*
	String/ StringBuilder

	테스트 1 〉통과 (15.58ms, 52.9MB)	/	통과 (0.61ms, 53.3MB)
	테스트 2 〉통과 (36.35ms, 55MB)	/	통과 (6.55ms, 52.4MB)
	테스트 3 〉통과 (24.47ms, 54MB)	/	통과 (2.41ms, 52.4MB)
	테스트 4 〉통과 (14.27ms, 53.4MB)	/	통과 (0.29ms, 52.3MB)
	테스트 5 〉통과 (17.09ms, 52.5MB)	/	통과 (0.08ms, 52.8MB)
	테스트 6 〉통과 (16.63ms, 54.1MB)	/	통과 (0.47ms, 52.8MB)
	테스트 7 〉통과 (32.89ms, 54.6MB)	/	통과 (7.17ms, 52.1MB)
	테스트 8 〉통과 (39.10ms, 54.9MB)	/	통과 (5.24ms, 52.8MB)
	테스트 9 〉통과 (43.36ms, 55.7MB)	/	통과 (8.18ms, 52.7MB)
	테스트 10 〉통과 (122.38ms, 74.7MB)	/	통과 (36.35ms, 57.3MB)
	테스트 11 〉통과 (19.74ms, 52.9MB)	/	통과 (1.25ms, 52.2MB)
	테스트 12 〉통과 (17.68ms, 53MB)	/	통과 (1.12ms, 52.4MB)
	테스트 13 〉통과 (29.52ms, 54.1MB)	/	통과 (2.48ms, 51.9MB)
	테스트 14 〉통과 (43.88ms, 55.9MB)	/	통과 (11.95ms, 53.1MB)
	테스트 15 〉통과 (17.43ms, 53.4MB)	/	통과 (1.10ms, 53.1MB)
	테스트 16 〉통과 (13.55ms, 53.5MB)	/	통과 (0.17ms, 53MB)
	테스트 17 〉통과 (61.60ms, 62.5MB)	/	통과 (17.05ms, 52.8MB)
	테스트 18 〉통과 (67.10ms, 62.4MB)	/	통과 (16.61ms, 52.8MB)
	테스트 19 〉통과 (63.49ms, 61.8MB)	/	통과 (16.30ms, 53MB)
	테스트 20 〉통과 (114.95ms, 76.1MB)	/	통과 (38.67ms, 56.4MB)
	테스트 21 〉통과 (129.72ms, 76.6MB)	/	통과 (39.07ms, 57.2MB)
	테스트 22 〉통과 (113.39ms, 76.1MB)	/	통과 (43.03ms, 57.7MB)
	테스트 23 〉통과 (116.01ms, 76.3MB)	/	통과 (41.59ms, 57.4MB)
	테스트 24 〉통과 (103.89ms, 73.3MB)	/	통과 (37.99ms, 57.1MB)
	테스트 25 〉통과 (113.89ms, 75.7MB)	/	통과 (36.41ms, 57MB)
	테스트 26 〉통과 (109.95ms, 76.1MB)	/	통과 (38.96ms, 55.9MB)
	테스트 27 〉통과 (115.70ms, 75.8MB)	/	통과 (38.76ms, 57.4MB)
	테스트 28 〉통과 (17.75ms, 53.7MB)	/	통과 (0.19ms, 52.4MB)
*/

import java.util.ArrayList;

class Solution {

	public int solution(String s) {
		StringBuilder firstCuttingStr = new StringBuilder();
		StringBuilder str = new StringBuilder();
		StringBuilder result = new StringBuilder();
		int minResultLength = 1000;
		
		for (int i = 0; i < s.length() / 2 + 1; ++i) {
			firstCuttingStr.append(s.charAt(i));
			
			StringBuilder cuttingStr = new StringBuilder(firstCuttingStr);
			int compressionCount = 1;
			
			for (int j = i + 1; j < s.length(); ++j) {
				str.append(s.charAt(j));
				
				if (str.length() < cuttingStr.length()) {
					continue;
				}
				
				if (cuttingStr.toString().equals(str.toString())) {
					++compressionCount;
				} else {
					if (compressionCount > 1) {
						result.append(compressionCount);
						
						compressionCount = 1;
					}
					
					result.append(cuttingStr);
					
					cuttingStr = new StringBuilder(str);
				}
				
				str.setLength(0);
			}
			
			if (compressionCount > 1) {
				result.append(compressionCount);
			}
			
			result.append(cuttingStr);
			result.append(str);
			str.setLength(0);
			
			minResultLength = Math.min(minResultLength, result.length());
			result.setLength(0);
		}
		
		return minResultLength;
	}

}
