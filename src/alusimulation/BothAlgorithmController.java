/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alusimulation;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import sun.net.www.content.image.gif;

/**
 * FXML Controller class
 *
 * @author noura
 */
public class BothAlgorithmController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private JFXButton next;
     
    @FXML
    private Pane buttonpane; 
     
    @FXML
    private JFXTextField second_num;

    @FXML
    private JFXTextField first_num;

    @FXML
    private JFXCheckBox check_step;

    @FXML
    private JFXButton start_both;
    
    @FXML
    private JFXListView<String> cycle_list;
           
    @FXML
    private JFXListView<String> steps_listview;

    
    protected List<String> Cycle_list = new ArrayList<>();
    protected List<String> Numbers_list = new ArrayList<>();

    protected ListProperty<String> listProperty = new SimpleListProperty<>();
    protected  ListProperty<String> listProperty1 = new SimpleListProperty<>() ;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }  


    public BothAlgorithmController() {
        
    }
    @FXML
    void show_flowchart(ActionEvent event) {

    }
    
    
    @FXML
    void next_step(ActionEvent event) {

    }
    
    @FXML
    void start_both(ActionEvent event) {
        int a,b; 
             if(check_step.isSelected())
                next.setVisible(true);
                      
            Both both = new Both() ;
            a =  Integer.parseInt(first_num.getText()) ;
            b=  Integer.parseInt(second_num.getText()) ;
           int result = both.multiply(a, b);
           System.out.println("\n\nResult : "+ a +" * "+ b +" = "+ result);
           Cycle_list= both.getCycleList() ; 
           Numbers_list = both.getNumberList() ;
            System.out.println(both.getNumberList().toString() ) ;
            System.out.println(both.getCycleList().toString() ) ;

            listProperty.set(FXCollections.observableArrayList(Cycle_list));
            listProperty1.set(FXCollections.observableArrayList(Numbers_list));
            
            cycle_list.itemsProperty().bind(listProperty);
            steps_listview.itemsProperty().bind(listProperty1);
            
            
    }
    
    

    

    @FXML
    void init_value(ActionEvent event) {

    }

    
    
    
            
    
}
