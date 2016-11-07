package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controlador {
	@FXML
	TextField min;
	public void manejaBoton(ActionEvent evt) {
		System.out.println(min.getText());
	}
	
	public void manejaBoton2(ActionEvent evt) {
		System.out.println("¡Segundo botón pulsado!");
	}

}