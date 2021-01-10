package Principal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author CORE I7
 */
public class Formulario extends Application {
    
    ArrayList<Persona> personas = new ArrayList<>();
    ArrayList<Persona> personasSerial = new ArrayList<>();
    
    @Override
    public void init(){
        Archivo.crearFicheros();
        personas = Archivo.leerFicheroTxt();
        personasSerial = Archivo.leerFicheroSerial();
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        AbstractScene.setGeneralStage(primaryStage);
        
        SecondScene sesc = new SecondScene();
        MainScene scene = new MainScene(sesc.getGeneralScene(),personasSerial);
        
        primaryStage.setTitle("Registration Form");
        primaryStage.setScene(scene.getGeneralScene());
        primaryStage.setOnCloseRequest(e -> {
                                       e.consume();
                                       Auxiliar.btnCloseClick(primaryStage);
        });
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
