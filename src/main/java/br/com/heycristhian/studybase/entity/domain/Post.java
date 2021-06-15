package br.com.heycristhian.studybase.entity.domain;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
@Getter
@Entity
@Table(name = "tb_post")
public class Post {

    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private final UUID uuid;
    private final ZonedDateTime date;
    private final String title;
    private final String body;

    @ManyToOne
    private final User user;

}
