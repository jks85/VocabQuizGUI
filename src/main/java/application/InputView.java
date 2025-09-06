package application;


import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;



public class InputView {
 
    private Dictionary dictionary;
    
    public InputView(Dictionary dictionary){
        this.dictionary = dictionary;

    }

    public Parent getView(){
        // create view layout
        GridPane view = new GridPane();

        
        Label wordLabel = new Label("Word");
        TextField wordField = new TextField();
        Label translationLabel = new Label("translation");
        TextField translationField = new TextField();
        Button addPairButton = new Button("Add the word pair");

        view.add(wordLabel, 0,0);
        view.add(wordField,0,1);
        view.add(translationLabel,0,2);
        view.add(translationField, 0, 3);
        view.add(addPairButton,0,4);


        // pass text inputs to dictionary on button click
        addPairButton.setOnMouseClicked((event) -> {

            String word = wordField.getText();
            String translation = translationField.getText();

            this.dictionary.addPair(word,translation);

            wordField.clear();
            translationField.clear();
        });

        // style view
        view.setVgap(10);
        view.setHgap(10);
        view.setAlignment(Pos.CENTER);
 

        return view;

        }


}
