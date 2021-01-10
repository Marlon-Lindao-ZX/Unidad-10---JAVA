/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author CORE I7
 */
public class MainScene extends AbstractScene {
    
    static Boolean value = null;

    public MainScene(Scene scene,ArrayList<Persona> personasS) {
        super(obtainScene(scene,personasS), 470, 395);
    }

    private static VBox obtainScene(Scene scene,ArrayList<Persona> personasS) {
        
        VBox vbox = new VBox(20);
        vbox.setStyle("-fx-background-color: NAVAJOWHITE");
        
        GridPane gp = new GridPane();

        Text nombre = new Text("Nombre");
        nombre.setStyle("-fx-font-weight:bolder");
        
        Text fechaNac = new Text("Fecha de Nacimiento");
        fechaNac.setStyle("-fx-font-weight:bolder");
        
        Text genero = new Text("Genero");
        genero.setStyle(" -fx-font-weight:bolder");
        
        Text reservacion = new Text("Reservacion");
        reservacion.setStyle("-fx-font-weight:bolder");
        
        Text tecnoConoc = new Text("Tecnologias Conocidas");
        tecnoConoc.setStyle("-fx-font-weight:bolder");
        
        Text nivelEduc = new Text("Nivel Educacion");
        nivelEduc.setStyle("-fx-font-weight:bolder");
        
        Text ubicacion = new Text("Ubicacion");
        ubicacion.setStyle("-fx-font-weight:bolder");

        gp.add(nombre, 0, 0);
        gp.add(fechaNac, 0, 1);
        gp.add(genero, 0, 2);
        gp.add(reservacion, 0, 3);
        gp.add(tecnoConoc, 0, 4);
        gp.add(nivelEduc, 0, 5);
        gp.add(ubicacion, 0, 6);

        TextField tfnombre = new TextField();
        tfnombre.setPromptText("(Ingrese aqui el nombre)");

        gp.add(tfnombre, 1, 0);

        DatePicker fechaNacimiento = new DatePicker();
        fechaNacimiento.setPromptText("(Seleccione aqui su fecha)");

        gp.add(fechaNacimiento, 1, 1);

        HBox radiobuttons = new HBox(10);

        ToggleGroup tg = new ToggleGroup();
        RadioButton rdb1 = new RadioButton("Masculino");
        rdb1.setToggleGroup(tg);
        RadioButton rdb2 = new RadioButton("Femenino");
        rdb2.setToggleGroup(tg);

        radiobuttons.getChildren().addAll(rdb1, rdb2);

        gp.add(radiobuttons, 1, 2);

        HBox boxBtnReserv = new HBox(15);
        
        

        Button btnYes = new Button("Si");
        btnYes.setOnAction(e -> btnYesNoClick(true));
        
        Button btnNo = new Button("No");
        btnNo.setOnAction(e -> btnYesNoClick(false));

        boxBtnReserv.getChildren().addAll(btnYes, btnNo);

        gp.add(boxBtnReserv, 1, 3);

        HBox boxCheckBox = new HBox(15);

        CheckBox cb1 = new CheckBox("Java");
        CheckBox cb2 = new CheckBox("Dotnet");

        boxCheckBox.getChildren().addAll(cb1, cb2);

        gp.add(boxCheckBox, 1, 4);
        
        ListView<String> list = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList("Engineering","MCA","MBA","Graduation","MTCECH",
                                                                         "Mphil","Phd");
        list.setItems(items);
        
        gp.add(list, 1, 5);

        HBox boxUbLabel = new HBox(10);

        Label message = new Label("");

        ComboBox<String> ciudades = new ComboBox();

        ciudades.getItems().addAll("Guayaquil", "Quito", "Manta", "PortoViejo", "Atacames", "Quevedo", "Santo Domingo",
                "Cuenca", "Loja", "Guaranda", "Ambato", "Machala", "Tenas", "Puyo", "Tulcan");
        
        ciudades.setPromptText("(Seleccione su ciudad)");

        boxUbLabel.getChildren().addAll(ciudades, message);

        gp.add(boxUbLabel, 1, 6);
        
        gp.setHgap(15);
        gp.setVgap(5);
        gp.setAlignment(Pos.CENTER);

        HBox boxBtnGen = new HBox(15);
        
        Button btnSiguiente = new Button("Siguiente");
        btnSiguiente.setStyle("-fx-text-fill: white; -fx-background-color: blue; "
                + "-fx-border-color: white; -fx-boder-width: 5;"
                + "-fx-border-radius: 0; -fx-border-insets: 0; "
                + "-fx-border-style: solid line-join bevel line-cap square;"
                + "-fx-effect: dropshadow(one-pass-box, gray, 2, 0.6, 2, 2);");
        btnSiguiente.setOnAction(e -> Auxiliar.btnChangeScene(generalStage, scene ));
        btnSiguiente.setDisable(true);

        Button btnRegistrar = new Button("Registrar");
        btnRegistrar.setStyle("-fx-text-fill: white; -fx-background-color: blue; "
                + "-fx-border-color: white; -fx-boder-width: 5;"
                + "-fx-border-radius: 0; -fx-border-insets: 0; "
                + "-fx-border-style: solid line-join bevel line-cap square;"
                + "-fx-effect: dropshadow(one-pass-box, gray, 2, 0.6, 2, 2);");
        btnRegistrar.setOnAction(e -> Auxiliar.btnRegisterClick(tfnombre,fechaNacimiento,rdb1,rdb2,cb1,
                cb2,list,ciudades,message,btnSiguiente,btnRegistrar,personasS));
        

        boxBtnGen.getChildren().addAll(btnRegistrar, btnSiguiente);
        boxBtnGen.setAlignment(Pos.CENTER_RIGHT);
        boxBtnGen.setPadding(new Insets(0,30,10,0));
        boxBtnGen.setCenterShape(true);

        vbox.getChildren().addAll(gp, boxBtnGen);
        vbox.setPadding(new Insets(10,0,0,0));
        vbox.setAlignment(Pos.CENTER);
        vbox.setCenterShape(true);
        
        return vbox;
    }
    
    
    
    private static void btnYesNoClick(boolean valor){
        value = valor;
    }
    
    
}
