import java.util.Random;
import java.util.Scanner;

public class String_Mixer
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Please enter a sentence: ");
		String word=in.nextLine();
		System.out.println(scramble(word));
	}

	public static String scramble(String sentence)
	{
		String result  = "";
		String[] words = sentence.split(" ");
		
		Random generator = new Random();
		
		for(int j=0; j < words.length; j++){
			String word = words[j];
			
			// greater 64 and less than 123
			
			char lastChar = word.charAt(word.length() - 1);
			
			/*
			 *Casting a char to int will give the ascii value of the character. The alphabet falls between 64 and 123.
			 *I adjust the max length based on if the ascii value falls between 64 and 123. You can be more accurate
			 *if you want.
			 */
			int maxLength = ( (int)lastChar > 64 && (int)lastChar < 123) ? word.length() -2 : word.length()-3; 
			
			char[] newWord = word.toCharArray();
			if(maxLength > 1){			
				
				for(int i = 0; i < maxLength; i++){

					
					int firstChar = generator.nextInt(maxLength) + 1;
					int secondChar = generator.nextInt(maxLength)+ 1;


					if(firstChar != secondChar){
						
						char temp = newWord[firstChar];						
						newWord[firstChar] = newWord[secondChar];
						newWord[secondChar] = temp;					
					}
				} 
				result += String.valueOf(newWord) + " ";
				}else {
				result += word + " ";
			}	
			
		}
		
		return result;
	}
}
