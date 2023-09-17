package jpaStudy.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name="orderId")
    private Long id;

    @ManyToOne
    @JoinColumn(name="memberId")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItemList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="deliveryId")
    private Delivery delivery;

    /**
     * 주문시간
     */
    private LocalDateTime orderDate;

    /**
     * 주문상태
     */
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
