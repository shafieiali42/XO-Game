import Client.Client;
import Controller.Controller;
import View.Panels.LogInPanel.LogInPage;
import View.Panels.MyMainFrame.MyMainFrame;

public class ClientMain {

    public static void main(String[] args) {
        Client client = new Client();
        Controller.setCurrentClient(client);
        MyMainFrame myMainFrame = new MyMainFrame();
        myMainFrame.setContentPane(new LogInPage());

    }
}
