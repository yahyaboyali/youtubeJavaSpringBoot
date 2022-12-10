package yahya.deneme.app.youtubedeneme.bussiness.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequest {
    private int id;
    private int userId;
    private int postId;
    private String text;
}
