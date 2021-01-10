/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author CORE I7
 */
public abstract class AbstractScene {
    
    protected Scene generalScene;
    protected static Stage generalStage;
    
    public AbstractScene(Pane root,int height,int width){
        
        generalScene = new Scene(root,height,width);
    }

    public Scene getGeneralScene() {
        return generalScene;
    }

    public void setGeneralScene(Scene generalScene) {
        this.generalScene = generalScene;
    }
    

    public static Stage getGeneralStage() {
        return generalStage;
    }

    public static void setGeneralStage(Stage generalStage) {
        AbstractScene.generalStage = generalStage;
    }
    
    
    
    
}
