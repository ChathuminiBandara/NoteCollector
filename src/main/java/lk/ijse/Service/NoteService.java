package lk.ijse.Service;

import lk.ijse.dto.impl.NoteDTO;

import java.util.List;

public interface NoteService {
    NoteDTO saveNote(NoteDTO noteDTO);
    List<NoteDTO> getAllNotes();
    NoteDTO getNoteById(String noteId);
    boolean deleteNote(String noteId);
    boolean updateNote(String  noteId, NoteDTO noteDTO);

}
