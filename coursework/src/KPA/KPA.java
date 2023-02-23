package KPA;

import rotor96Crypto.Rotor96Crypto;

import java.io.*;

public class KPA {
    public static void main(String[] args) throws IOException {
        String password = null;
        Rotor96Crypto rotor96Crypto = new Rotor96Crypto();
        FileInputStream fstream = new FileInputStream("passwords.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;

//Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            // Print the content on the console
            String a = rotor96Crypto.encdec(1,strLine,"Th");
            String cipher = "i\"";
//            System.out.println (a);

            if(a.equals(cipher)){
                System.out.println ("find");
                System.out.println (strLine);
                System.out.println (a);
                password = strLine;
                break;
            }
        }

//Close the input stream
        fstream.close();

        String b = rotor96Crypto.encdec(2,password,"i\"YY|w$=@]a]~_4o5aP-e!K0\\S9CJ;2zT3z5pLS@}5\u007FC]9.c)\u007FDO0J{v3>:w&u'L&lR-4\"xp-(Ab{3dOirR`.ip4+y<#rk+rBuN<");
        System.out.println(b);


    }
}