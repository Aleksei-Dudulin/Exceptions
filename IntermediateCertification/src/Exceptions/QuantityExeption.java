package Exceptions;

/**
 * Исключение, возникающее в результате
 */
public class QuantityExeption extends Exception {
    private final int quantity;

    /**
     *
     * @param message
     * @param quantity
     */
    public QuantityExeption(String message, int quantity) {
        super(message);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
