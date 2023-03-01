package KPA;

import rotor96Crypto.Rotor96Crypto;

import java.io.*;
import java.util.ArrayList;

public class KPA {
    public static void main(String[] args) throws IOException {
        Rotor96Crypto rotor96Crypto = new Rotor96Crypto();
        FileInputStream fstream = new FileInputStream("passwords.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;
        ArrayList<String> keys =new ArrayList<>();

//Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            // Print the content on the console
            String a = rotor96Crypto.encdec(1,strLine,"Th");
            String cipher = "Wn";

            if(a.equals(cipher)){
                keys.add(strLine);
            }
        }
        System.out.println(keys);

//Close the input stream
        fstream.close();
        System.out.println(rotor96Crypto.encdec(2,keys.get(0),"WnC`Y_&` Iv@{XN[%_*z P^(2<Q^>4OAV1vy+ZH73hL\\Q!EA/a&OKfr:m{o=;ZrmV>3u1F/uHjyJD-WT%U\\JS6#zFn_NZ30O>y[!\n"));
        System.out.println(rotor96Crypto.encdec(2,keys.get(1),"WnC`Y_&` Iv@{XN[%_*z P^(2<Q^>4OAV1vy+ZH73hL\\Q!EA/a&OKfr:m{o=;ZrmV>3u1F/uHjyJD-WT%U\\JS6#zFn_NZ30O>y[!\n"));




    }
}