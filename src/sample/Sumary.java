package sample;

import carParts.Parts;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;



public class Sumary extends Pane {
    Label workLAbel,paintingLabel,partLabel;
    int y;
    Sumary(){
        this(300,400);
    }

    Sumary(int x,int y){
        super();
        this.y=50;
        workLAbel=new Label("Robocizna");
        paintingLabel=new Label("lakier");
        partLabel=new Label("Części");
        setMinSize(x,y);
        setWidth(500);
        setHeight(800);
        paintingLabel.setLayoutX(150);
        partLabel.setLayoutX(250);
        getChildren().addAll(workLAbel,paintingLabel,partLabel);
    }

    public void addPart (Parts part,String name){

        Label label=new Label(Float.toString(part.getWorkPrice())+" zł");
        label.setLayoutY(y);
        getChildren().add(label);
        label=new Label(Float.toString((Float)part.getPainting())+" zł");
        label.setLayoutY(y);
        label.setLayoutX(150);
        getChildren().add(label);
        label=new Label(Float.toString(part.getPartPrice())+" zł");
        label.setLayoutY(y);
        label.setLayoutX(250);
        getChildren().add(label);

        label=new Label(name);
        label.setLayoutY(y);
        label.setLayoutX(350);
        getChildren().add(label);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if(y>=getHeight()){
            setHeight(this.y+400);
        }
        this.y = y;
    }
}
