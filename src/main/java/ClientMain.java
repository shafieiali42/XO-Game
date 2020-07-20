import View.Panels.LogInPanel.LogInPage;
import View.Panels.MyMainFrame.MyMainFrame;

public class ClientMain {

    public static void main(String[] args) {
        MyMainFrame myMainFrame=new MyMainFrame();
        myMainFrame.setContentPane(new LogInPage());
    }
}
