import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) {
        DataInputStream in;
        DataOutputStream out;
        String resp;

        try{
            ServerSocket sok=new ServerSocket(2020);
            Socket so=sok.accept();
            System.out.println("Connection Successful");
            in=new DataInputStream(so.getInputStream());
            out=new DataOutputStream(so.getOutputStream());
            while(true) {
                resp = in.readUTF();
                if (resp.equals("exit")) {
                    break;
                }
                System.out.println("Client: "+resp);
                out.writeUTF(resp+" recieved");
            }

        }
        catch(IOException e){
            System.out.println(e);
        }


    }
}