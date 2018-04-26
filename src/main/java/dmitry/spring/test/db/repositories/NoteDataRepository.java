package dmitry.spring.test.db.repositories;

import dmitry.spring.test.db.NoteData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteDataRepository extends JpaRepository<NoteData, Long> {

//    @Query(value = "SELECT * FROM NoteData WHERE NAME=?1", nativeQuery = true)
//    List<NoteData> findByName(String name);

    List<NoteData> findByName(String name);
}
