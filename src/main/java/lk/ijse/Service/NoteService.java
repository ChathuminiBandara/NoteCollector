package lk.ijse.Service;

import lk.ijse.dto.NoteStatus;
import lk.ijse.dto.impl.NoteDTO;

import java.util.List;

public interface NoteService {
    void saveNote(NoteDTO noteDTO);
    List<NoteDTO> getAllNotes();
    NoteStatus getNoteById(String noteId);
    void deleteNote(String noteId);
    void updateNote(String  noteId, NoteDTO noteDTO);

}
