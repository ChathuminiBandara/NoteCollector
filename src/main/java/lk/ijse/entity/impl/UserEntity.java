package lk.ijse.entity.impl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lk.ijse.dto.impl.NoteDTO;
import lk.ijse.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class UserEntity implements SuperEntity {
    @Id
    private String userId;
    private String firstName;
    private String lastName;

    @Column(unique = true) //makes the email unique
    private String email;
    private String password;
    private String profilePic;

    @OneToMany(mappedBy = "user")
    private List<NoteEntity> notes;
}
