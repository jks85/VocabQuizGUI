package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Insets;

// END SOLUTION
public class VocabularyPracticeApplication extends Application {


    public static void main(String[] args) {
        System.out.println("Displaying dictionary GUI");
        launch(VocabularyPracticeApplication.class);
        

    }

    @Override
    public void start(Stage window){
        // create dict 
        Dictionary appDict = new Dictionary();
       
        
        // set up views layout
        BorderPane mainView = new BorderPane();
        
        InputView inputView = new InputView(appDict);
        Parent addWordsView = inputView.getView();

        PracticeView practiceView = new PracticeView(appDict);
        Parent practiceTranslationView = practiceView.getView();
        
        HBox menu = new HBox();


        // create UI elements
        Button inputButton = new Button("Enter new words");
        Button practiceButton = new Button("Practice");
        menu.getChildren().addAll(inputButton, practiceButton);
        menu.setPadding(new Insets(0, 0, 0, 0));
        
    
        // style elements
        menu.setSpacing(10);
        mainView.setPrefSize(500, 300);

        
        // set initial window
        mainView.setTop(menu);
        mainView.setCenter(addWordsView);
        Scene scene = new Scene(mainView);
        window.setScene(scene);
        window.show();

        // display UI for adding to dictionary
        // inputButton.setOnMouseClicked((inputClickEvent) -> {
        //     mainView.setCenter(addWordsView);
        //     practiceView.resetVerificationLabel();
        // });

        inputButton.setOnAction((inputClickEvent) -> {
            mainView.setCenter(addWordsView);
            practiceView.resetVerificationLabel();
        });

        

        practiceButton.setOnMouseClicked((practiceClickEvent) -> {
            mainView.setCenter(practiceTranslationView);
        });

    }    
}
