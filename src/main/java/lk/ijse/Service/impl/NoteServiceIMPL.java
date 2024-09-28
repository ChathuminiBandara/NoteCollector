package lk.ijse.Service.impl;

import lk.ijse.Service.NoteService;
import lk.ijse.dto.impl.NoteDTO;
import lk.ijse.utill.AppUtill;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // meta annotated from the @Component annotation
public class NoteServiceIMPL implements NoteService {
    private static List<NoteDTO> noteDTOList = new ArrayList<>();

    public NoteServiceIMPL(){
        noteDTOList.add(new NoteDTO("Note-a9f63ca3-6c64-46af-87d0-593ca176eeab", "SampleTitle", "1st description", "2024.09.14", "High", "U001"  ));
        noteDTOList.add(new NoteDTO("Note-d3dfba6d-5b57-4557-b2b0-5e3aa53d28b4", "SampleTitle", "2nd Description", "2024.09.14", "Low", "U002"  ));
        noteDTOList.add(new NoteDTO("Note-0444e56d-b9f2-4b10-9d6f-abca7ce032e5", "SampleTitle", "3rd description", "2024.09.14", "High", "U003"  ));
        noteDTOList.add(new NoteDTO("Note-995dc193-3576-4d58-bd75-f8bfaff637b7", "SampleTitle", "4tht description", "2024.09.14", "Medium", "U004"  ));
        noteDTOList.add(new NoteDTO("Note-c12097b9-71de-487b-aecb-3837dec76657", "SampleTitle", "5th description", "2024.09.14", "High", "U005"  ));
    }

    @Override
    public NoteDTO saveNote(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtill.generateNoteId());
        noteDTOList.add(noteDTO);
        return noteDTO;
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return noteDTOList;
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
