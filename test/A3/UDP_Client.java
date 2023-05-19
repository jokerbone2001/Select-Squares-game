import java.io.*;
import java.net.*;

public class UDP_Client
{
    public static void main(String[] args)
    {
        try {
            DatagramSocket socket = new DatagramSocket();
            String Message = "Hello";
            byte[] Buffer_out=Message.getBytes();
            byte[] ipAddr = new byte[]{127, 0, 0, 1};
            InetAddress addr = InetAddress.getByAddress(ipAddr);
            DatagramPacket packet_out= new DatagramPacket(Buffer_out, Buffer_out.length, addr, 7070);
            System.out.println("sending " + Message);

            
            String TheTime = Long.toString(System.currentTimeMillis());


            socket.send(packet_out);
            byte[] Buffer_in = new byte[256];
            DatagramPacket packet_in=new DatagramPacket(Buffer_in,Buffer_in.length);
            socket.receive(packet_in);
            String Response = new String(packet_in.getData());
            System.out.println("according to the server, the time is: " +Response);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}