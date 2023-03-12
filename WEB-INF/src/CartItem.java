import java.io.Serializable;

public class CartItem implements Serializable {
    private static final long serialVersionUID = 3;

    private String imgAddress;
    private String name;
    private int price;

    public CartItem(String imgAddress, String name, int price) {
        this.imgAddress = imgAddress;
        this.name = name;
        this.price = price;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CartItem c) {
            return this.name.matches(c.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
