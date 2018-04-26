package dmitry.spring.test.logic;

import dmitry.spring.test.db.Note;
import dmitry.spring.test.db.repositories.NoteRepository;
import dmitry.spring.test.logic.mapper.NoteMapper;
import lombok.Builder;
import lombok.Data;

import dmitry.spring.test.db.repositories.NoteDataRepository;
import dmitry.spring.test.models.NoteModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Data
@Builder
@Service
@Transactional
public class NoteService {

    private NoteDataRepository noteDataRepository;

    private NoteRepository noteRepository;

    private NoteMapper mapper;

    public String createNote(NoteModel noteModel) {

        Note note = mapper.mapToEntity(noteModel);
        note.setGuid(GuidGenerator.generateGUID());
        note.getNoteDataList().forEach(
                NoteData -> NoteData.setNote_fk(note)
        );
        return noteRepository.save(note).getGuid();
    }

    public NoteModel getNoteByGUID(String id) {
        Note note = noteRepository.getByGuid(id);
        return mapper.mapToModel(note);
    }
}
