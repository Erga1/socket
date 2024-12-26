import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        DataInputStream in;
        DataOutputStream out;
        String resp;
        String req;
        Scanner sc = new Scanner(System.in);

        try{
            Socket sok=new Socket("localhost",2020);
            System.out.println("Connection Successful");
            in=new DataInputStream(sok.getInputStream());
            out=new DataOutputStream(sok.getOutputStream());
            while(true) {


                System.out.print("You:- ");
                req=sc.nextLine();
                out.writeUTF(req);
                resp = in.readUTF();

                if ( resp.substring(0,resp.length()-9).equals("exit")) {
                    break;
                }
                System.out.println("server: "+resp);

            }

        }
        catch(IOException e){
            System.out.println(e);
        }


    }
}