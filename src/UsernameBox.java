import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


public class UsernameBox {
    private String username;
    public String saveBox(){
        Stage window=new Stage();
        window.setTitle("Save Game");
        Label label=new Label("Enter Your Name");
        label.setFont(Font.font(22));
        Button button=new Button("Save");
        TextField textField=new TextField();
        VBox vBox=new VBox(50);
        vBox.getChildren().addAll(label,textField,button);
        vBox.setAlignment(Pos.CENTER);
        Scene scene=new Scene(vBox,600,300);
        button.setOnAction(event -> {
            if(textField.getText().isEmpty()){
//                Alert.display("Please Enter your name");
            }
            else {
                username=textField.getText();
                window.close();
            }
        });
        window.setScene(scene);
        window.show();

        return username;
    }
}
