public class Solution {
  
	public static int[][] newLock; 
	
	public static int[][] rotateMatrixBy90Degree(int[][] key) {
		int keyLength = key.length;
		int[][] result = new int[keyLength][keyLength];
		
		for (int i = 0; i < keyLength; ++i) {
			for (int j = 0; j < keyLength; ++j) {
				result[j][keyLength - 1 - i] = key[i][j];
			}
		}
		
		return result;
	}
	
	public static boolean checkLock() {
		int newLockLength = newLock.length / 3;
		
		for (int i = newLockLength; i < newLockLength * 2; ++i) {
			for (int j = newLockLength; j < newLockLength * 2; ++j) {
				if (newLock[i][j] != 1) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean solution(int[][] key, int[][] lock) {
		int keySize = key.length;
		int lockSize = lock.length;
		
		newLock = new int[lockSize * 3][lockSize * 3];
		
		for (int i = 0; i < lockSize; ++i) {
			for (int j = 0; j < lockSize; ++j) {
				newLock[i + lockSize][j + lockSize] = lock[i][j];
			}
		}
		
		for (int rotation = 0; rotation < 4; ++rotation) {
			key = rotateMatrixBy90Degree(key);
			
			for (int i = 0; i < lockSize * 2; ++i) {
				for (int j = 0; j < lockSize * 2; ++j) {
					for (int k = 0; k < keySize; ++k) {
						for (int l = 0; l < keySize; ++l) {
							newLock[i + k][j + l] += key[k][l];
						}
					}
					
					if (checkLock()) {
						return true;
					};
					
					for (int k = 0; k < keySize; ++k) {
						for (int l = 0; l < keySize; ++l) {
							newLock[i + k][j + l] -= key[k][l];
						}
					}
				}
			}
		}
		
		return false;
	}
}
