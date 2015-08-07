package pl.example.calculator1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	private enum Operation {
		NONE, ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION
	}

	private EditText number1;
	private EditText number2;
	private EditText result;
	private TextView operator;
	private Operation selected = Operation.NONE;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		number1 = (EditText) findViewById(R.id.number1);
		number2 = (EditText) findViewById(R.id.number2);
		result = (EditText) findViewById(R.id.result);
		operator = (TextView) findViewById(R.id.operator);
		operator.setText("Operation: " + selected);

		Button addButton = (Button) findViewById(R.id.add_button);
		Button subtractButton = (Button) findViewById(R.id.subtract_button);
		Button multiplyButton = (Button) findViewById(R.id.multiply_button);
		Button divideButton = (Button) findViewById(R.id.divide_button);
		Button equalsButton = (Button) findViewById(R.id.equals_button);
		Button clearButton = (Button) findViewById(R.id.clear_button);

		addButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				selected = Operation.ADDITION;
				operator.setText("Operation: " + selected);
			}
		});

		subtractButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				selected = Operation.SUBTRACTION;
				operator.setText("Operation: " + selected);
			}
		});

		multiplyButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				selected = Operation.MULTIPLICATION;
				operator.setText("Operation: " + selected);
			}
		});

		divideButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				selected = Operation.DIVISION;
				operator.setText("Operation: " + selected);
			}
		});

		clearButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				number1.setText("");
				number2.setText("");
				result.setText("");
				selected = Operation.NONE;
				operator.setText("Operation: " + selected);
			}
		});

		equalsButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				double num1 = Double.valueOf((number1.getText().toString()));
				double num2 = Double.valueOf((number2.getText().toString()));
				switch (selected) {
				case ADDITION:
					result.setText(Double.toString(num1 + num2));
					break;
				case SUBTRACTION:
					result.setText(Double.toString(num1 - num2));
					break;
				case MULTIPLICATION:
					result.setText(Double.toString(num1 * num2));
					break;
				case DIVISION:
					result.setText(Double.toString(num1 / num2));
					break;
				case NONE:
					break;
				}
			}
		});

	}
}
