package net.devpull.coworking.music.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import net.devpull.coworking.billing.domain.model.InvoiceLine;
import net.devpull.coworking.common.infrastructure.BaseEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "TRACKS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)
public class Track extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "composer")
    private String composer;

    @Column(name = "milliseconds")
    private Integer milliseconds;

    @Column(name = "bytes")
    private Integer bytes;

    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;

    @OneToMany(mappedBy = "track", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceLine> invoiceLines;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "media_type_id")
    private MediaType mediaType;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
