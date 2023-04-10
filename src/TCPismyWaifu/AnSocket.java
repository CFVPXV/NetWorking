package TCPismyWaifu;

import java.util.Scanner;

public class AnSocket {
    //We describe the socket as connecting two "processes" together
    //Processes are associated with a Port, which can accept data

    //TCP/IP Application: Processes and Ports
    //Network Layer: Making sure route are appropriate
    //Data Layer: No flipped bits
    //Physical: Passing along the copper or fiber

    //In essence, the server will listen for clients, the client will send an IP, and the server in turn
    //returns a socket class to the client, as a sign of connection!

    //But the core of the problem comes in when the lowest level

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter S for server, C for Client");
        String ans = s.next();
        if(ans.compareTo("S") == 0)
        {
            System.out.println("Starting...");
            serverSimple echo = new serverSimple("127.0.0.1",9000);
            echo.RunMe();
        }
        else if(ans.compareTo("C")==0)
        {
            System.out.println("Client starting...");
            ClientSimple cl = new ClientSimple("127.0.0.1",9000,"Hello Networking!");
            cl.RunEcho();
        }
        else
        {
            System.out.println("Incorrect input!");
        }
    }
}
