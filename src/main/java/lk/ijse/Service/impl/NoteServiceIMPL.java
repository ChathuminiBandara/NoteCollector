package lk.ijse.Service.impl;

import lk.ijse.Service.NoteService;
import lk.ijse.customStatusCode.SelectedUserAndNoteErrorStatus;
import lk.ijse.dao.NoteDAO;
import lk.ijse.dto.NoteStatus;
import lk.ijse.dto.impl.NoteDTO;
import lk.ijse.entity.impl.NoteEntity;
import lk.ijse.exception.DataPersistException;
import lk.ijse.exception.NoteNotFoundException;
import lk.ijse.utill.AppUtill;
import lk.ijse.utill.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service // meta annotated from the @Component annotation
@Transactional
public class NoteServiceIMPL implements NoteService {
    @Autowired
    private NoteDAO noteDAO;

    @Autowired
    private Mapping noteMapping;

    @Override
    public void saveNote(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtill.generateNoteId());
        NoteEntity savedNote = noteDAO.save(noteMapping.toNoteEntity(noteDTO));
        if(savedNote == null){
            throw new DataPersistException("Note not saved");
        }
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return noteMapping.asNoteDTOList( noteDAO.findAll());
    }

    @Override
    public NoteStatus getNoteById(String noteId) {
        if(noteDAO.existsById(noteId)){
            var selectedUser = noteDAO.getReferenceById(noteId);
            return noteMapping.toNoteDTO(selectedUser);
        }else {
            return new SelectedUserAndNoteErrorStatus(2,"Selected note not found");
        }
    }

    @Override
    public void deleteNote(String noteId) {
        Optional<NoteEntity> foundNote = noteDAO.findById(noteId);
        if (!foundNote.isPresent()) {
            throw new NoteNotFoundException("Note not found");
        }else {
            noteDAO.deleteById(noteId);
        }
    }

    @Override
    public void updateNote(String  noteId , NoteDTO noteDTO) {
        Optional<NoteEntity> findNote = noteDAO.findById(noteId);
        if (!findNote.isPresent()) {
            throw new NoteNotFoundException("Note note found");
        } else {
            findNote.get().setNoteTitle(noteDTO.getNoteTitle());
            findNote.get().setCreateDate(noteDTO.getCreateDate());
            findNote.get().setNoteDescription(noteDTO.getNoteDescription());
            findNote.get().setPriorityLevel(noteDTO.getPriorityLevel());
        }
    }
}
