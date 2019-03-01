package lt.studioControlApplication.Exam.Entities;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Performer { //TODO add song fields, add studio fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
		
	@Column(name = "title", unique = true)
	private String title;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "birthDate")
	private Date birthDate;
	
	@Column(name = "picture")
	private String picture;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "studio_performer",
            joinColumns = @JoinColumn(name = "performer_id"), inverseJoinColumns = @JoinColumn(name = "studio_id"))
    private Set<Studio> studios = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "performer_song",
            joinColumns = @JoinColumn(name = "performer_id"), inverseJoinColumns = @JoinColumn(name = "song_id"))
    private Set<Song> songs = new HashSet<>();	
	
    public Performer(String title, String name, String lastName, String genre, String country, Date birthDate,
			String picture) {

		this.title = title;
		this.name = name;
		this.lastName = lastName;
		this.genre = genre;
		this.country = country;
		this.birthDate = birthDate;
		this.picture = picture;
		this.studios = studios;
        this.songs = songs;
	}
	
	public Performer() {}
	
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	};
	
	public Set<Studio> getRecordStudios() {
        return studios;
    }

    public void setRecordStudios(Set<Studio> studios) {
        this.studios = studios;
    }
	
    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

}
