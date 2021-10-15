package rs.carrot.backend.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.backend.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findAll(Specification<Comment> specification, Sort sort);

    Comment save(Comment comment);

    Comment update(Comment comment);

    Comment findById(Integer commentId);

    void deleteById(Integer commentId);

}