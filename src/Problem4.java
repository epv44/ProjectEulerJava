import java.util.ArrayList;
import java.util.List;


public class Problem4 {
  public static void largestPalindrome(){
      int i = 0;
      int j = 0;
      List<Integer> palindromeSums = new ArrayList<Integer>();
      //set i equal to one hundred since we want three digit palindromes
      for(i=0; i < 1_000; i++){
          for(j=0; j< 1_000; j++){
              int sum = j*i;
              String sumAsString = Integer.toString(sum);
              if(isPalindrome(sumAsString)){
                  palindromeSums.add(sum);
              }
          }
      }
     System.out.println(palindromeSums.stream().max(Integer::compare).get());
  }
  
  private static boolean isPalindrome(String s){
      String reversed = new StringBuilder(s).reverse().toString();
      if(s.equals(reversed)){
          return true;
      }else{
          return false;
      }
      
  }
}
