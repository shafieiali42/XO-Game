package RequestAndResponse.Response;

import Main.ClientMain;
import View.Panels.MainMenu.MainMenuPage;
import com.sun.tools.javac.Main;

import javax.swing.*;

public class LogInResponse implements Response {

    private boolean success;
    private String message;

    public LogInResponse(boolean success,String message){
        this.success=success;
        this.message=message;
    }


    @Override
    public void execute() {
        if (success){
            ClientMain.getMyMainFrame().setContentPane(new MainMenuPage());
        }else {
            JOptionPane.showMessageDialog(null,message,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }


}
