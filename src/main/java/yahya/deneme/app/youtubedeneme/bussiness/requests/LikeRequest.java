package yahya.deneme.app.youtubedeneme.bussiness.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeRequest {
    private int id;
    private int postId;
    private int userId;
}
