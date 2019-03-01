package lt.studioControlApplication.Exam.Entities;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Song {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "title")
	private String title;

	@Column(name = "album_title")
	private String album_title;
	
	@Column(name = "duration")
	private String duration;

	@Column(name = "file_type")
	private String file_type;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "performer_song",
            joinColumns = @JoinColumn(name = "song_id"), inverseJoinColumns = @JoinColumn(name = "performer_id"))
    private Set<Performer> performers = new HashSet<>();
	
	public Song() {}
	
	public Song(Long id, String title, String album_title, String duration, String file_type) {

		this.id = id;
		this.title = title;
		this.album_title = album_title;
		this.duration = duration;
		this.file_type = file_type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAlbum_title() {
		return album_title;
	}

	public void setAlbum_title(String album_title) {
		this.album_title = album_title;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}
	
	public Set<Performer> getPerformers() {
        return performers;
    }

    public void setPerformers(Set<Performer> performers) {
        this.performers = performers;
    }

}
