package net.devpull.coworking.music.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import net.devpull.coworking.common.infrastructure.BaseEntity;

@Entity
@Table(name = "PLAYLIST_TRACKS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PlaylistTrack extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "track_id", nullable = false)
    private Track track;

    @ManyToOne
    @JoinColumn(name = "playlist_id", nullable = false)
    private Playlist playlist;

}
