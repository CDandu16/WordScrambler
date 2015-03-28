/**
 * Created by cdandu16 on 3/26/15.
 */
import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class HelloWorld {
    // switches the letter "A" with the letter immediately to the left.
    public static String ScrambleWord(String word){
        word = word.toUpperCase();
        if(!word.contains("A")){
            return word;
        }else{
            for(int i = 0; i<word.length()-1; i++){
                if(word.substring(i,i+1).contains("A") && !word.substring(i+1,i+2).contains("A"))//makes sure duplicate A's aren't switched
                {
                    String leftLetter = word.substring(i + 1, i + 2);
                    word = word.substring(0, i) + leftLetter + "A" + word.substring(i+2);//concatenates new string
                    i++;//do this to skip the next letter since we switched it
                }
            }
            return word;
        }
    }

    //takes a list and if the scrambled word equals the original word in the list it removes it from the list
    public static void ScrambleOrRemove(List<String> wordList){
        for(int i = 0; i<wordList.size(); i++){
            String word = ScrambleWord(wordList.get(i));
            if(word.equals(wordList.get(i).toUpperCase()))
                wordList.remove(i);
            else
                wordList.set(i, ScrambleWord(wordList.get(i)));
        }

        for(int i=0; i<wordList.size(); i++)//prints list
        {
            System.out.println(wordList.get(i));
        }
    }

    public static void main(String[] args){
        System.out.println(ScrambleWord("hello"));//will just return word
        System.out.println(ScrambleWord("APPLE"));
        List<String> list = new ArrayList<String>();
        list.addAll(Arrays.asList("Tan", "abraCadabra", "Whoa"));
        ScrambleOrRemove(list);//should
    }
}
