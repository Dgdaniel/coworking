package net.devpull.coworking.music.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import net.devpull.coworking.common.infrastructure.BaseEntity;

import java.util.List;
@Entity
@Table(name = "ARTISTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Artist extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Album> albums ;
}
