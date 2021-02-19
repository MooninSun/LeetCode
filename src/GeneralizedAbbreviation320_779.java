import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneralizedAbbreviation320_779 {
    //ChangA

    public List<String> generateAbbreviations(String word) {
        // Write your code here
        List<String> res = new ArrayList<>();
        dfs(res, word, "" , 0, false);
        Collections.reverse(res);
        return res;

    }

    private void dfs(List<String> res, String word, String cur, int pos, boolean lastAbb){

        if(pos == word.length()){
            res.add(cur);
            return;
        }

        dfs(res, word, cur+ word.charAt(pos), pos + 1, false);

        if(!lastAbb){
            for(int i=pos;i < word.length(); i++){
                dfs(res, word, cur + (i - pos + 1), i + 1 , true);
            }
        }

    }




}
