package br.com.heycristhian.studybase.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Builder
@Getter
@Entity
@AllArgsConstructor
@Table(name = "tb_user")
public class User {

    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private final UUID uuid;
    private final String name;
    private final String email;
}
