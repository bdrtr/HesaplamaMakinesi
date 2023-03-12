package com.example.hesaplamamakinesi;

import android.content.Context;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Stack;

public class Node {

    private String val;
    private Node left = null;
    private Node right = null;

    Node(String num) {
        this.val = num;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public String getValue() {
        return this.val;
    }

    public static double Result(Node root) {
        if (root.val == null)
            return 0;


        else if (root.getLeft() == null && root.getRight() == null) {
            return Double.parseDouble(root.getValue());
        }


        double leftValue = Result(root.left);
        double rightValue = Result(root.right);

        if (root.getValue().equals("+"))
            return leftValue + rightValue;
        else if (root.getValue().equals("-"))
            return leftValue-rightValue;
        else if (root.getValue().equals("*"))
            return leftValue*rightValue;
        else if (root.getValue().equals("/")) {
            if (rightValue == 0)
                return -1;
            return leftValue / rightValue;
        }
        else
            return 0;
    }

    public static Node build_tree(String ifade) {

        Stack<Character> operators = new Stack<>();
        Stack<Node> nodes = new Stack<>();

        for (int i=0; i<ifade.length();i++) {
            char ch = ifade.charAt(i);

            if (ch >= '0' && ch <= '9') {
                String num="";
                while (i<ifade.length() && (ifade.charAt(i) <= '9' && ifade.charAt(i) >= '0' || ifade.charAt(i) == '.')) {
                    num+=ifade.charAt(i);
                    i++;
                }
                i--;

                //System.out.println("nmara: "+num);
                Node node = new Node(num);
                nodes.push(node);
            }

            else if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                while (precedence(ch, operators)) {
                    Node right = nodes.pop();
                    Node left = nodes.pop();
                    String operator = operators.pop().toString();
                    Node node = new  Node(operator);
                    node.setLeft(left);
                    node.setRight(right);
                    nodes.push(node);
                }

                operators.push(ch);
            }

            else if (ch == '(')
                operators.push(ch);

            else if (ch == ')') {
                while (operators.peek() != '(') {
                    Node right = nodes.pop();
                    Node left = nodes.pop();
                    String operator = operators.pop().toString();
                    Node node = new Node(operator);
                    node.setLeft(left);
                    node.setRight(right);
                    nodes.push(node);
                }

                operators.pop();
            }


        }

        while (!operators.isEmpty()) {
            Node right = nodes.pop();
            Node left = nodes.pop();
            String operator = operators.pop().toString();
            Node node = new Node(operator);
            node.setLeft(left);
            node.setRight(right);
            nodes.push(node);
        }

        return nodes.pop();
    }

    public static boolean precedence(char ch, Stack op) {


        HashMap<Character, Integer> dic = new HashMap<>();
        dic.put('+', 1);
        dic.put('-', 1);
        dic.put('/', 2);
        dic.put('*', 2);

        if (!op.isEmpty() && dic.containsKey(op.peek()) && dic.containsKey(ch) && (dic.get(op.peek()) >= dic.get(ch))) {
            return true;
        }

        return false;

    }
}
