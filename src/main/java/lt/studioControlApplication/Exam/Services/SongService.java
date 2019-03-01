package lt.studioControlApplication.Exam.Services;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import lt.studioControlApplication.Exam.Repositories.PerformerRepository;
import lt.studioControlApplication.Exam.Repositories.SongRepository;
import lt.studioControlApplication.Exam.DTO.SongGetDTO;
import lt.studioControlApplication.Exam.DTO.SongPutDTO;
import lt.studioControlApplication.Exam.Entities.Performer;
import lt.studioControlApplication.Exam.Entities.Song;


@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;
    @Autowired
    private PerformerRepository performerRepository;

    public SongService(SongRepository songRepository, PerformerRepository performerRepository) {
        this.songRepository = songRepository;
        this.performerRepository = performerRepository;
    }

    @Transactional(readOnly = true)
    public List<SongGetDTO> getAllSongs() {
        return songRepository.findAll().stream().map(song ->
                new SongGetDTO(song.getId() ,song.getTitle(), song.getAlbum_title(), song.getDuration(),song.getFile_type())).collect(Collectors.toList());
    }

    @Transactional
    public SongGetDTO getById(Long id) {
        Song song = songRepository.findById(id).orElse(null);
        if (song != null) {
            return new SongGetDTO(song.getId() ,song.getTitle(), song.getAlbum_title(), song.getDuration(),song.getFile_type());
        }
        return null;
    }

    @Transactional
    public void saveSong(SongPutDTO songPutDTO) {
        Song song = new Song();
        song.setTitle(songPutDTO.getTitle());
        song.setAlbum_title(songPutDTO.getAlbum_title());
        song.setDuration(songPutDTO.getDuration());
        song.setFile_type(songPutDTO.getFile_type());
        song.setPerformers(Collections.emptySet());
        songRepository.save(song);
    }

    @Transactional
    public void deleteSongById(Long id) {
    	songRepository.deleteById(id);
    }

    @Transactional
    public void addSongToPerformer(long song_id, String performer_id) {
        Performer performer = performerRepository.findByTitle(performer_id);
        Song song = songRepository.getOne(song_id);
        if(performer != null){
            performer.getSongs().add(song);
        }
    }

    @Transactional
    public void updateSong(long id, SongPutDTO songPutDTO) {
        Song song = songRepository.findById(id).orElse(null);
        if (song != null){
            song.setTitle(songPutDTO.getTitle());
            song.setDuration(songPutDTO.getDuration());
            song.setFile_type(songPutDTO.getFile_type());
            song.setAlbum_title(songPutDTO.getAlbum_title());
        }
    }
}
