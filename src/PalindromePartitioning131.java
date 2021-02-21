import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning131 {
    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();
        if(s == null || s.isEmpty())
            return new ArrayList<>();

        dfs(s, res, new ArrayList<>(), 0);

        return res;

    }



    private void dfs(String s, List<List<String>> res, List<String> cur, int pos){

        if(pos >= s.length()){
            //res.add(cur);
            res.add(new ArrayList<>(cur));
            return;
        }

        /*
        can put single char into for loop

        */

        cur.add(s.charAt(pos) + "");
        //  dfs(s, res, new ArrayList<>(cur), pos + 1);
        dfs(s, res, cur, pos + 1);
        cur.remove(cur.size()-1);
        for(int i = pos + 1; i< s.length(); i++){
            if( check(s, pos, i)){
                cur.add(s.substring(pos, i+1));
                //dfs(s, res, new ArrayList<>(cur), i+1);
                dfs(s, res, cur, i+1);
                cur.remove(cur.size()-1);
            }
        }
    }


    private boolean check(String s, int left, int right){

        while(left<= right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;

        }

        return true;
    }

}
