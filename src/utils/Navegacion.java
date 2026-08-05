package utils;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Navegacion {

    public static<T> T cambiarScene(Stage stage, String nuevaRutaFXML)throws IOException{

        FXMLLoader loader = new FXMLLoader(Navegacion.class.getResource(nuevaRutaFXML));
        Parent nuevaPestana = loader.load();
        Scene scene = new Scene(nuevaPestana);
        stage.setScene(scene); 
        stage.show();

        return loader.getController();

    }
    
}
