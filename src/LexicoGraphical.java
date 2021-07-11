import java.util.LinkedList;
import java.util.List;

public class LexicoGraphical {
    static void lexPrinters(int n){
        List<Integer> list = new LinkedList<>();
        list.add(0);
        dfs(n,list,1);
        for(int i : list){
            System.out.println(i + " ");
        }
    }
    static void dfs(int n, List<Integer> list, int temp){
        if(temp > n){
            return;
        }
        list.add(temp);
        dfs(n,list,temp*10);
        if(temp % 10 != 9){
            dfs(n,list,temp+1);
        }
    }

    public static void main(String[] args) {
        int n = 15;
        lexPrinters(n);
    }
}
