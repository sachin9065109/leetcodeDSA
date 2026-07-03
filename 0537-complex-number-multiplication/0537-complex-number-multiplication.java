class Solution {

    public String complexNumberMultiply(String num1, String num2) {

        int[] first = parse(num1);
        int[] second = parse(num2);

        int a = first[0];
        int b = first[1];

        int c = second[0];
        int d = second[1];

        int real = a * c - b * d;
        int imaginary = a * d + b * c;

        return real + "+" + imaginary + "i";
    }

    private int[] parse(String s) {

        String[] parts = s.split("\\+");

        int real = Integer.parseInt(parts[0]);

        int imaginary = Integer.parseInt(parts[1].replace("i", ""));

        return new int[]{real, imaginary};
    }
}