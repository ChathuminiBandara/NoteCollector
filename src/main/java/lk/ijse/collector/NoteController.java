package lk.ijse.collector;

import lk.ijse.dto.impl.NoteDTO;
import lk.ijse.utill.AppUtill;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/notes")
public class NoteController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public NoteDTO saveNote(@RequestBody NoteDTO noteDTO){
        noteDTO.setNoteId(AppUtill.generateNoteId());
        return noteDTO;
    }
    public String getSelectedNote(){
        return null;
    }
    public List<NoteDTO> getAllNotes(){
        return null;
    }
    public void deleteNote(String noteId){

    }
    public void updateNte(String noteId, NoteDTO noteDTO){

    }
}
