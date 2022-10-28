package yahya.deneme.app.youtubedeneme.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // STRATEJİ NASIL ARTACAK BU BELİRTİYORUZ
    @Column(name = "pos_id")
    private int id;

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "text",columnDefinition = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_user_id")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

}
