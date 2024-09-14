package lk.ijse.Service;

import lk.ijse.dto.impl.NoteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceIMPL implements  NoteService {
    @Override
    public String saveNote(NoteDTO noteDTO) {
        return "";
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return List.of();
    }

    @Override
    public NoteDTO getNoteById(String noteId) {
        return null;
    }

    @Override
    public boolean deleteNote(String noteId) {
        return false;
    }

    @Override
    public boolean updateNote(NoteDTO noteDTO) {
        return false;
    }
}
