package yahya.deneme.app.youtubedeneme.bussiness.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    private int id;
    private String title;
    private String text;
    private int userId;

}
