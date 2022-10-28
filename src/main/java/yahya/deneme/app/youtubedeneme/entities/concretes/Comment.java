package yahya.deneme.app.youtubedeneme.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // STRATEJİ NASIL ARTACAK BU BELİRTİYORUZ
    @Column(name = "comment_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_pos_id")
    private Post post;

    @Lob
    @Column(columnDefinition = "text")
    private String text;

}
