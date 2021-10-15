package rs.carrot.backend.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import rs.carrot.backend.entity.*;
import rs.carrot.backend.repository.CommentRepository;
import rs.carrot.backend.service.CommentService;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
	private final CommentRepository commentRepository;

	@Override
	public List<Comment> findAll(Specification<Comment> specification, Sort sort) {
		return commentRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public Comment findById(Integer commentId) {
		return commentRepository.findById(commentId)
				.orElseThrow(() -> new NoSuchElementException("CommentService.notFound"));
	}

	@Override
	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}

	@Override
	public Comment update(Comment comment) {
		return commentRepository.save(comment);
	}

	@Override
	public void deleteById(Integer commentId) {
		commentRepository.deleteById(commentId);
	}


}