/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package basicJavaPractice;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author huijun
 */
public class NQueensSelf {
   public static List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<>();
        if(n == 0)  return result;
        
        int[] loc = new int[n]; //use array to represent positions: {2, 0, 3, 1} is Solution 2 above
        
        dfs(n, loc, 0, result);
        return result;
    }
    
    public static void dfs(int n, int[] loc, int cur, List<String[]> result) {
        if(cur == n){
            addResult(n, loc, result);
            return;
        }
        
        for(int j = 0; j < n; j++){
            loc[cur] = j;
            if(isValid(n, loc, cur)){
                dfs(n, loc, cur + 1, result);
            }
            //loc[cur] = 0;
        }
    }
    
    public static void addResult(int n, int[] loc, List<String[]> result) {
        String[] tmpArray = new String[n];
        
        for(int i = 0; i < n; i++){
            
            String tmp = "";
            for(int j = 0; j < n; j++){
                if(loc[i] == j){
                    tmp += "Q";
                }else{
                    tmp += ".";
                }
            }
            
            tmpArray[i] = tmp;
        }
        
        result.add(tmpArray);
    }
    
    public static boolean isValid(int n, int[] loc, int cur) {
        if(cur > 0){    //not first line
            if(Math.abs(loc[cur - 1] - loc[cur]) < 2)   return false;
        }
        
        if(cur < n - 1){    //not last line
            if(Math.abs(loc[cur + 1] - loc[cur]) < 2)   return false;
        }
        
        for(int i = 0; i < cur; i++){
            if(loc[i] == loc[cur])  return false;
        }
        
        return true;
    }
    
    public static void main(String[] args){
        System.out.println(solveNQueens(1));
    }
}
