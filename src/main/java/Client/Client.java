package Client;

import Model.Player.Player;
import RequestAndResponse.Requests.LogInRequest;
import RequestAndResponse.Requests.Request;
import RequestAndResponse.Response.Response;

import java.util.ArrayList;

public class Client {


    private Player player;

    private ArrayList<Response> responses;

    public Client() {
        this.responses = new ArrayList<>();

    }

    public Client(Player player) {
        super();
        this.player = player;
    }


    public void sendLogInRequest(String userName, String password, String mode) {
        Request request = new LogInRequest(userName, password, mode);


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
