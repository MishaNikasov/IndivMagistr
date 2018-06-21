package donnu.nikasov.indivmagistr;

import java.text.DecimalFormat;

/**
 * Created by Миша on 04.06.2018.
 */

public class MathFunction {

    double value;
    double result;

    String stringResult = "";
    String stringDerivative = "";

    public MathFunction(double value) {
        this.value = value;}

    public void findSin(){
        stringDerivative = getDerivativeStringResult(Math.cos(value));
        result = Math.sin(value);
        stringResult = "sin(" + value + ") = " + getStringResult();}

    public void findCos(){
        stringDerivative = getDerivativeStringResult(Math.sin(value)*(-1));
        result = Math.cos(value);
        stringResult = "cos(" + value + ") = " + getStringResult();}

    public void findLn(){
        stringDerivative = getDerivativeStringResult(1/value);
        result = Math.log(value);
        stringResult = "ln(" + value + ") = " + getStringResult();}

    public void findTg(){
        stringDerivative = getDerivativeStringResult(Math.pow(Math.cos(value),2));
        result = Math.tan(value);
        stringResult = "tg(" + value + ") = " + getStringResult();}

    public void findCtg(){
        stringDerivative = getDerivativeStringResult(Math.pow(Math.sin(value),2)*(-1));
        result = 1.0 / Math.tan(value);
        stringResult = "ctg(" + value + ") = " + getStringResult();}

    public void findExp(){
        result = Math.exp(value);
        stringResult = "exp(" + value + ") = " + getStringResult();
        stringDerivative = getDerivativeStringResult(Math.exp(value));}

    public void findConst(){
        result = value;
        stringResult = "const(" + value + ") = " + getStringResult();
        stringDerivative = "0";}

    public void findPlus(double a){
        result = value + a;
        stringResult = String.valueOf(value) + " + " + String.valueOf(a) + " = " + getStringResult();
        stringDerivative = "0";}

    public void findMinus(double a){
        result = value - a;
        stringResult = String.valueOf(value) + " - " + String.valueOf(a) + " = " + getStringResult();
        stringDerivative = "0";}

    public void findMulti(double a){
        result = value * a;
        stringResult = String.valueOf(value) + " * " + String.valueOf(a) + " = " + getStringResult();
        stringDerivative = "0";}

    public void finDivision(double a){
        result = value / a;
        stringResult = String.valueOf(value) + " / " + String.valueOf(a) + " = " + getStringResult();
        stringDerivative = "0";}

    public void findA(){}
    public void findPolynomial(){}

    public String getStringResult(){
        return new DecimalFormat("#0.000").format(result);
    }
    public String getDerivativeStringResult(double a){
        return new DecimalFormat("#0.000").format(a);
    }

    public double getValue() {
        return value;}

    public String getSStringResult() {
        return stringResult;
    }

    @Override
    public String toString() {
        return stringResult + "\nПроизводная = " + stringDerivative;}

}
