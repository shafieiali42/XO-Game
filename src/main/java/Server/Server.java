package Server;

import RequestAndResponse.Requests.Request;
import RequestAndResponse.Response.JsonDeSerializerForRequest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server extends Thread {

    private static final int serverPort = 8585;
    ServerSocket serverSocket;
    private ArrayList<Request> requests;
    private volatile boolean running;

    public Server() {
        try {
            serverSocket = new ServerSocket(serverPort);
            requests = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void executeRequests() {
        for (Request request : requests) {
            request.execute();
        }
    }


    @Override
    public void run() {
        running = true;
        while (running) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                Scanner myScanner = new Scanner(socket.getInputStream());
                while (myScanner.hasNextLine()) {
                    requests.add(JsonDeSerializerForRequest.deSerializeRequest(myScanner.nextLine()));
                    executeRequests();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }


}
