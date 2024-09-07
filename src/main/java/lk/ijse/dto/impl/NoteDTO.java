package lk.ijse.dto.impl;

import lk.ijse.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteDTO implements SuperDTO {
    private String noteId;
    private String noteTitle;
    private String noteDescription;
    private String createDate;
    private String priorityLevel;
    private String userId;

}
