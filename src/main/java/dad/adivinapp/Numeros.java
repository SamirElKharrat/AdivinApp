package dad.adivinapp;

import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Numeros extends Application  {

	private Button botonComprobar;
	private Button botonAcabar;
	private TextField tfNumero;
	private int numeroAleatorio;
	private int intentos;
	private final int MIN = 0;
	private final int MAX = 100;



	private void Comienzo() {
		numeroAleatorio();
		intentos = 0;
	}

	private void numeroAleatorio() {
		numeroAleatorio = (int) (Math.random() * (MAX - MIN + 1) + MIN);

	}

	private void falloMayor() {
		int numero = Integer.parseInt(tfNumero.getText());
		Alert alert = new Alert(AlertType.WARNING);
		
	    alert.setTitle("AdivinApp");
		alert.setHeaderText("¡Fallo!");
		alert.setContentText("El numero es mayor que " + numero);

		alert.showAndWait();


	}
	
	private void falloMenor() {
		int numero = Integer.parseInt(tfNumero.getText());
		Alert alert = new Alert(AlertType.WARNING);
		
	    alert.setTitle("AdivinApp");
		alert.setHeaderText("¡Fallo!");
		alert.setContentText("El numero es menor que " + numero);

		alert.showAndWait();


	}

	private void acierto() {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("AdivinApp");
		alert.setHeaderText("¡Has Ganado!");
		alert.setContentText("En solo " + intentos + " intentos.");

		alert.showAndWait();
	}

	private void error() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("AdivinApp");
		alert.setHeaderText("Error");
		alert.setContentText("El número introducido no es correcto");

		alert.showAndWait();
	}
	
	private void onComprobarButton(ActionEvent e) {

		intentos++;
		try {
			int numero = Integer.parseInt(tfNumero.getText());
			if (numero < numeroAleatorio)
				falloMayor();
			else if(numero > numeroAleatorio)
				falloMenor();
			else {
				acierto();
				Comienzo();

			}

		} catch (NumberFormatException error) {
			error();
		}
		

	}
	
    private void onAcabarButton(ActionEvent a) {
    	System.exit(0);
    }
    
	@Override
	public void start(Stage primaryStage) throws Exception {
		Comienzo();

		// creamos un cuadro de texto
		tfNumero = new TextField();
		tfNumero.setPrefColumnCount(5);
		tfNumero.setPromptText("Introduce un nombre");// ponemos un texto de ayuda
		tfNumero.setMaxWidth(150);// establecemos el tamaño maximo del componente

		// creamos una etiqueta
		Label Introduccion = new Label();
		Introduccion.setText("Introduce un número del 1 al 100");

		// creamos un botón
		botonComprobar = new Button();
		botonComprobar.setText("Comprobar");
		botonComprobar.setDefaultButton(true);
		botonComprobar.setOnAction(e -> onComprobarButton(e));
		
		botonAcabar = new Button();
		botonAcabar.setText("Cerrar");
		botonAcabar.setDefaultButton(true);
		botonAcabar.setOnAction(a -> onAcabarButton(a));

		// creamos un panel con disposición vertical
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(Introduccion, tfNumero, botonComprobar, botonAcabar);

		// creamos la escena
		Scene escena = new Scene(root, 320, 200);

		// configuramos la ventana
		primaryStage.setScene(escena);
		primaryStage.setTitle("AdivinApp");
		primaryStage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}
	




}
