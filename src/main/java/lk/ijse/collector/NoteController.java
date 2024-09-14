package lk.ijse.collector;

import lk.ijse.Service.NoteService;
import lk.ijse.Service.NoteServiceIMPL;
import lk.ijse.dto.impl.NoteDTO;
import lk.ijse.utill.AppUtill;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;  //Bean Injection
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)

    public NoteDTO saveNote(@RequestBody NoteDTO noteDTO){
        return noteService.saveNote(noteDTO);

       /* var noteServiceIMPL = new NoteServiceIMPL();
        noteDTO.setNoteId(AppUtill.generateNoteId());
        noteServiceIMPL.saveNote(noteDTO);
        return noteDTO;*/
    }

    public String getSelectedNote(){
        return null;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDTO> getAllNotes(){
        return noteService.getAllNotes();
    }

    public void deleteNote(String noteId){

    }

    public void updateNte(String noteId, NoteDTO noteDTO){

    }
}

//controller layer eke endpoints - mewa equal wenawa crud operations walata - all are public

