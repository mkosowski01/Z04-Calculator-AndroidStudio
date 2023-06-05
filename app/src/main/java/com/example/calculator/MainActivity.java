package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    private EditText calculation, result;
    private String currentExpression;

    private void clear() {
        calculation.setText("");
        result.setText("");
    }

    private void setValue(String value) {
        currentExpression = calculation.getText().toString();
        currentExpression += value;
        calculation.setText(currentExpression);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculation = findViewById(R.id.expression);
        result = findViewById(R.id.result);

        Button numButton = findViewById(R.id.numButton);
        Button divideButton = findViewById(R.id.divideButton);
        Button multiplyButton = findViewById(R.id.multiplyButton);
        Button minusButton = findViewById(R.id.minusButton);
        Button sevenButton = findViewById(R.id.sevenButton);
        Button eightButton = findViewById(R.id.eightButton);
        Button nineButton = findViewById(R.id.nineButton);
        Button plusButton = findViewById(R.id.plusButton);
        Button fourButton = findViewById(R.id.fourButton);
        Button fiveButton = findViewById(R.id.fiveButton);
        Button sixButton = findViewById(R.id.sixButton);
        Button oneButton = findViewById(R.id.oneButton);
        Button twoButton = findViewById(R.id.twoButton);
        Button threeButton = findViewById(R.id.threeButton);
        Button enterButton = findViewById(R.id.enterButton);
        Button zeroButton = findViewById(R.id.zeroButton);
        Button dotButton = findViewById(R.id.dotButton6);


        numButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!result.getText().toString().isEmpty()) {
                    calculation.setText(result.getText().toString());
                    result.setText("");
                }
                setValue("^");
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!result.getText().toString().isEmpty()) {
                    calculation.setText(result.getText().toString());
                    result.setText("");
                }
                setValue("/");
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!result.getText().toString().isEmpty()) {
                    calculation.setText(result.getText().toString());
                    result.setText("");
                }
                setValue("*");
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!result.getText().toString().isEmpty()) {
                    calculation.setText(result.getText().toString());
                    result.setText("");
                }
                setValue("-");
            }
        });

        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression = calculation.getText().toString();
                if (!result.getText().toString().isEmpty()) {
                    clear();
                }
                setValue("7");
            }
        });

        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression = calculation.getText().toString();
                if (!result.getText().toString().isEmpty()) {
                    clear();
                }
                setValue("8");
            }
        });

        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression = calculation.getText().toString();
                if (!result.getText().toString().isEmpty()) {
                    clear();
                }
                setValue("9");
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!result.getText().toString().isEmpty()) {
                    calculation.setText(result.getText().toString());
                    result.setText("");
                }
                setValue("+");
            }
        });

        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression = calculation.getText().toString();
                if (!result.getText().toString().isEmpty()) {
                    clear();
                }
                setValue("4");
            }
        });

        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression = calculation.getText().toString();
                if (!result.getText().toString().isEmpty()) {
                    clear();
                }
                setValue("5");
            }
        });

        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression = calculation.getText().toString();
                if (!result.getText().toString().isEmpty()) {
                    clear();
                }
                setValue("6");
            }
        });

        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression = calculation.getText().toString();
                if (!result.getText().toString().isEmpty()) {
                    clear();
                }
                setValue("1");
            }
        });

        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression = calculation.getText().toString();
                if (!result.getText().toString().isEmpty()) {
                    clear();
                }
                setValue("2");
            }
        });

        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression = calculation.getText().toString();
                if (!result.getText().toString().isEmpty()) {
                    clear();
                }
                setValue("3");
            }
        });

        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression = calculation.getText().toString();
                if (!result.getText().toString().isEmpty()) {
                    clear();
                }
                setValue("0");
            }
        });

        dotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression = calculation.getText().toString();
                currentExpression += ".";
                calculation.setText(currentExpression);
            }
        });
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialButton button = (MaterialButton) view;
                String buttonText = button.getText().toString();
                String dataToCalculate = calculation.getText().toString();

                calculation.setText(dataToCalculate);

                String finalResult = getResult(dataToCalculate);

                if (!finalResult.equals("Error")) {
                    result.setText(finalResult);
                }

            }

            String getResult(String data) {
                try {
                    Context context = Context.enter();
                    context.setOptimizationLevel(-1);
                    Scriptable scriptable = context.initStandardObjects();

                    if (data.contains("^")) {
                        String[] parts = data.split("\\^");
                        double base = Double.parseDouble(parts[0]);
                        double exponent = Double.parseDouble(parts[1]);
                        double result = Math.pow(base, exponent);

                        return String.valueOf(result);
                    } else {
                        String finalResult = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
                        if (finalResult.endsWith(".0")) {
                            finalResult = finalResult.replace(".0", "");
                        }

                        return finalResult;
                    }
                } catch (Exception e) {
                    return "Error";
                }
            }
        });
    }
}