package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.entidades.Comment;

public interface CommentService {
    Comment registerComment(Comment p) throws Exception;

    Comment updateComment(Comment p) throws Exception;

    void deleteComment(int id) throws Exception;
}
