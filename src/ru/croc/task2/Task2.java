package task2;

public class Task2 {
	public static void main(String[] args) {
		int a1 = Integer.parseInt(args[0]);
		int d = Integer.parseInt(args[1]);
		int n= Integer.parseInt(args[2]);
		int s= 0;
        for (int i = 0; i < n; i++)
        {
            s = s+ a1;
            a1 = a1 + d;
        }
        System.out.println(s);
	}
}
