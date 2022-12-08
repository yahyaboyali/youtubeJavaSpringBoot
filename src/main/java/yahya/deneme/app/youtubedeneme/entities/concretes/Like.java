package yahya.deneme.app.youtubedeneme.entities.concretes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
@Entity
@Table(name="likes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // STRATEJİ NASIL ARTACAK BU BELİRTİYORUZ
    @Column(name = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)//bir user silinirse postlarını sil
    @JsonIgnore//SERilazitionda sorun çıkarmasın diye
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Post post;

}
