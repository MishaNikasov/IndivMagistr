package donnu.nikasov.indivmagistr;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MathFunction object;
    TextView textValue;
    TextView textResult;
    Button buttonSin, buttonCos, buttonLn, buttonTg,
            buttonCtg, buttonExp, buttonPlus, buttonMinus, buttonMult, buttonDiv, buttonConst, buttonPol, buttonA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textValue = (TextView) findViewById(R.id.textValue);
        textResult = (TextView) findViewById(R.id.textResult);

        buttonSin = (Button) findViewById(R.id.buttonSin);
        buttonCos = (Button) findViewById(R.id.buttonCos);
        buttonLn = (Button) findViewById(R.id.buttonLn);
        buttonTg = (Button) findViewById(R.id.buttonTg);
        buttonCtg = (Button) findViewById(R.id.buttonCtg);
        buttonExp = (Button) findViewById(R.id.buttonExp);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonMult = (Button) findViewById(R.id.buttonMult);
        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonConst = (Button) findViewById(R.id.buttonConst);
        buttonPol = (Button) findViewById(R.id.buttonPol);
        buttonA = (Button) findViewById(R.id.buttonA);

        buttonSin.setOnClickListener(this);
        buttonCos.setOnClickListener(this);
        buttonLn.setOnClickListener(this);
        buttonTg.setOnClickListener(this);
        buttonCtg.setOnClickListener(this);
        buttonExp.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMult.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonConst.setOnClickListener(this);
        buttonPol.setOnClickListener(this);
        buttonA.setOnClickListener(this);

        textValue.setOnClickListener(this);

        object = new MathFunction(10);

        textValue.setText("Переменная: " + String.valueOf(object.getValue()));
        textResult.setText("Жми кнопки");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonSin:
                object.findSin();
                break;
            case R.id.buttonCos:
                object.findCos();
                break;
            case R.id.buttonLn:
                object.findLn();
                break;
            case R.id.buttonTg:
                object.findTg();
                break;
            case R.id.buttonCtg:
                object.findCtg();
                break;
            case R.id.buttonExp:
                object.findExp();
                break;
            case R.id.buttonConst:
                object.findConst();
                break;
            case R.id.buttonPol:
                object.findPolynomial();
                break;
            case R.id.buttonA:
                object.findA();
                break;
            case R.id.buttonPlus:
                runDialog("+");
                break;
            case R.id.buttonMinus:
                runDialog("-");
                break;
            case R.id.buttonMult:
                runDialog("*");
                break;
            case R.id.buttonDiv:
                runDialog("/");
                break;
            case R.id.textValue:
                runDialog("new");
        }
//        Toast.makeText(getApplicationContext(), "OPA", Toast.LENGTH_SHORT).show();
        if (!object.getSStringResult().equals("")){
            textResult.setText(object.toString());
        }
    }

    public void runDialog(final String a){

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final EditText edittext = new EditText(getApplicationContext());
        edittext.setTextColor(Color.parseColor("#0d0d0d"));
        edittext.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_NUMBER);

//        alert.setMessage("Enter Your Message");
        alert.setTitle("Введите значение");

        alert.setView(edittext);

        alert.setPositiveButton("Да, пойдет", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                try {
                    if (Objects.equals(a, "+")) {
                        object.findPlus(Double.valueOf(edittext.getText().toString()));
                    }
                    if (Objects.equals(a, "-")) {
                        object.findMinus(Double.valueOf(edittext.getText().toString()));
                    }
                    if (Objects.equals(a, "*")) {
                        object.findMulti(Double.valueOf(edittext.getText().toString()));
                    }
                    if (Objects.equals(a, "/")) {
                        object.finDivision(Double.valueOf(edittext.getText().toString()));
                    }
                    if (Objects.equals(a, "new")){
                        object = new MathFunction(Double.valueOf(edittext.getText().toString()));
                        textValue.setText("Переменная: " + String.valueOf(object.getValue()));
                        textResult.setText("Жми кнопки");
                    }
                    textResult.setText(object.toString());
                    }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Так не пойдет", Toast.LENGTH_SHORT).show();
                }

            }
        });

        alert.setNegativeButton("Не, передумал", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });

        alert.show();
    }
}
