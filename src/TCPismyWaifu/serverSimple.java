package TCPismyWaifu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class serverSimple
{
    ServerSocket serve;
    public serverSimple(String IP, int port)
    {
        try
        {
            serve = new ServerSocket(port);
        }
        catch (IOException e )
        {
            System.out.println("ERROR Creating the server: "+e.getMessage());
        }
    }
    public void RunMe()
    {
        Socket con;
        try
        {
            System.out.println("Listening for clients...");
            //First statement stops the thread!
            con = serve.accept();
            System.out.println("Client accepted!" + con.getInetAddress());
            DataInputStream in = new DataInputStream(con.getInputStream());
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            //Note how server reads...
            String s = in.readUTF();
            System.out.println("Received a "+s);
            //...then writes.
            out.writeUTF("ECHO: "+s);
            con.close();
        }
        catch(IOException e)
        {
            System.out.println("ERROR accepting: "+e.getMessage());
        }
    }
}
