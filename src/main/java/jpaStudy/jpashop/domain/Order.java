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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="memberId")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItemList = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

    //==연관관계 메서드
    public void setMember(Member member){
        this.setMember(member);
        member.getOrderList().add(this);
    }

    public void addOrderItem(OrderItem orderItem){
        orderItemList.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery){
        this.delivery=delivery;
        delivery.setOrder(this);
    }
}
