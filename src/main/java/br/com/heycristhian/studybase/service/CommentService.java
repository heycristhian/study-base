package br.com.heycristhian.studybase.service;

import br.com.heycristhian.studybase.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired private CommentRepository repository;
}
