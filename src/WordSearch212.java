import java.util.ArrayList;
import java.util.List;

public class WordSearch212 {
    public List<String> findWords(char[][] board, String[] words) {

        List<String> res = new ArrayList<>();
        for(String word : words){
            // System.out.println(word);
            if(check(word,board))
                res.add(word);
        }

        return res;

    }


    private boolean check(String word, char[][] board){

        return dfs(word, board, null, 0, null);

    }

    private boolean dfs(String word, char[][] board, List<Integer> pos, int cur, boolean[][] visit){

        if(visit == null)
            visit = new boolean[board.length][board[0].length];

        if(cur >= word.length())
            return true;

        char target = word.charAt(cur);
        List<List<Integer>> positions = getPos(target, board, pos, visit);
        if(positions.isEmpty())
            return false;
        for(List<Integer> temp : positions){
            visit[temp.get(0)][temp.get(1)] = true;
            if(dfs(word, board, temp, cur+ 1, visit))
                return true;
            visit[temp.get(0)][temp.get(1)] = false;
        }

        return false;
    }

    private List<List<Integer>> getPos(char target, char[][] board, List<Integer> pos, boolean[][] visit){
        int m = board.length;
        int n = board[0].length;

        List<List<Integer>> res = new ArrayList<>();
        if(pos == null){
            for(int i = 0; i< m; i++){
                for(int j= 0; j < n; j++){
                    if(board[i][j] == target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(j);
                        res.add(temp);
                    }

                }
            }

        }else{
            int x = pos.get(0);
            int y = pos.get(1);
            int[] xArray = {-1,1,0,0};
            int[] yArray = {0,0,-1,1};
            for(int i = 0; i < 4; i++){
                int newi = x + xArray[i];
                int newj = y + yArray[i];
                // System.out.println(newi + " " + newj);
                if(newi >= 0 && newi < m && newj >= 0 && newj < n && !visit[newi][newj] && board[newi][newj] == target){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(newi);
                    temp.add(newj);
                    res.add(temp);
                }
            }

        }
        // System.out.print(target);
        //  System.out.println(res);
        return res;

    }

}
