package T200_M;



public class Solution {
	//���˹���һ��С�����⣬���Ĳ���
    public int numIslands(char[][] grid) {
    	int res=0;
    	for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j]=='1') {
					res++;
					dfs(grid,i,j);
				}
			}
		}
    	return res;
    }

	private void dfs(char[][] grid, int i, int j) {
		if (i<0||i>=grid.length||j<0||j>=grid[i].length||grid[i][j]=='0') {
			return;
		}
		//����ǰ������Ϊ'0'
		grid[i][j]='0';
		//���ĸ������ϼ�������
		dfs(grid, i+1, j);
		dfs(grid, i-1, j);
		dfs(grid, i, j+1);
		dfs(grid, i, j-1);
	}
    
}
