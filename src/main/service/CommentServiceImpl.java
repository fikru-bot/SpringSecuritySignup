package main.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Comment;
import main.repository.CommentRepository;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public void save(Comment comment) {
		commentRepository.save(comment);
		
	}

}
