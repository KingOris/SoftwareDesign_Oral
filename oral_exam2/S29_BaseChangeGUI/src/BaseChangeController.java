
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


public class BaseChangeController {

    @FXML
    private ChoiceBox<String> desiredBase;

    @FXML
    private TextField numberInput;

    @FXML
    private ChoiceBox<String> currentBase;

    @FXML
    private TextField resultOutput;

    /**
     * The submitPressed method is working when the submit button is pressed ant to call the chageBase method then display it
     *
     * @param event the submint button pressed event
     */
    @FXML
    void submitPressed(ActionEvent event) {
        try {
            //change the user input to integer in base 10
            int num10 = Integer.parseInt(numberInput.getText(), Integer.parseInt(currentBase.getValue()));
            resultOutput.setText(changeBase(num10, Integer.parseInt(desiredBase.getValue())).toString());
        } catch (NumberFormatException ex) {
            resultOutput.setText("Please check if you use or choose all 3 input");
        }

    }

    public void initialize() {
        currentBase.getItems().addAll("2", "4", "6", "8", "10", "12", "14", "16", "18", "20", "22", "24", "26", "28", "30", "32", "3", "5", "7", "9", "11", "13", "15", "17", "19", "21", "23", "25", "27", "29", "31");
        desiredBase.getItems().addAll("2", "4", "6", "8", "10", "12", "14", "16", "18", "20", "22", "24", "26", "28", "30", "32", "3", "5", "7", "9", "11", "13", "15", "17", "19", "21", "23", "25", "27", "29", "31");
    }

    /**
     * A function to change the num in 10 base to any base the user chosen
     *
     * @param num    integer number in 10 base
     * @param toBase the base user chosen
     * @return StringBuffer which contain the result of the change
     */
    public StringBuffer changeBase(int num, int toBase) {
        StringBuffer stringBuffer = new StringBuffer();
        while (num != 0) {
            if (num % toBase > 9) {
                stringBuffer.append((char) (65 + (num % toBase - 10)));
            } else {
                stringBuffer.append(num % toBase);
            }
            num = num / toBase;
        }

        stringBuffer.reverse();

        return stringBuffer;
    }
}