package dmitry.spring.test.logic.mapper;


import dmitry.spring.test.db.NoteData;
import dmitry.spring.test.models.NoteDataModel;
import org.springframework.stereotype.Component;

@Component
public class NoteDataMapper {

    public NoteData mapToEntity(NoteDataModel model) {
        NoteData noteData = new NoteData();
        noteData.setName(model.getName());
        noteData.setValue(model.getValue());
        return noteData;
    }

    public NoteDataModel mapToModel(NoteData noteData) {
        NoteDataModel noteDataModel = new NoteDataModel();
        noteDataModel.setName(noteData.getName());
        noteDataModel.setValue(noteData.getValue());
        return noteDataModel;
    }
}
