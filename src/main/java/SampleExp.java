
public class SampleExp {
	
	public static void main(String [] args) {
		String S="DALAD";
		String b="";
		
		 for (int i=S.length()-1; i>=0; i--) {
			
			b=b+S.charAt(i);
			
		}
		System.out.println(b.matches(S));
		
	}

}
