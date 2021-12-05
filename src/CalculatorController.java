
/**
 *  Controller class for calculator.
 *
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {
	/* FXML elements */
	@FXML
	private Button b0;

	@FXML
	private Button b1;

	@FXML
	private Button b2;

	@FXML
	private Button b3;

	@FXML
	private Button b4;

	@FXML
	private Button b5;

	@FXML
	private Button b6;

	@FXML
	private Button b7;

	@FXML
	private Button b8;

	@FXML
	private Button b9;

	@FXML
	private Button bdivision;

	@FXML
	private Button bdot;

	@FXML
	private Button bminus;

	@FXML
	private Button bmulti;

	@FXML
	private Button bplus;

	@FXML
	private Button bres;

	@FXML
	private Button bsign;

	@FXML
	private Button but_clear;

	@FXML
	private Label input;

	@FXML
	private Label show_result;

	private String cur_num;
	private char last_arithmetic;
	private float result;
	private char last_input;

	@FXML
	public void initialize() {
		clear(null);
	}

	/**
	 * Restart calculator.
	 * @param pressing clear button.
	 */
	@FXML
	void clear(ActionEvent event) {
		setCurNumber("");
		last_arithmetic = '+';
		result = 0;
		show_result.setText("");
	}
/**
 * To decimal number
 * @param pressing dot button.
 */
	@FXML
	void dot(ActionEvent event) {
		if (cur_num == "") {
			setCurNumber("0.");
		} else if (!cur_num.contains(".")) {
			setCurNumber(cur_num + ".");
		}
	}
	/**
	 * Add digit to current number.
	 * @param pressing one of numbers button button.
	 */
	@FXML
	void handleButtonAction(ActionEvent event) {
		last_input = getButtonId(event);
		if (Character.isDigit(last_input)) {
			setCurNumber(cur_num + last_input);
		}
	}
	/**
	 * Calculate the result calculator and clear current number.
	 * @param pressing = button.
	 */
	@FXML
	void res(ActionEvent event) {
		calc();
		show_result.setText(result + "");
	}
	/**
	 * Change current number sign.
	 * @param pressing +/- button.
	 */
	@FXML
	void sign(ActionEvent event) {
		if (cur_num == "" || cur_num.charAt(0) != '-')
			setCurNumber("-" + cur_num);
		else
			setCurNumber(cur_num.substring(1));
	}
	/**
	 * Calculate the last result and show it,
	 * in addition insert the arithmetic operation.
	 * @param pressing one of arithmetic operation button.
	 */
	@FXML
	void handleArithmeticAction(ActionEvent event) {
		char action = getButtonId(event);
		if (cur_num != "") {
			if (result == 0) {
				result = Float.parseFloat(cur_num);
				show_result.setText(cur_num + last_arithmetic);
			} else {
				calc();
			}
		}
		last_arithmetic = action; //save the last operation.
		setCurNumber("");
		String out = show_result.getText();
		char c = out.charAt(out.length() - 1);
		if (!Character.isDigit(c) && c != '.') {
			out = out.substring(0, out.length() - 1);
			show_result.setText(out + last_arithmetic);
		}
		last_arithmetic = action;
	}
/**
 * parse the ActionEvent
 * @param buttonPressed
 * @return the name of the button
 */
	char getButtonId(ActionEvent buttonPressed) {
		String button_details = buttonPressed.getTarget().toString();
		return button_details.charAt(button_details.length() - 2);
	}
/**
 * Calculate the result.
 * @return result
 */
	private float calc() {
		switch (last_arithmetic) {
		case '*': {
			result *= Float.parseFloat(cur_num);
			break;
		}
		case '/': {
			result /= Float.parseFloat(cur_num);
			break;
		}
		case '-': {
			result -= Float.parseFloat(cur_num);
			break;
		}
		case '+': {
			result += Float.parseFloat(cur_num);
			break;
		}
		}
		String out = result + "";
		show_result.setText(out + last_arithmetic);
		return result;
	}


/**
 * set the current number.
 * @param cur_num
 */
	public void setCurNumber(String cur_num) {
		if (cur_num == "")
			input.setText("");
		else
			input.setText(cur_num);
		this.cur_num = cur_num;
	}
	
}
