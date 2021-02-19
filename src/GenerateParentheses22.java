import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        helper(result, "(",1, 0, n);

        return result;

    }

    private void helper(List<String> result, String current, int left, int right, int n){

        if(right == n){
            result.add(current);
            return;
        }

        if(left < n){
            helper(result, current + "(" , left + 1, right, n);
        }

        if(right < left)
            helper(result, current + ")", left, right + 1, n);

    }

}
