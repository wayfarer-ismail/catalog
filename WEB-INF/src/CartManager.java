import java.util.HashMap;
import java.util.Map;

public class CartManager {
    //maps a users email to a map of items
    private Map<String, Map<CartItem, Integer>> userCarts;

    public CartManager(Map<String, Map<CartItem, Integer>> userCarts) {
        this.userCarts = userCarts;
    }

    public CartManager() {
        userCarts = new HashMap<>();
    }

    public Map<String, Map<CartItem, Integer>> getUserCarts() {
        return userCarts;
    }

    public Map<CartItem, Integer> getUserCart(String email) {
        if (!userCarts.containsKey(email)) {
            throw new IllegalArgumentException("This user does not have an associated cart");
        } else {
            return userCarts.get(email);
        }
    }

    public void addToCart(String email, CartItem item) {
        if (!userCarts.containsKey(email)) {
            throw new IllegalArgumentException("This user does not have an associated cart");
        } else {
            Map<CartItem, Integer> cart = userCarts.get(email);
            if (cart.containsKey(item)) {
                cart.put(item, 1 + cart.get(item));
            } else {
                cart.put(item, 1);
            }

        }
    }
}
