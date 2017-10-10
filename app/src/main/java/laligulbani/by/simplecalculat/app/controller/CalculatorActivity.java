package laligulbani.by.simplecalculat.app.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import laligulbani.by.simplecalculat.R;
import laligulbani.by.simplecalculat.domain.calculator.CalculatorManagement;
import laligulbani.by.simplecalculat.domain.calculator.CalculatorManager;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etNum1;
    private EditText etNum2;

    private TextView tvResult;

    private CalculatorManagement calculatorManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        calculatorManager = new CalculatorManager();

        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        Button btnSub = (Button) findViewById(R.id.btnSub);
        Button btnMult = (Button) findViewById(R.id.btnMult);
        Button btnDiv = (Button) findViewById(R.id.btnDiv);

        tvResult = (TextView) findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
    }

   // public void setCalculatorManager(CalculatorManagement calculatorManager) {
    //    this.calculatorManager = calculatorManager;
    //}

    @Override
    public void onClick(View v) {
        float num1;
        float num2;

        if (TextUtils.isEmpty(etNum1.getText().toString())
                || TextUtils.isEmpty(etNum2.getText().toString())) {
            return;
        }

        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());

        switch (v.getId()) {
            case R.id.btnAdd:
                tvResult.setText(calculatorManager.add(num1, num2).toString());
                break;
            case R.id.btnSub:
                tvResult.setText(calculatorManager.subtract(num1, num2).toString());
                break;
            case R.id.btnMult:
                tvResult.setText(calculatorManager.multiply(num1, num2).toString());
                break;
            case R.id.btnDiv: {
                if (num2 == 0f) {
                    tvResult.setText("Nononono! 0 - ochen' ploho. ");
                    break;
                }
                tvResult.setText(calculatorManager.divide(num1, num2).toString());
            }
            break;
            default:
                break;
        }
    }

    public void setCalculatorManager(CalculatorManagement calculatorManager) {
        this.calculatorManager = calculatorManager;

    }
}

