
/*This class is count generator for server to count and display words of sentence to client
 * 
 * By ainahazlin
 * 
 */

public class CountGenerator {
	
	public int countTotalWords(String sentence) {
		int totalwords=0;
		for(int i = 0; i < sentence.length()-1; i++) {  
			//Counts all the spaces present in the string  
			//It doesn't include the first space as it won't be considered as a word  
			if(sentence.charAt(i) == ' ' && Character.isLetter(sentence.charAt(i+1)) && (i > 0)) {  
				totalwords++;  
			}  
		}  
		//To count the last word present in the string, increment wordCount by 1  
		totalwords++;  

		return totalwords;

	}
}
