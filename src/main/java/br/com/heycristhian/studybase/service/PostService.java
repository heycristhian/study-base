package br.com.heycristhian.studybase.service;

import br.com.heycristhian.studybase.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired private PostRepository repository;
}
