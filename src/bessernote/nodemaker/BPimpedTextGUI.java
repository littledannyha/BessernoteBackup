/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bessernote.nodemaker;

import bessernote.nodemaker.placement.PlacementGUIRegion;
import bessernote.ui.BPimpedTextArea;
import bessernote.ui.BTextArea;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.text.Text;

/**
 *
 * @author Dan
 */
public class BPimpedTextGUI extends BaseGUI{
    
    PlacementGUIRegion placement;
    ColorPicker cp;

    public BPimpedTextGUI (Node top, double spacing) {
        super(top, spacing);

        Text t = new Text("--- TextArea GUI ---");
        
        Text t2 = new Text("Background Color:");
        cp = new ColorPicker();

        placement = new PlacementGUIRegion(top, spacing);
         
        

        getChildren().addAll(t, placement, t2, cp);
    }

    @Override
    public Node getNode() {
//        Pane pane = new Pane();
//        pane.setStyle("-fx-background-color: #"+cp.getValue().toString().substring(2) +";");
//        pane.setPrefSize(100, 100);
//        return pane;
        BPimpedTextArea  b = new BPimpedTextArea();

//        t.addEventFilter(MouseEvent.MOUSE_PRESSED, 
//            new EventHandler<MouseEvent>() {
//                @Override
//                public void handle(MouseEvent e) {
//                    System.out.println("click");
//                    t.requestFocus();
//                };
//            }
//        );
        return b;
    }
        
    @Override
    public void editNode(Node n) {
        placement.editNode(n);
        //System.out.println("-fx-background-color: #" +cp.getValue().toString().substring(2, cp.getValue().toString().length()-2));
        ((BPimpedTextArea) n).setStyle("-fx-background-color: #" +cp.getValue().toString().substring(2, cp.getValue().toString().length()-2));
        //System.out.println(n.getStyle());
              
    }
    
    @Override
    public void setPos(double x, double y) {
        placement.setPos(x, y);
    }
    
    @Override
    public void setSize(double x, double y) {
        placement.setSize(x, y);
    }
}
