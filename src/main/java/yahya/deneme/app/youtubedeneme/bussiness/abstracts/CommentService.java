package yahya.deneme.app.youtubedeneme.bussiness.abstracts;

import yahya.deneme.app.youtubedeneme.entities.concretes.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();

    void save(Comment comment);

}
