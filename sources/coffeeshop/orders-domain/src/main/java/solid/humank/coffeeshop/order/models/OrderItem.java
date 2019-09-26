package solid.humank.coffeeshop.order.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import solid.humank.ddd.commons.baseclasses.ValueObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class OrderItem extends ValueObject<OrderItem> {

    @Getter
    @Setter(AccessLevel.PRIVATE)
    String productId;

    @Getter
    @Setter(AccessLevel.PRIVATE)
    int qty;

    @Getter
    @Setter(AccessLevel.PRIVATE)
    BigDecimal price;

    @Getter
    public BigDecimal fee = this.price.multiply(BigDecimal.valueOf(qty));

    public OrderItem() {
    }

    public OrderItem(String productId, int qty, BigDecimal prices) {
        this.productId = productId;
        this.qty = qty;
        this.price = prices;
    }

    @Override
    protected Iterable<Object> getEqualityComponents() {
        List<Object> collection = new ArrayList<>();
        collection.add(this.productId);
        collection.add(this.qty);
        collection.add(this.price);
        return collection;
    }
}