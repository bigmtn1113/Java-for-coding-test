import java.util.ArrayList;

class Solution {

	public int solution(String s) {
		String start = "";
		String check1 = "";
		String check2 = "";
		ArrayList<String> result = new ArrayList<>();
		
		int minCnt = 1001;
		for (int i = 0; i < s.length(); ++i) {
			start += s.charAt(i);
			check1 = start;
			int cnt = 1;
			
			check2 = "";
			for (int j = check1.length(); j < s.length(); ++j) {
				check2 += s.charAt(j);
				
				if(check1.length() == check2.length()) {
					if (check1.equals(check2))
						++cnt;
					else {
						if (cnt != 1) result.add(Integer.toString(cnt));
						result.add(check1);
						
						cnt = 1;
						check1 = check2;
					}
					
					check2 = "";
				}
			}
			
			if (cnt != 1) result.add(Integer.toString(cnt));
			result.add(check1);
			if (check2 != "") result.add(check2);
			
			int temp = 0;
			for (int j = 0; j < result.size(); ++j)
				temp += result.get(j).length();
			minCnt = Math.min(minCnt, temp);
			result.clear();
		}
		
		return minCnt;
	}

}
