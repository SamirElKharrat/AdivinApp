package dad.adivinapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Numeros {
	
	private Button botonComprobar;
	private TextField tfNumero;
	private int numeroAleatorio;
	private int intentos;
	private final int MIN = 0;
	private final int MAX = 100;

}


private void Comienzo() {
	ComienzoPartida();
	intentos = 0;
}


private void numeroAleatorio() {
	numeroAleatorio = (int) (Math.random() * (MAX - MIN + 1) + MIN);
	
}