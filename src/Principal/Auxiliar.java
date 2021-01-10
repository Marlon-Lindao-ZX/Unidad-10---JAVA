/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import static Principal.MainScene.value;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author CORE I7
 */
public class Auxiliar {
    
    public static void btnCloseClick(Stage stage){
        
        boolean quit;
        
        quit = ConfirmationBox.show("¿Realmente desea salir?","Confirmacion","Si","No");
        
        if(quit){
            Platform.exit();
        }
        
    }
    
    public static void btnChangeScene(Stage stage, Scene scene){
        
        stage.setScene(scene);
        
    }
    
    public static void btnRegisterClick(TextField tf, DatePicker dt,RadioButton rdb1,RadioButton rdb2, 
            CheckBox cb1, CheckBox cb2 ,ListView<String> list,
            ComboBox<String> cbox,Label message,Button btn,Button btn2,ArrayList<Persona> personasS){
        
        String rdbtn = "";
        String cb = "";
        String reservacion = "";
        
        
        if((tf.getText().length() == 0) || (dt.getValue() == null) || ( (!rdb1.isSelected()) && (!rdb2.isSelected())) 
                || (value == null) ||  (list.getSelectionModel().getSelectedItem().length() == 0) 
                || (cbox.getSelectionModel().getSelectedItem().length() == 0)){
            message.setText("Debe llenar todos los campos");
            message.setStyle("-fx-font-weight:bolder; -fx-text-fill: red");
            btn.setDisable(true);
            
        } else  {
            message.setText("");
            if(rdb1.isSelected()) rdbtn += rdb1.getText();
            if(rdb2.isSelected()) rdbtn += rdb2.getText();
            if(cb1.isSelected()) cb += cb1.getText();
            if(cb2.isSelected()){
                if(cb1.isSelected()){
                    cb +=","+cb2.getText();
                } else {
                    cb += cb2.getText();
                }
                
            }
            if(value){
                reservacion = "Si";
            } else {
                reservacion = "No";
            }
            
        }
        
        if(message.getText().length() == 0){
            btn.setDisable(false);
            btn2.setDisable(true);
            
            Persona persona = new Persona(tf.getText(),dt.getValue(),rdbtn,reservacion,cb,list.getSelectionModel().getSelectedItem(),
            cbox.getSelectionModel().getSelectedItem());
            
            System.out.println(persona);
            
            personasS.add(persona);
            
            Archivo.escribirFicheros(personasS);
            
        }
        
    }
    
}
