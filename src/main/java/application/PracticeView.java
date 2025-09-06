package application;


import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;




public class PracticeView {
    
    private Dictionary dictionary;
    private String practiceWord;
    private Label verificationLabel;

    public PracticeView(Dictionary dictionary){
        this.dictionary = dictionary;
        this.practiceWord = this.dictionary.getRandWord();
        this.verificationLabel = new Label("");
    }

    public Parent getView(){
        // create view and elements
        GridPane view = new GridPane();

        Label instructionsLabel = new Label("Translate the word: " + this.practiceWord);
        TextField translationField = new TextField();
        Button checkAnswerButton = new Button("Check Answer");
        // Label verificationLabel = new Label("");

        view.add(instructionsLabel,0,0);
        view.add(translationField,0,1);
        view.add(checkAnswerButton,0,2);
        // view.add(verificationLabel,0,3);
        view.add(this.verificationLabel,0,3);


        // style view
        view.setVgap(10);
        view.setAlignment(Pos.CENTER);

        // verify translation on "check" click
        checkAnswerButton.setOnMouseClicked((event) -> {
            String userTranslation = translationField.getText().toLowerCase();
            String correctTranslation = this.dictionary.get(this.practiceWord);
            if (userTranslation.equals(correctTranslation)){
                // verificationLabel.setText("Correct!");
                this.verificationLabel.setText("Correct!");
            } else{
                // verificationLabel.setText("Sorry, the correct translation of  \"" + 
                // this.practiceWord + "\" is \"" + correctTranslation +"\".");

                this.verificationLabel.setText("Sorry, the correct translation of  \"" + 
                this.practiceWord + "\" is \"" + correctTranslation +"\".");
            }

            // reset translation view
            translationField.clear();
            this.practiceWord = this.dictionary.getRandWord();
            instructionsLabel.setText("Translate the word: " + this.practiceWord);

        });

        return view;
    }

    public void resetVerificationLabel(){
        this.verificationLabel.setText("");
    }
}
