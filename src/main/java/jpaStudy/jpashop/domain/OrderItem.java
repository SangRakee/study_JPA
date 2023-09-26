package jpaStudy.jpashop.domain;

import jakarta.persistence.*;
import jpaStudy.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name="orderItemId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemId")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="orderId")
    private Order order;

    /**
     * 주문가격
     */
    private int orderPrice;

    /**
     * 주문 수량
     */
    private int count;
}
