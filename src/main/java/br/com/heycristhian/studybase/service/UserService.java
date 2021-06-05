package br.com.heycristhian.studybase.service;

import br.com.heycristhian.studybase.entity.User;
import br.com.heycristhian.studybase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User save(User user) {
        final User save = repository.save(user);
        return user;
    }
}
