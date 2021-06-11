package br.com.heycristhian.studybase.repository;

import br.com.heycristhian.studybase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    long countByEmail(String email);
}
