package com.devmaicon.dscommerce.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;

    /*já aqui tbm rrelação 1 para 1 mas sabendo que no pagamento tem que ter um pedido usando essa anotation @OneToOne
    @MapsId*/

    @OneToOne
    @MapsId
    private Order order;

    public Payment(){}

    public Payment(Long id, Order order, Instant moment) {
        this.id = id;
        this.order = order;
        this.moment = moment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
