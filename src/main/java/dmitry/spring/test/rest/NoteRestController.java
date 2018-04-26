package dmitry.spring.test.rest;


import dmitry.spring.test.logic.NoteService;
import dmitry.spring.test.models.NoteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoteRestController {

    @Autowired
    private NoteService service;

    @ResponseBody
    @RequestMapping(value = "/note",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public GUIDResponse postNote(@RequestBody NoteModel noteModel) {

        return GUIDResponse.builder()
                .guid(service.createNote(noteModel))
                .build();
    }

    @ResponseBody
    @RequestMapping(value = "/note",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public NoteModel getNote(@RequestParam("id") String id) {

        return service.getNoteByGUID(id);

    }


}
