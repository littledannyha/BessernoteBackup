package saving;


import bessernote.ui.BScrollPane;
import bessernote.ui.BTabPane;
import bessernote.ui.BTextArea;
import bessernote.ui.BWrapPane;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import saving.BScrollPaneSave;
import saving.BTabPaneSave;
import saving.BTextAreaSave;
import saving.BWrapPaneSave;
import saving.Savable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ddliu
 */
public class PaneSave implements Savable{
        
    private double xPos, yPos;
    private double xDim, yDim;
    private double padding;
    private List<Savable> children = new ArrayList<>();
    private String color;
    
    public PaneSave(Pane pane){
        //Save this
        xPos = pane.getLayoutX();
        yPos = pane.getLayoutY();
        xDim = pane.getPrefWidth();
        yDim = pane.getPrefHeight();
        if(pane.getStyle().contains("#")){
            color = pane.getStyle().substring(pane.getStyle().indexOf("#"), pane.getStyle().length());
        }
        else{
            color = "#ffffff";
        }

        //Save children, if not empty.
        if(! pane.getChildren().isEmpty()){
            for(Node node: pane.getChildren()){
                Savable saveObj = null;
                if(node instanceof BTabPane){
                    saveObj = new BTabPaneSave((BTabPane)node);
                }
                else if(node instanceof BTextArea){
                    saveObj = new BTextAreaSave((BTextArea)node);
                }
                else if(node instanceof BScrollPane){
                    saveObj = new BScrollPaneSave((BScrollPane)node);
                }
                else if (node instanceof BWrapPane){
                    saveObj = new BWrapPaneSave((BWrapPane)node);
                }
                else if (node instanceof Pane){
                    saveObj = new PaneSave((Pane)node);
                }
                children.add(saveObj);
            }
        }
                
    }

    @Override
    public Parent create() {
       Pane returnMe = new Pane();
       returnMe.setLayoutX(xPos);
       returnMe.setLayoutY(yPos);
       returnMe.setPrefHeight(xDim);
       returnMe.setPrefWidth(yDim);
       for(Savable child: children){
           returnMe.getChildren().add(child.create());
       }
       return returnMe;
    }

    @Override
    public List<Savable> getChildren() {
        return this.getChildren();
    }
    
    
}
