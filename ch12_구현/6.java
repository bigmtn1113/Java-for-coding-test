import java.util.*;

class StructureState implements Comparable<StructureState>{
	private int x;
	private int y;
	private int structure;
	
	public StructureState(int x, int y, int structure) {
		this.x = x;
		this.y = y;
		this.structure = structure;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getStructure() {
		return structure;
	}

	@Override
	public int compareTo(StructureState o) {
		if (x == o.x && y == o.y) {
			return structure - o.structure;
		}
		
		if (x == o.x) {
			return y - o.y;
		}
		
		return x - o.x;
	}
}

class Solution {
  public static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	
	public static boolean checkBuildFrame() {
		for (ArrayList<Integer> resultElem : result) {
			int x = resultElem.get(0);
			int y = resultElem.get(1);
			int structure = resultElem.get(2);
			
			boolean check = false;
			
			if (structure == 0) {		// 기둥
				if (y == 0) {		// 기둥이 바닥 위에 존재
					check = true;
					
					continue;
				}
				
				for (ArrayList<Integer> temp : result) {
					int tempX = temp.get(0);
					int tempY = temp.get(1);
					int tempStructure = temp.get(2);
					
					if ((tempX == x - 1) && (tempY == y) && (tempStructure == 1)		// 기둥이 보의 오른쪽 위에 존재
							|| (tempX == x) && (tempY == y) && (tempStructure == 1)		// 기둥이 보의 왼쪽 위에 존재
							|| (tempX == x) && (tempY == y - 1) && (tempStructure == 0)) {		// 기둥이 다른 기둥 위에 존재
						check = true;
					}
				}
			} else if (structure == 1) {		// 보
				boolean isConnectedToLeft = false;
				boolean isConnectedToRight = false;
				
				for (ArrayList<Integer> temp : result) {
					int tempX = temp.get(0);
					int tempY = temp.get(1);
					int tempStructure = temp.get(2);
					
					if ((tempX == x) && (tempY == y - 1) && (tempStructure == 0)		// 보 왼쪽이 기둥 위에 존재
							|| (tempX == x + 1) && (tempY == y - 1) && (tempStructure == 0)) {		// 보 오른쪽이 기둥 위에 존재
						check = true;
					}
					
					if ((tempX == x - 1) && (tempY == y) && (tempStructure == 1)) {		// 보 왼쪽에 다른 보 연결
						isConnectedToLeft = true;
					}
					
					if ((tempX == x + 1) && (tempY == y) && (tempStructure == 1)) {		// 보 오른쪽에 다른 보 연결
						isConnectedToRight = true;
					}
				}
				
				if (isConnectedToLeft && isConnectedToRight) {
					check = true;
				}
			}
			
			if (!check) {
				return false;
			}
		}
		
		return true;
	}
	
	public static int[][] solution(int n, int[][] build_frame) {
		for (int[] buildFrameElem : build_frame) {
			int x = buildFrameElem[0];
			int y = buildFrameElem[1];
			int structure = buildFrameElem[2];
			int insOrDel = buildFrameElem[3];
			
			if (insOrDel == 1) {		// 설치
				ArrayList<Integer> insert = new ArrayList<>();
				
				insert.add(x);
				insert.add(y);
				insert.add(structure);
				
				result.add(insert);
				
				if (!checkBuildFrame()) {		// 설치 가능 여부 판단
					result.remove(result.size() - 1);		// 설치가 불가능하면 다시 제거
				}
			} else if (insOrDel == 0) {		// 삭제
				int index = 0;
				
				for (int i = 0; i < result.size(); ++i) {		// 삭제할 요소 위치 찾기
					if (x == result.get(i).get(0) && y == result.get(i).get(1) && structure == result.get(i).get(2)) {
						index = i;
					}
				}
				
				ArrayList<Integer> delete = result.get(index);		// 삭제하기 전 저장
				
				result.remove(index);
				
				if (!checkBuildFrame()) {		// 삭제 가능 여부 판단
					result.add(delete);		// 삭제가 불가능하면 다시 추가
				}
			}
		}
		
		// 결과물 정렬
		StructureState[] structureState = new StructureState[result.size()];
		
		for (int i = 0; i < structureState.length; ++i) {
			structureState[i] = new StructureState(result.get(i).get(0), result.get(i).get(1), result.get(i).get(2));
		}
		
		Arrays.sort(structureState);
		
		// 결과물 배열로 저장
		int[][] answer = new int[structureState.length][3];
		
		for (int i = 0; i < structureState.length; ++i) {
			answer[i][0] = structureState[i].getX();
			answer[i][1] = structureState[i].getY();
			answer[i][2] = structureState[i].getStructure();
		}
		
		return answer;
	}
}
