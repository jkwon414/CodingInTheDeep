// TLE in large judge
public class Solution {
    
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if (S == null && T != null){
            return 0;
        }
        
        if (S.length() < T.length()){
            return 0;
        }
        
        int sum = 0;
        char ch; 
        if (T.length() == 1){
            ch = T.charAt(0);
            for (int i = 0; i < S.length(); i++){
                if (S.charAt(i) == ch){
                    sum++;
                }
            }
        }
        else{
            ch = T.charAt(T.length() -1);
            for (int i = 0; i < S.length(); i++){
                if (S.charAt(i) == ch){
                    sum += numDistinct(S.substring(0,i), T.substring(0,T.length()-1));
                }
            }
        }
        
        return sum;
        
    }
}



public class Solution {
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int slen = S.length();
        int tlen = T.length();
        if (slen < tlen){
            return 0;
        }
        
        int[][] mem = new int[slen+1][tlen+1];
        mem[0][0] = 1;
        
        for(int i = 1; i < tlen; i++){
            mem[0][i] = 0;
        }
        
        for(int i = 1; i < slen; i++){
            mem[i][0] = 1;
        }
        
        for (int i = 1; i<= slen; i++){
            for (int j = 1; j <= tlen; j++){
                if (S.charAt(i-1) == T.charAt(j-1)){
                    mem[i][j] = mem[i-1][j] + mem[i-1][j-1];
                }
                else{
                    mem[i][j] = mem[i-1][j];
                }
            }
        }
        return mem[slen][tlen];
    }
}