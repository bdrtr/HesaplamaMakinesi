package com.example.hesaplamamakinesi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hesaplamamakinesi.databinding.ActivityMainBinding;

import java.security.PublicKey;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding design;
    private  String experision="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        design = DataBindingUtil.setContentView(this,R.layout.activity_main);
        design.setMainAct(this);
    }

    public void experisionAdd(char exp) {
        experision = experision.concat(Character.toString(exp));
        update();
    }

    public void experisionClear() {
        experision = "";
        update();
    }

    public void Delete() {
        experision = experision.substring(0,experision.length()-1);
        update();
    }

    void update() {
        design.textView.setTextSize((float) 1.2);
        design.textView.setText(experision);
    }

    public void Result() {
        Node exp = Node.build_tree(experision);
        double result = Node.Result(exp);
        if (result == -1) {
            experision = experision.concat("\n 0'a bölünme bir hatadır ");
            result = 0.0;
        }

        experision = experision.concat("\n"+result);
        update();
    }
}

     //karmaşık işlemlerde sapıtan ilk denemem
	/*
	static double evulateExp(String expr) {

		Stack<Double> operandStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();

		for (int i=0;i<expr.length();i++) {
			char ch = expr.charAt(i);
			if (ch == ' ') {
				continue;

			} else if (ch>='0' && ch<='9') {
				String strnum="";
				while (i < expr.length() && (expr.charAt(i)>='0' && expr.charAt(i)<='9' || expr.charAt(i) == '.')) {
					strnum+=expr.charAt(i);
					i++;
				}

				i--;
				operandStack.push(Double.parseDouble(strnum));
			} else if (ch == '(') {
				operatorStack.push(ch);
			} else if (ch == ')') {
				while (operatorStack.peek() != '(') {
					double result = applyOperator(operandStack.pop(),operandStack.pop(),operatorStack.pop());
					operandStack.push(result);
				}
				operatorStack.pop();
			} else if (ch == '+' || ch == '-' || ch == '*' || ch=='/') {


				while (!operatorStack.isEmpty() && expr.charAt(i+1) != '(' && expr.charAt(i+1)<'0' &&
						expr.charAt(i+1) > '9'  && hasPresedence(ch, operatorStack.peek())) {

					double result = applyOperator(operandStack.pop(), operandStack.pop(),operatorStack.pop());
					operandStack.push(result);
				}
				operatorStack.push(ch);
			}
		}

		while (!operatorStack.isEmpty()) {
			double result = applyOperator(operandStack.pop(), operandStack.pop(), operatorStack.pop());
			operandStack.push(result);
		}

		return operandStack.pop();

	}

	public static boolean hasPresedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')') {
			return false;
		}

		if ((op2 == '*' || op2 == '/') && (op1 == '+' || op1 == '-'))
			return false;

		return true;

	}

	public static double applyOperator(double num1, double num2, char op) {
		switch (op) {
		case '+':
			return num1+num2;
		case '-':
			return num2-num1;
		case '*':
			return num1*num2;
		case '/':
			if (num2==0)
				throw new ArithmeticException("Sıfıra bölme hatası!");
			return num2/num1;
		default:
			throw new ArithmeticException("num1: "+num1+" num2: "+num2+" op: "+op);
		}
	}
	*/