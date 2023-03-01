package COA;

import rotor96Crypto.Rotor96Crypto;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class COA {
    public static void main(String[] args) throws IOException {
        String password = null;
        Rotor96Crypto rotor96Crypto = new Rotor96Crypto();
        FileInputStream fstream = new FileInputStream("passwords.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        FileInputStream fstream2 = new FileInputStream("word.txt");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(fstream2));
        String word;

        String strLine;
        FileWriter writer = new FileWriter("output.txt");
//        System.out.println(br.readLine());
//        String a = rotor96Crypto.encdec(2, br.readLine(), "R");
//        System.out.println(a);
        ArrayList<String> words = new ArrayList<>();
        while ((word = br2.readLine()) != null) {
            words.add(word);
        }
        String key;
        ArrayList<String> passwords = new ArrayList<>();
        while ((key = br.readLine()) != null){
            passwords.add(key);

        }
        ArrayList<String> plain = new ArrayList<>();


        //use 2 ciphere text
//        for (int i = 0; i < passwords.size(); i++) {
//            String b = rotor96Crypto.encdec(2, passwords.get(i), "RX");
//            b = b.toLowerCase();
//            if (b.contains(" ")) {
//                if(Character.isLetter(b.charAt(0))){
//                    plain.add(b);
//                }
//            }else{
//                for (int n = 0; n < words.size(); n++) {
//                    if (words.get(n).charAt(0) == b.charAt(0) && words.get(n).charAt(1) == b.charAt(1)) {
//                        System.out.println("english word:"+b);
//                        plain.add(b);
//
//                    }
//                }
//            }
//        }
//        System.out.println(plain.size());

        //use 3 ciphere text
//        for (int i = 0; i < passwords.size(); i++) {
//            String b = rotor96Crypto.encdec(2, passwords.get(i), "RXY");
//            b = b.toLowerCase();
//            if (b.contains(" ")) {
//                if(containsOnlyLettersAndSpaces(b)){
//                    plain.add(b);
//                }
//            }
//            for (int n = 0; n < words.size(); n++) {
//                if(words.get(n).length()>=3){
//                    if (words.get(n).charAt(0) == b.charAt(0) && words.get(n).charAt(1) == b.charAt(1)) {
//                        String word_need = words.get(n).substring(0,3);
//                        if(b.equals(word_need)){
//                            plain.add(b);
//                        }
//                    }
//                }
//
//            }
//        }
//        System.out.println(plain);

        //user 4 ciphere text
        for (int i = 0; i < passwords.size(); i++) {
            String b = rotor96Crypto.encdec(2, passwords.get(i), "RXY(");
            b = b.toLowerCase();
//            System.out.println("b:" + b);
            if (b.contains(" ")) {
                if(containsOnlyLettersAndSpaces(b)&&b.charAt(0)!=' '){
                    String[] texts = b.split("\\s+"); // 以空格为分隔符分割字符串
                    System.out.println("text"+texts[0]);
                    String longest = findLongestString(texts);
                    if(longest.length()==3){
                        for (int n = 0; n < words.size(); n++) {
                            if(words.get(n).length()>=3){
                                if (words.get(n).charAt(0) == b.charAt(0) && words.get(n).charAt(1) == b.charAt(1)) {
                                    String word_need = words.get(n).substring(0,3);
                                    if(b.equals(word_need)){
                                        plain.add(b);
                                    }
                                }
                            }

                        }
                    }
                    if(longest.length()==2){
                        for (int n = 0; n < words.size(); n++) {
                            if(words.get(n).length()>=2){
                                if (words.get(n).charAt(0) == b.charAt(0) && words.get(n).charAt(1) == b.charAt(1)) {
                                        plain.add(b);
                                }
                            }

                        }
                    }

                }
            }
            for (int n = 0; n < words.size(); n++) {
                if(words.get(n).length()>=4){
//                    System.out.println(words.get(n));
                    if (words.get(n).charAt(0) == b.charAt(0) && words.get(n).charAt(1) == b.charAt(1)) {
                        String word_need = words.get(n).substring(0,4);
//                        System.out.println(word_need);
//                        System.out.println(b);
                        if(b.equals(word_need)){
                            plain.add(b);
                            plain.add(passwords.get(i));
                        }
                    }
                }

            }
        }
        System.out.println(plain);


        String b = rotor96Crypto.encdec(2,"coolhand","RXY(4sqT4FUu\u007FD-}pjpTMsy0a=M^}HAOF\"U!m[TZ-q?BxH<3$U{Z$7Z@2R_sVPIL;c5kL2$qWm5#mk0fle_h['eh8tSDy9 54`gd,d2RLhU# x-}Jcz,Kh]gvu`&+LwyE'W7pBRQ?f\\$,x_`gUwqGyVn-PhPW<F<S%K[z2`?LFJ4.=WMDbSN6C3(9CSkp~j,@9qb4sqT%\\x!?4~ Um4T,4%uX/,%}$[`cQqS-sJ;qx$7*wM jLw4g80@ItL\\XC)#WSTj^2fVD\u007F n%)0t bM\u007F>/e^xrr+^R(U4]2JOpkoeM(u #= \"C],gsT'45hvEu''i}mD~pJNB");
        System.out.println(b);


    }
    public static boolean containsOnlyLettersAndSpaces(String str) {
        return str.matches("[a-zA-Z\\s]+");
    }
    public static String findLongestString(String[] arr) {
        String longest = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > longest.length()) {
                longest = arr[i];
            }
        }
        return longest;
    }




}
