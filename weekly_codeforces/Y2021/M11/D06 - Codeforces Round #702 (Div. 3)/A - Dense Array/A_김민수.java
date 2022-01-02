import java.util.ArrayList;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {

            Double l = sc.nextDouble();

            ArrayList<Double> arrayList = new ArrayList<>();

            for(int i = 0; i < l; i++)
                arrayList.add(sc.nextDouble());

            int originalLength = arrayList.size();

            for(int i = 0; i < arrayList.size() - 1;) {
                Double a = arrayList.get(i);
                Double b = arrayList.get(i+1);
                if(isDense(a, b)) {
                    i++;
                    continue;
                }
                if(a > b) {
                    arrayList.add(i+1, b * 2); // 1 2 4 9
                } else {
                    arrayList.add(i+1, a * 2);
                }

            }

            System.out.println(arrayList.size() - originalLength);
        }
    }

    static boolean isDense(Double a, Double b) {
        return Math.max(a, b) / Math.min(a, b) <= 2;
    }
}
