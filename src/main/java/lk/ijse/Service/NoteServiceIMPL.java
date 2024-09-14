package lk.ijse.Service;

import lk.ijse.dto.impl.NoteDTO;
import lk.ijse.utill.AppUtill;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceIMPL implements  NoteService {
    private static List<NoteDTO> noteDTOList = new ArrayList<>();

    NoteServiceIMPL(){
        noteDTOList.add(new NoteDTO("Note-a9f63ca3-6c64-46af-87d0-593ca176eeab", "SampleTitle", "1st description", "2024.09.14", "High", "U001"  ));
        noteDTOList.add(new NoteDTO("Note-a9f63ca3-6c64-46af-87d0-593ca176eeab", "SampleTitle", "2nd Description", "2024.09.14", "Low", "U002"  ));
        noteDTOList.add(new NoteDTO("Note-a9f63ca3-6c64-46af-87d0-593ca176eeab", "SampleTitle", "3rd description", "2024.09.14", "High", "U003"  ));
        noteDTOList.add(new NoteDTO("Note-a9f63ca3-6c64-46af-87d0-593ca176eeab", "SampleTitle", "4tht description", "2024.09.14", "Medium", "U004"  ));
        noteDTOList.add(new NoteDTO("Note-a9f63ca3-6c64-46af-87d0-593ca176eeab", "SampleTitle", "5th description", "2024.09.14", "High", "U005"  ));
    }

    @Override
    public NoteDTO saveNote(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtill.generateNoteId());

        return noteDTO;
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
    public boolean updateNote(String  noteId ,NoteDTO noteDTO) {
        return false;
    }
}
