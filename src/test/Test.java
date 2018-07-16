package test;

public class Test {

	public static void main(String[] args) {
		String str = "The String class";
		System.out.println("1. str을 char로 담아 역순으로 ");
		
		char[] res = getChar(str);
		for(char r: res){
			System.out.printf("%c", r);
		}
		System.out.println("\n\n 2.str에서 대문자만 출력");
		PrintUpper(str);
		
		System.out.println("\n\n 3. str에서 대문자 갯수" + "소문자갯수 출력");
		PrintCount(str);
	}
	private static char[] getChar(String str){			//역순
		char[] original_word = str.toCharArray();
		char[] reverse_word = new char[str.length()];
		
		for(int i= str.length()-1, j=0; i>0; i--,j++){	//역순으로 넣고 역순으로 출력
			reverse_word[j] = original_word[i]; 
			}
		return reverse_word;
	}
	private static void PrintCount(String str){			//대문자, 소문자 수
		char[] original_word = str.toCharArray();
		int upper_count = 0;
		int lower_count = 0;
		
		for(int i=0; i<str.length(); i++){
			if(Character.isUpperCase(original_word[i])){
				upper_count++;
			}
			if(Character.isLowerCase(original_word[i])){
				lower_count++;
			}
		}
		System.out.println("소문자 개수 :" + lower_count);
		System.out.println("대문자 개수 :" + upper_count);
	}
	private static void PrintUpper(String str){
		char[] original_word = str.toCharArray();
		for(int i=0; i<str.length(); i++){
			if(Character.isUpperCase(original_word[i])){	//대문자만
				System.out.printf("%c", original_word[i]);
			}
		}
	}
}
