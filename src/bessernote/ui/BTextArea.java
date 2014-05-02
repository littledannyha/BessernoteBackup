/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bessernote.ui;

import bessernote.ChildSpecifier;
import java.util.ArrayList;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author Dan
 */
public class BTextArea  extends Pane implements ChildSpecifier {
        
    public BTextArea(){
        this("");
        this.setStyle("-fx-background-color: red");

    }
    
    public BTextArea(String s){
//        super(s);
        this.getChildren().add(new TextArea("This is a new text area"));
    }
    
    @Override
    public List<Node> specifyChildren() {
        return new ArrayList<Node>();
    }

    @Override
    public Node specifySelf() {
        return this;
    }
    
}
