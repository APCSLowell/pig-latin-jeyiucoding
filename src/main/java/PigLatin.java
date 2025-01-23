import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {
    
    public void tester() {
        // String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	    System.out.println("there are " + lines.length + " lines");
	    for (int i = 0 ; i < lines.length; i++) {
	        System.out.println(pigLatin(lines[i]));
	    }
    }
   public int findFirstVowel(String sWord){
  int index = -1;
  for(int i= 0; i <= sWord.length()-1; i++){
    if(sWord.substring(i,i+1).equals("a") ||sWord.substring(i,i+1).equals("e") ||sWord.substring(i,i+1).equals("i") ||sWord.substring(i,i+1).equals("o") ||sWord.substring(i,i+1).equals("u")){
      index=i;
      break;
     }
  }
  return index;
}

public String pigLatin(String sWord)
//precondition: sWord is a valid String of length greater than 0
//postcondition: returns the pig latin equivalent of sWord
{
  int vowelIndex= findFirstVowel(sWord);
  if(vowelIndex == -1) {
     return sWord + "ay";
    }
  else if(vowelIndex == 0){
     return sWord + "way";
    }
  else if(vowelIndex > 0 && sWord.charAt(vowelIndex - 1) == 'q' && sWord.charAt(vowelIndex) == 'u'){
    String word = sWord.substring(0, vowelIndex+1);
    String restOfWord = sWord.substring(vowelIndex+1);
    return restOfWord + word + "ay";
  }
  else {
     String word = sWord.substring(0, vowelIndex);
     String restOfWord = sWord.substring(vowelIndex);
     return restOfWord + word + "ay";
    }
}
