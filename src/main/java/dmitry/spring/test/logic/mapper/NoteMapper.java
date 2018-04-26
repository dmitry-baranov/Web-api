package dmitry.spring.test.logic.mapper;

import dmitry.spring.test.db.Note;
import dmitry.spring.test.db.NoteData;
import dmitry.spring.test.models.NoteDataModel;
import dmitry.spring.test.models.NoteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NoteMapper {

    @Autowired
    private NoteDataMapper NoteDataMapper;

    public Note mapToEntity(NoteModel model) {
        Note note = new Note();
        note.setDate(model.getDate());
        List<NoteData> NoteDataList = model.getData()
                .stream()
                .map(NoteDataMapper::mapToEntity)
                .collect(Collectors.toList());

        note.setNoteDataList(NoteDataList);
        return note;
    }

    public NoteModel mapToModel(Note note) {
        NoteModel noteModel = new NoteModel();
        noteModel.setDate(note.getDate());
        List<NoteDataModel> noteDataList = note.getNoteDataList()
                .stream()
                .map(NoteDataMapper::mapToModel)
                .collect(Collectors.toList());

        noteModel.setData(noteDataList);
        return noteModel;
    }
}
