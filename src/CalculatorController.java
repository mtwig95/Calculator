import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {

	@FXML
	private Button arit_division;

	@FXML
	private Button arit_minus;

	@FXML
	private Button arit_multi;

	@FXML
	private Button arit_plus;

	@FXML
	private Button bdot;

	@FXML
	private Button bres;

	@FXML
	private Button bsign;

	@FXML
	private Button clear;

	@FXML
	private Label input;

	@FXML
	private Button num_0;

	@FXML
	private Button num_1;

	@FXML
	private Button num_2;

	@FXML
	private Button num_3;

	@FXML
	private Button num_4;

	@FXML
	private Button num_5;

	@FXML
	private Button num_6;

	@FXML
	private Button num_7;

	@FXML
	private Button num_8;

	@FXML
	private Button num_9;

	@FXML
	private Label show_result;

	private String cur_num;
	private char last_arit;
	private float result=0;
	private char last_input;
	private String trash;

	@FXML
	public void initialize() {
		cur_num = "";
		last_arit = '+';
		checkResult(result,last_arit);
		result = 0;
		input.setText(cur_num);
	}

	void checkResult(Float result,char last_arit) {
		String output = "";
		if (Float.toString(result) == "Infinity") {
			output="Error";
		}
		else if(Math.round(result)==result) {
						output=Math.round(result)+"";
			output+=last_arit;

		}
		else {
			output+=result;
			output+=last_arit;
		}
		show_result.setText(output);

	}
	@FXML
	void handleButtonAction(ActionEvent event) {
		String buttonPressed = event.getSource().toString();
		last_input = buttonPressed.charAt(buttonPressed.length() - 2);
		if (Character.isDigit(last_input)) {
			cur_num += last_input;
		} else if (buttonPressed.contains("clear")) {
			result = 0;
			initialize();
		} else if (buttonPressed.contains("sign")) {
			cur_num = change_sign(cur_num);
		} else {
			switch (last_input) {
			case '.':
				if (!cur_num.contains(".")) {
					cur_num += ".";
					input.setText(cur_num);

				}
				break;
			case '=':
				result = calc(last_arit, Float.parseFloat(cur_num));
				checkResult(result, last_arit);
				cur_num="";
				break;
			default: // its aritmatic
				if (cur_num.length() != 0) {
					checkResult(calc(last_arit, Float.parseFloat(cur_num)), last_arit);
					last_arit = last_input;
					checkResult(result, last_arit);
					cur_num = "";
				}
				break;
			}
		}
		checkResult(result,last_arit);
		input.setText(cur_num);
	}

	String change_sign(String curNum) {
		if (curNum == "")
			return "-";
		if (curNum.charAt(0) == '-') {
			return curNum.substring(1);
		}
		return "-" + curNum;
	}
	
	private String findAritSign(String cur_arit) {
		switch (cur_arit) {
		case "multi": {
			return "*";
		}
		case "division": {
			return "/";
		}
		case "minus": {
			return "-";
		}
		case "plus": {
			return "+";
		}
		}
		return "";
	}

	private float calc(char last_arit, float cur_num) {
		switch (last_arit) {
		case '*': {
			return result *= cur_num;
		}
		case '/': {
			result /= cur_num;
		}
		case '-': {
			result -= cur_num;
		}
		case '+': {
			result += cur_num;
		}
		}
		return result;

	}
}