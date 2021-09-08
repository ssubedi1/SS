package checkParenthesis;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Brackets {
	
	static boolean areBracketBalanced(String input) {
		
		Deque<Character> stack = new ArrayDeque<Character>();
		//looping through each character at a time
		for (int i=0; i<input.length();i++) {
			
			char x=  input.charAt(i);
			

			//checking the opening brackets and if so, pushing it in the stack		 
			
			if (x=='{' || x== '[' || x=='(' ) 
			{
				stack.push(x);
				continue;
			}
			
			//
			if (stack.isEmpty())
				return false;
			char check;
			
			//as soon as we encounter closing brackets, we check the first item in the stack 
			//and if they are not like pairs, return false
			switch(x) {
			case ')':
				check = stack.pop();
				if(check == '{' || check == '[')
					return false;
				break;
			
			case '}':
				check = stack.pop();
				if(check == '(' || check == '[')
					return false;
				break;
			
			case ']':
				check = stack.pop();
				if(check == '{' || check == '(')
					return false;
				break;
			
			}
			
			
		}
		// finally, check for the empty stack
		return (stack.isEmpty());
		
		
	}

	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter a bracket you want to check: ");
		String str = sc.nextLine();		
		if (areBracketBalanced(str))
			System.out.println("Balanced");
		else
			System.out.println("Not Balanced");

        }
	}
	


