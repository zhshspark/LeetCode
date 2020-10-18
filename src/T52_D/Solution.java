package T52_D;

public class Solution {
	int res=0;
    public int totalNQueens(int n) {
		dfs(n, 0, 0, 0, 0);
		return res;
    }
    void dfs(int n, int row, int col, int ld, int rd) {
        if (row >= n) { res++; return; }
        
        // �������ܷ��� Q ��λ���� 0 ��� 1���Ա���к�����λ����
        int bits = ~(col | ld | rd) & ((1 << n) - 1);
        while (bits > 0) {
            int pick = bits & -bits; // 
            dfs(n, row + 1, col | pick, (ld | pick) << 1, (rd | pick) >> 1);
            bits &= bits - 1; 
        }
    }
}
