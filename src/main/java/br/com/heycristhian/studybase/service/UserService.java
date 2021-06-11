package br.com.heycristhian.studybase.service;

import br.com.heycristhian.studybase.entity.User;
import br.com.heycristhian.studybase.exception.NonUniqueValueException;
import br.com.heycristhian.studybase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired private UserRepository repository;

    public User save(User user) {
        hasDataByEmail(user.getEmail());
        return repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public Optional<User> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public void hasDataByEmail(String email) {
        long count = repository.countByEmail(email);
        if (count > 0) throw new NonUniqueValueException("email", email);
    }
}
