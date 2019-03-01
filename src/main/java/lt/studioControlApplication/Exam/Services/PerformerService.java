package lt.studioControlApplication.Exam.Services;

import lt.studioControlApplication.Exam.DTO.PerformerGetDTO;
import lt.studioControlApplication.Exam.DTO.PerformerPutDTO;
import lt.studioControlApplication.Exam.DTO.SongGetDTO;
import lt.studioControlApplication.Exam.Entities.Performer;
import lt.studioControlApplication.Exam.Repositories.PerformerRepository;
import lt.studioControlApplication.Exam.Repositories.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerformerService {

    @Autowired
    private StudioRepository studioRepository;
    @Autowired
    private PerformerRepository performerRepository;

    public PerformerService(StudioRepository studioRepository, PerformerRepository performerRepository) {
        this.studioRepository = studioRepository;
        this.performerRepository = performerRepository;
    }

    @Transactional
    public List<PerformerGetDTO> findAll() {
        return performerRepository.findAll().stream().map(performer ->
                new PerformerGetDTO(performer.getTitle(),
                        performer.getName(),
                        performer.getLastName(),
                        performer.getGenre(),
                        performer.getCountry(),
                        performer.getBirthDate(),
                        performer.getPicture())
        ).collect(Collectors.toList());
    }

    @Transactional
    public PerformerGetDTO findByTitle(String title) {
        Performer performer = performerRepository.findByTitle(title);
        if (performer != null) {
            return new PerformerGetDTO(performer.getTitle(),
                    performer.getName(),
                    performer.getLastName(),
                    performer.getGenre(),
                    performer.getCountry(),
                    performer.getBirthDate(),
                    performer.getPicture());
        }
        return null;
    }

    @Transactional
    public void deleteByTitle(String title) {
    	performerRepository.deleteByTitle(title);
    }


    @Transactional
    public void savePerformer(PerformerPutDTO putDTO) {
        Performer performer = new Performer();
        performer.setTitle(putDTO.getTitle());
        performer.setName(putDTO.getName());
        performer.setLastName(putDTO.getLastName());
        performer.setGenre(putDTO.getGenre());
        performer.setCountry(putDTO.getCountry());
        performer.setBirthDate(putDTO.getBirthDate());
        performer.setPicture(putDTO.getPicture());
        performerRepository.save(performer);
    }

    @Transactional
    public List<SongGetDTO> getAllSongs(String title) {
        Performer performer = performerRepository.findByTitle(title);
        if(performer != null){
            return performer.getSongs().stream().map(song ->
                    new SongGetDTO(song.getId(),song.getTitle(),song.getAlbum_title(),song.getDuration(),song.getFile_type())
                    ).collect(Collectors.toList());
        }
        return null;
    }

    @Transactional
    public void updatePerformer(String title, PerformerPutDTO putDTO) {
        Performer performer = performerRepository.findByTitle(title);
        if(performer!= null){
            performer.setName(putDTO.getName());
            performer.setLastName(putDTO.getLastName());
            performer.setPicture(putDTO.getPicture());
            performer.setBirthDate(putDTO.getBirthDate());
            performer.setCountry(putDTO.getCountry());
            performer.setGenre(putDTO.getGenre());
        }
    }
}