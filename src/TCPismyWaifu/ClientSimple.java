package TCPismyWaifu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSimple
{
    String msg;
    int port;
    String address;
    public ClientSimple(String a,int p, String m)
    {
        msg = m;
        port = p;
        address = a;
    }
    public void RunEcho()
    {
        try{
            System.out.println("Connecting to server...");
            Socket con = new Socket(address, port);
            DataInputStream in = new DataInputStream(con.getInputStream());
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            //Note how client writes...
            System.out.println("Message of sending!");
            out.writeUTF(msg);
            //...then reads
            System.out.println("Read from server! "+in.readUTF());
        }
        catch(IOException e)
        {
            System.out.println("ERROR with client! "+e.getMessage());
        }
    }
}
