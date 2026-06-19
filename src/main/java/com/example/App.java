package com.example;

import java.io.IOException;

import com.example.model.Bebida;
import com.example.model.Comida;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 540, 760);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        Comida frangoP = new Comida("Frango Pequeno", 29.9,"Serve uma criança", 650,250);
        Comida frangoM = new Comida("Frango Medio", 49.9,"Serve um adulto", 400,900);
        Comida frangoG = new Comida("Frango Grande", 69.9,"Serve dois adulto", 1400, 600);
        Comida frangoGG = new Comida("Frango Familia", 99.9,"Serve 3 adultos", 2000,900);

        Bebida CocaColaLata = new Bebida("Coca Cola Lata", 8.0,"Canudo incluso", 350, false);
        Bebida CocaCola = new Bebida("Coca Cola", 16.0,"Serve 2 pessoas", 3000, false);
        Bebida Cerveja = new Bebida("Heineken", 12.0,"Long neck", 370, true);
        
        launch();
    }

}