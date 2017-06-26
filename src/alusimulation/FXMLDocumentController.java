/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alusimulation;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author noura
 */
public class FXMLDocumentController implements Initializable {
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            
    }    
    @FXML
    private JFXButton both;
    
      @FXML
    void both(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BothAlgorithm.fxml"));
               
        Scene scene = new Scene(root);
        Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);

             stage.initStyle(StageStyle.UNIFIED);
            stage.setTitle("Both Algorithm");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
    }
    
}
