package yahya.deneme.app.youtubedeneme.bussiness.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yahya.deneme.app.youtubedeneme.entities.concretes.Post;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponses {
    private int id;
    private int userId;
    private String userName;
    private String title;
    private String text;

    public PostResponses(Post entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.userName = entity.getUser().getUserName();
        this.title = entity.getTitle();
        this.text = entity.getText();
    }
}
