package sample;

public class Us {
    public int idUsers;
    private String firstname;
    private String lastname;
    private String login;
    private String password;

    public Us(String firstname, String lastname, String login, String password){
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
    }

    public Us() {
    }

    public Us(int idUsers, String firstname, String lastname, String login, String password) {
        this.idUsers = idUsers;
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
    }

    public Integer getIdUsers(){
        return idUsers;
    }

    public void setIdUsers(Integer idUsers){
        this.idUsers = idUsers;
    }

    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }


}
