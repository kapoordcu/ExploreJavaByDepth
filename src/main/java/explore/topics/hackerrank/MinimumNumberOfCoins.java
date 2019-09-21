package explore.topics.hackerrank;


/*

Tasks 3

Most european countries do use the EURO as their currency. It has bills for 500€, 200€, 100€, 50€, 20€, 10€ & 5€ as well coins for 2€, 1€, 50ct, 20ct, 10ct, 5ct, 2ct, 1ct across the countries.

Your should write a program / function which generates the minimal numbers of bills & coins while inputting any money amount, e.g. https://rechneronline.de/geld/ (german only)

Examples:
52.54€ ⇒ 1x 50€ + 1x 2€ + 1x 50c + 2x 2ct
99ct  => 1x 50ct + 2x 20ct + 1x 5ct + 2x 2ct


 */
public class MinimumNumberOfCoins {
    int[] euros = {500, 200, 100, 50, 20, 10 , 5, 2, 1};
    public static void main(String[] args) {
        MinimumNumberOfCoins minimumNumberOfCoins = new MinimumNumberOfCoins();
        System.out.println(minimumNumberOfCoins.minimumBills(101.23));

    }

    public int minimumBills(Double amount) {
        int[] euros = {500, 200, 100, 50, 20, 10 , 5, 2, 1};
        int[] cents = {50, 20, 10, 5, 2, 1};
        String amountValue = Double.toString(amount);
        String[] amountArray = amountValue.split("\\.");

        int amountEuros = Integer.parseInt(amountArray[0]);
        int amountCents = Integer.parseInt(amountArray[1]);
        int totalEurosCount = (amountEuros==0) ? 0 : getDenominationCount(amountEuros, euros);
        int totalCentsCount= (amountCents==0) ? 0 : getDenominationCount(amountCents, cents);

        return totalEurosCount+totalCentsCount;

    }

    private int getDenominationCount(int amountEuros, int[] denominationArray) {
        if(amountEuros==0){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < denominationArray.length; i++) {
            int divisor = amountEuros / denominationArray[i];
            if(divisor!=0) {
                int sub_res = getDenominationCount(amountEuros%denominationArray[i], denominationArray);
                if (sub_res < res) {
                    return sub_res + divisor;
                }
            }
        }

        return res;
    }
}
