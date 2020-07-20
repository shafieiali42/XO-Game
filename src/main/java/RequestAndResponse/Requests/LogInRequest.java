package RequestAndResponse.Requests;

public class LogInRequest implements Request{

    private String userName;
    private String password;
    private String mode; //SignUp or LogIn


    public LogInRequest(String userName,String password,String mode){
        this.userName=userName;
        this.password=password;
        this.mode=mode;
    }



    @Override
    public void execute() {
        if (this.mode.equalsIgnoreCase("SignUp")){


        }else if (this.mode.equalsIgnoreCase("LogIn")){


        }
    }

}
