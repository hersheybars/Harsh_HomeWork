
public class Exercise11 {
        
        public static boolean isDupledrome(String s) {
                int length = s.length();
                
                // can't be a dupledrome if s has odd number of letters
                if (length%2 != 0) {
                        return false;
                }
                
                int index = 0;
                while (index < length) {
                        if (s.charAt(index) != s.charAt(index + 1)) {
                                return false;
                        }
                        index = index + 2;
                }
                return true;
        }
        public static void main(String args[])
        {
        	String str="aabbc";
        	System.out.println(isDupledrome(str));
        }

}
