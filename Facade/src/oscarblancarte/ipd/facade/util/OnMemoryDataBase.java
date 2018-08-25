package oscarblancarte.ipd.facade.util;

import java.util.HashMap;

/**
 * @author Oscar Javier Blancarte Iturralde.
 * @see http://oscarblancarteblog.com
 */
public class OnMemoryDataBase {

    private static final HashMap<Long, Customer> CUSTOMER_MAP = new HashMap<>();
    private static final HashMap<String, Card> CARD_BINS = new HashMap<>();

    static {
        CUSTOMER_MAP.put(1L, new Customer(1L, "Oscar Blancarte", 500, "Discontinued"));
        CUSTOMER_MAP.put(2L, new Customer(2L, "Juan Perez", 300, "Discontinued"));
        CUSTOMER_MAP.put(3L, new Customer(3L, "Adrian Lopez", 100, "Active"));
        CUSTOMER_MAP.put(4L, new Customer(4L, "Melisa Mares", 100, "Inactive"));

        CARD_BINS.put("123", new Card("123", "VISA", "Credit"));
        CARD_BINS.put("234", new Card("234", "MASTERCARD", "Debit"));
        CARD_BINS.put("345", new Card("345", "AMEX", "Credit"));
    }

    public static Customer findCustomerById(Long id) {
        return CUSTOMER_MAP.get(id);
    }

    public static void changeCustomerStatus(Long id, String newStatus) {
        Customer customer = findCustomerById(id);
        customer.setStatus(newStatus);
        System.out.println("Change of client status '" + customer.getName()
                + "'" + newStatus);
    }

    public static boolean validateCardBins(String creditCardPrefix) {
        if (CARD_BINS.containsKey(creditCardPrefix)) {
            String company = CARD_BINS.get(creditCardPrefix).getCompany();
            System.out.println("Valid card > '" + creditCardPrefix + "', "
                    + company + "\n");
            return true;
        } else {
            System.out.println("Invalid card >\n");
            return false;
        }
    }

    public static String getCardCompany(String creditCardPrefix) {
        if (CARD_BINS.containsKey(creditCardPrefix)) {
            return CARD_BINS.get(creditCardPrefix).getCompany();
        }
        throw new RuntimeException("Card does not exist");
    }
}