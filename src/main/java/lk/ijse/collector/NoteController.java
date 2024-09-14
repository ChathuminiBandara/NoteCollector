package lk.ijse.collector;

import lk.ijse.Service.NoteServiceIMPL;
import lk.ijse.dto.impl.NoteDTO;
import lk.ijse.utill.AppUtill;
import lombok.val;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/notes")
public class NoteController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)

    //controller layer eke endpoints - mewa equal wenawa crud operations walata - all are public
    public NoteDTO saveNote(@RequestBody NoteDTO noteDTO){
        var noteServiceIMPL = new NoteServiceIMPL();
        noteDTO.setNoteId(AppUtill.generateNoteId());
        noteServiceIMPL.saveNote(noteDTO);
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
