/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alusimulation;

import com.jfoenix.controls.*;
import java.awt.Label;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author noura
 */
public class RestoringController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private JFXButton show_flowchart;

     @FXML
    private JFXButton next;
     
    @FXML
    private JFXListView<String> num_listview;

    @FXML
    private JFXCheckBox chk_res_step;

    @FXML
    private JFXButton start;

    @FXML
    private JFXListView<String> cycle_listview;

    @FXML
    private JFXTextField res_num2;

    @FXML
    private JFXTextField res_num1;
    
    protected List<String> Cycle_list = new ArrayList<>();
    protected List<String> Numbers_list = new ArrayList<>();

    protected ListProperty<String> listProperty = new SimpleListProperty<>();
    protected  ListProperty<String> listProperty1 = new SimpleListProperty<>() ;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    @FXML
    void ffc40d(ActionEvent event) {

    }
    

    @FXML
    void start(ActionEvent event) {
            int a,b; 
             if(chk_res_step.isSelected())
                next.setVisible(true);
                      
            Restoring restoring= new Restoring() ;
            a =  Integer.parseInt(res_num1.getText()) ;
            b=  Integer.parseInt(res_num2.getText()) ;
           int result = restoring.division(a, b);
           
           
           Cycle_list= restoring.getCycleList() ; 
            Numbers_list = restoring.getNumberList() ;
            
            
            listProperty.set(FXCollections.observableArrayList(Cycle_list));
            listProperty1.set(FXCollections.observableArrayList(Numbers_list));
            cycle_listview.setVisible(true);
            num_listview.setVisible(true);
            cycle_listview.itemsProperty().bind(listProperty);
            num_listview.itemsProperty().bind(listProperty1); 
    }
    
    
    

    

}
