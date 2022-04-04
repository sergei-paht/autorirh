package sample;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.DataBaseHandler;
import sample.Main;
import sample.Us;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButt;

    @FXML
    private Button enterButton;

    @FXML
    private TextField loginFieldAurh;

    @FXML
    private PasswordField passwordFieldAuth;

    @FXML
    void initialize() {

        enterButton.setOnAction(event -> {
            String textLogin = loginFieldAurh.getText().trim();
            String textPassword = passwordFieldAuth.getText().trim();
            if(!textLogin.equals("") && !textPassword.equals("")){
                try {
                    loginUser(textLogin, textPassword);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Ошибка");
                alert.setHeaderText("Поля не заполнены!");
                alert.setContentText("Заполните все поля!");

                alert.showAndWait();
            }
        });
        backButt.setOnAction(event -> {
            backButt.getScene().getWindow().hide();
            Main.OpenIcon("/sample/SceneFxml/sample.fxml");
        });

    }

    private void loginUser(String textLogin, String textPassword) throws SQLException {
        DataBaseHandler dbHandler = new DataBaseHandler();
        Us us = new Us();
        us.setLogin(textLogin);
        us.setPassword(textPassword);
        ResultSet resultAuto = dbHandler.getUser(us);
        ResultSet resultRole = dbHandler.getRoles(us);

        if(resultAuto.next() && resultRole.next()){
            String userRole = resultRole.getString("ID");
            if(userRole == "Administrator") System.out.println("admin");
            else System.out.println("/com/example/avia/User.fxml");

        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Пользователь не найдет");
            alert.setContentText("Нажмине <Ок>, затем попробуйте сново, возможно вы где-то допустили ошибку.");

            alert.showAndWait();
        }

    }



}
