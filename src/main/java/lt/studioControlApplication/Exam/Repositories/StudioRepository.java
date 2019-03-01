package lt.studioControlApplication.Exam.Repositories;

import lt.studioControlApplication.Exam.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudioRepository extends JpaRepository<Studio,Long>{
	Studio findByTitle(String title);

    void deleteByTitle(String title);
} 
