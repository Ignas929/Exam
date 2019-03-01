package lt.studioControlApplication.Exam.Repositories;

import lt.studioControlApplication.Exam.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song,Long>{
	
} 
