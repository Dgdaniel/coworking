package net.devpull.coworking.music.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import net.devpull.coworking.common.infrastructure.BaseEntity;

import java.util.List;

@Entity
@Table(name = "GENRES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Genre extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "genre")
    private List<Track> tracks;
}
