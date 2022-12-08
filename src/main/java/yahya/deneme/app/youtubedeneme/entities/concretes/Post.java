package yahya.deneme.app.youtubedeneme.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @Column(name = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)//bir user silinirse postlarını sil
    @JsonIgnore//SERilazitionda sorun çıkarmasın diye
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)//bir user silinirse tüm postlar silinsin!!
    @JsonIgnore // bu alanla uğraştırma bizi
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @OneToMany(mappedBy = "post")
    private List<Like> likes;

}
