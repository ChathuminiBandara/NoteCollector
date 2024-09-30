package lk.ijse.customStatusCode;

import lk.ijse.dto.NoteStatus;
import lk.ijse.dto.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedUserAndNoteErrorStatus implements UserStatus, NoteStatus {
    private  int Status;
    private  String StatusMessage;

}
