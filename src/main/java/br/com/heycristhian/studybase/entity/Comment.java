package br.com.heycristhian.studybase.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
@Getter
@Entity
@AllArgsConstructor
@Table(name = "tb_comment")
public class Comment {

    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private final UUID uuid;
    private final ZonedDateTime date;
    private final String text;

    @ManyToOne
    private final Post post;

    @ManyToOne
    private final User user;
}
