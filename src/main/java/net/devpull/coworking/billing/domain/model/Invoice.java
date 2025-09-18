package net.devpull.coworking.billing.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import net.devpull.coworking.common.infrastructure.BaseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "INVOICES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Invoice extends BaseEntity {

    @Column(name = "invoice_date", nullable = false)
    private LocalDateTime invoiceDate;

    @Column(name = "billing_address")
    private String billingAddress;

    @Column(name = "billing_city")
    private String billingCity;

    @Column(name = "billing_state")
    private String billingState;

    @Column(name = "billing_country")
    private String billingCountry;

    @Column(name = "billing_postal_code")
    private String billingPostalCode;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceLine> invoiceLines;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

}
