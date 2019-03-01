package lt.studioControlApplication.Exam.Repositories;

import lt.studioControlApplication.Exam.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformerRepository extends JpaRepository<Performer,Long>{
	Performer findByTitle(String title);

    void deleteByTitle(String title);
} 

