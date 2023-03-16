package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface CommentRepo  extends JpaRepository<Comment, Integer> {

}
