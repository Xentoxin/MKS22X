package PostFixEval;
import java.util.Stack;

public class PostFix {
	public static double eval(String s) {
		String[] tokens = s.split(" ");
		Stack values = new Stack();
		for (String token : tokens) {
			if (isOp(token)) {
				values.push(apply((String) values.pop(), (String) values.pop(), token));
			} else {
				values.push(token);
			}
		}
	}
	public static boolean isOp(String op){
		if(op == "-" || op == "+" || op == "*" || op=="/" || op == "%"){
			return true;
		}
		else return false;
	}
	public static double apply(String object, String object2, String op){
		double x = 0.0;
		double a = Double.parseDouble(object);
		double b = Double.parseDouble(object2);
		if(op == "-"){
			x = a-b;
		}
		if(op == "+"){
			x =  a+b;
		}
		if(op == "/"){
			x = a/b;
		}
		if(op == "*"){
			x = a*b;
		}
		if(op == "%"){
			x = a%b;
		}
		return x;
	}
}
