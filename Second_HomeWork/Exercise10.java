


public class Exercise10 
{

	

        public static boolean isAbecedarian(String s) {
                int index = 0;
                char c = 'a'; 
                while (index < s.length()) {
                        if (c > s.charAt(index)) {
                                return false;
                        }
                        c = s.charAt(index); 
                        index = index + 1;
                        
                }
                return true;
        }


	public static void main(String[] args) 
	{
	
		String str="defg";
		if(isAbecedarian(str)){
			System.out.println("Yes!");	
		}
		else
		{
			System.out.println("No!");
		}
		
	}
}
