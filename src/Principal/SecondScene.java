/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author CORE I7
 */
public class SecondScene extends AbstractScene{
    
    public SecondScene(){
        super(obtainScene(),300,300);
        
        
    }
    
    private static VBox obtainScene(){
        VBox root = new VBox(50);
        root.setStyle("-fx-background-color: NAVAJOWHITE");
        
        StackPane sp = new StackPane();
        
        Text message = new Text("Gracias por ingresar sus datos");
        message.setFill(generarColor());
        
        sp.getChildren().add(message);
        
        Button btnExit = new Button("Salir");
        btnExit.setStyle("-fx-text-fill: white; -fx-background-color: blue; "
                + "-fx-border-color: white; -fx-boder-width: 5;"
                + "-fx-border-radius: 0; -fx-border-insets: 0; "
                + "-fx-border-style: solid line-join bevel line-cap square;"
                + "-fx-effect: dropshadow(one-pass-box, gray, 2, 0.6, 2, 2);");
        btnExit.setOnAction(e -> btnCloseClick());
        
        root.getChildren().addAll(sp,btnExit);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(50,0,30,0));
        root.setCenterShape(true);
        
        
        
        
        return root;
    }
    
    public static Color generarColor() {
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        Color customColor = Color.rgb(red, green, blue);
        return customColor;
    }
    
    private static void btnCloseClick(){
        
       Platform.exit();
    }

}
