package net.devpull.coworking.billing.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import net.devpull.coworking.common.infrastructure.BaseEntity;
import net.devpull.coworking.music.domain.model.Track;

import java.math.BigDecimal;

@Entity
@Table(name = "INVOICE_LINE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class InvoiceLine extends BaseEntity {

    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "track_id", nullable = false)
    private Track track;
}
