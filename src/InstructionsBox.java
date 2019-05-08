import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


public class InstructionsBox {
    public static void displayInstructions(String[] instructions){
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("instructions");

        Label[] labels=new Label[10];
        for(int i=0;i<instructions.length;i++){
            labels[i]=new Label(instructions[i]);
        }

        VBox vBox=new VBox(10);
        for(int i=0;i<instructions.length;i++){
            vBox.getChildren().add(labels[i]);
        }
        Button button=new Button("OK");
        vBox.getChildren().add(button);
        vBox.setAlignment(Pos.CENTER);

        button.setOnAction(event->{
        	window.close();
        });
        Scene scene=new Scene(vBox,800,300);
        window.setScene(scene);
        window.showAndWait();
    }
}