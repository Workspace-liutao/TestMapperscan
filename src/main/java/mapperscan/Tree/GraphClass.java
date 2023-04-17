package mapperscan.Tree;

import java.util.Stack;

public class GraphClass {
    public static void main(String[] args) {
        GraphClass  graphClass = new GraphClass();
        char[][] board = new char[][]{{'X','O','O','X','X','X','O','X','O','O'},
                {'X','O','X','X','X','X','X','X','X','X'},
                {'X','X','X','X','O','X','X','X','X','X'},
                {'X','O','X','X','X','O','X','X','X','O'},
                {'O','X','X','X','O','X','O','X','O','X'},
                {'X','X','O','X','X','O','O','X','X','X'},
                {'O','X','X','O','O','X','O','X','X','O'},
                {'O','X','X','X','X','X','O','X','X','X'},
                {'X','O','O','X','X','O','X','X','O','O'},
                {'X','X','X','O','O','X','O','X','X','O'}};
        graphClass.solve(board);
    }
    public void solve(char[][] board) {
        int  m=board.length;
        int n=board[0].length;
        Stack<int[]> stack = new Stack();
        for(int i=0;i<m;i++){
            dfs(stack,i,0,board,m,n);
            dfs(stack,i,n-1,board,m,n);
        }
        for(int i=0;i<n;i++){
            dfs(stack,0,i,board,m,n);
            dfs(stack,m-1,i,board,m,n);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='A'){
                    board[i][j]='O';
                } else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }

    }
    public void dfs(Stack<int[]> stack,int i,int j, char[][] board,int m,int n){
        int[] node= new int[]{i,j};
        if(board[i][j]=='O')board[i][j]='A';
        else  return;
        stack.push(node);
        while(!stack.isEmpty()){
            int[] tempNode=stack.peek();
            i=tempNode[0];
            j=tempNode[1];
            //检查上边的节点
            if(i-1>=0 && i<m  && j>=0 && j<n && board[i-1][j]=='O'){
                node =new int[]{i-1,j};
                stack.push(node);
                board[i-1][j]='A';
                continue;
            }
            //检查下边的节点
            if(i>=0 && i+1<m  && j>=0 && j<n && board[i+1][j]=='O'){
                node =new int[]{i+1,j};
                stack.push(node);
                board[i+1][j]='A';
                continue;
            }
            //检查左边的节点
            if(i>=0 && i<m  && j-1>=0 && j<n && board[i][j-1]=='O'){
                node =new int[]{i,j-1};
                stack.push(node);
                board[i][j-1]='A';
                continue;
            }
            //检查右边的节点
            if(i>0 && i<m  && j>0 && j+1<n && board[i][j+1]=='O'){
                node =new int[]{i,j+1};
                stack.push(node);
                board[i][j+1]='A';
                continue;
            }
            stack.pop();
        }
    }
}
