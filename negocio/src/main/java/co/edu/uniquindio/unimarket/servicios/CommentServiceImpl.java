package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.entidades.Comment;
import co.edu.uniquindio.unimarket.repo.CommentRepo;

public class CommentServiceImpl implements CommentService{
    private final CommentRepo commentRepo;

    public CommentServiceImpl(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @Override
    public Comment registerComment(Comment c) throws Exception {
        return commentRepo.save(c);
    }

    @Override
    public Comment updateComment(Comment c) throws Exception {
        return commentRepo.save(c);
    }

    @Override
    public void deleteComment(int id) throws Exception {
        commentRepo.deleteById(id);
    }
}
