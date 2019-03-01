package lt.studioControlApplication.Exam.Services;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lt.studioControlApplication.Exam.DTO.PerformerGetDTO;
import lt.studioControlApplication.Exam.DTO.StudioGetDTO;
import lt.studioControlApplication.Exam.DTO.StudioPutDTO;
import lt.studioControlApplication.Exam.Entities.Performer;
import lt.studioControlApplication.Exam.Entities.Studio;
import lt.studioControlApplication.Exam.Repositories.PerformerRepository;
import lt.studioControlApplication.Exam.Repositories.StudioRepository;
import lt.studioControlApplication.Exam.configs.StudioCategory;

@Service
public class StudioService {

    @Autowired
    private StudioRepository studioRepository;
    @Autowired
    private PerformerRepository performerRepository;

    public StudioService(StudioRepository studioRepository, PerformerRepository performerRepository) {
        this.studioRepository = studioRepository;
        this.performerRepository = performerRepository;
    }

    @Transactional(readOnly = true)
    public List<StudioGetDTO> findAllStudios() {
        return studioRepository.findAll().stream().map(studio ->
                new StudioGetDTO(studio.getTitle(),studio.getLogo(),studio.getStudioCategory(),studio.getSize())
        ).collect(Collectors.toList());
    }

    @Transactional
    public void savePhoto(StudioPutDTO studioPutDTO) {
        Studio studio = new Studio (studioPutDTO.getTitle(), studioPutDTO.getLogo(), studioPutDTO.getStudioCategory(), studioPutDTO.getSize(), Collections.emptySet());
    	studioRepository.save(studio);
    }

    @Transactional
    public StudioGetDTO findByTitle(String title) {
        Studio recordStudio = studioRepository.findByTitle(title);
        if(recordStudio != null){
            return new StudioGetDTO(recordStudio.getTitle(), recordStudio.getLogo(), recordStudio.getStudioCategory(), recordStudio.getSize());
        }
        else {
            return null;
        }
    }

    @Transactional
    public void delete(String title) {
    	studioRepository.deleteByTitle(title);
    }

    @Transactional
    public List<PerformerGetDTO> getAllPerformers(String title) {
    	Studio recordStudio = studioRepository.findByTitle(title);
        if(recordStudio != null){
            return recordStudio.getPerformers().stream().map(performer ->
                    new PerformerGetDTO(performer.getTitle(),
                            performer.getName(),
                            performer.getLastName(),
                            performer.getGenre(),
                            performer.getCountry(),
                            performer.getBirthDate(),
                            performer.getPicture())
            ).collect(Collectors.toList());
        }
        return null;
    }

    @Transactional
    public void update(String title, StudioPutDTO studioPutDTO) {
        Studio studio = studioRepository.findByTitle(title);
        if(studio != null){
        	studio.setTitle(studioPutDTO.getTitle());
        	studio.setCategory(studioPutDTO.getStudioCategory());
        	studio.setLogo(studioPutDTO.getLogo());
        	studio.setSize(studioPutDTO.getSize());
        }
    }

    @Transactional
    public void addPerformer(String studio_title, String performer_title) {
        Studio studio = studioRepository.findByTitle(studio_title);
        Performer performer = performerRepository.findByTitle(performer_title);
        if(studio != null){
            studio.getPerformers().add(performer);
        }
    }
}
