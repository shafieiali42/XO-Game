package Client;

import Model.Player.Player;
import RequestAndResponse.Requests.LogInRequest;
import RequestAndResponse.Requests.Request;
import RequestAndResponse.Response.Response;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

public class Client {


    private Player player;
    private String serverIp;
    private int serverPort;
    private Socket socket;
    private ArrayList<Response> responses;


    public Client() {
        this.responses = new ArrayList<>();
    }

    public Client(String serverIp, int serverPort) {

        try {
            socket = new Socket(serverIp, serverPort);
            this.responses = new ArrayList<>();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Client(Player player) {
        super();
        this.player = player;
    }


    private void sendString(String message) {
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(socket.getOutputStream());
            printStream.println(message);
            printStream.flush();
            printStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void sendLogInRequest(String userName, String password, String mode) {
        Request request = new LogInRequest(userName, password, mode);
        String message = new Gson().toJson(request);
        sendString(message);
    }


    //getter and setters
    //********************

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


}
