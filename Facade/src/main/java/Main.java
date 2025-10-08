public class Main {
    public static void main(String[] args) {
        ApiFacade apiFacade = new ApiFacade();

        // Example with Chuck Norris API
        try {
            String joke = apiFacade.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value");
            System.out.println("Chuck Norris Joke: " + joke);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Example with another API
        try {
            String exchangeRate = apiFacade.getAttributeValueFromJson("https://api.exchangerate-api.com/v4/latest/USD", "rates");
            System.out.println("Exchange Rates: " + exchangeRate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}