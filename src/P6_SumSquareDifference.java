public class P6_SumSquareDifference {

    public static void main(String[] args) {

        int erste = 0;
        int zwei = 0;

        for (int i = 1; i < 101; i++) {
            int b = i;
            b *= b;
            erste += b;
        }
        for (int i = 1; i < 101; i++) {
            zwei += i;
        }
        zwei *= zwei;
        System.out.println(zwei - erste + "///" + erste + "/// " + zwei);


        int i, sum0 = 0, sum1 = 0, sum2, dif;
        for (i = 1; i <= 100; i++) {
            sum0 = sum0 + i * i;
            sum1 = sum1 + i;
        }
        sum2 = sum1 * sum1;
        dif = sum2 - sum0;
        System.out.println(dif);
    }

}


// 25164150///338350/// 25502500
