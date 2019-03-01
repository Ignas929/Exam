package lt.studioControlApplication.Exam.Entities;

import java.util.HashSet;
import java.util.List;
import org.hibernate.annotations.GenericGenerator;
import lt.studioControlApplication.Exam.DTO.StudioGetDTO;
import lt.studioControlApplication.Exam.configs.StudioCategory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Studio implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "title", unique = true)
	private String title;

	@Column(name = "logo")
	private String logo;

	@Enumerated(value = EnumType.STRING)
    private StudioCategory studioCategory;

	@Column(name = "size")
	private String size;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "studio_performer", joinColumns = @JoinColumn(name = "studio_id"), inverseJoinColumns = @JoinColumn(name = "performer_id"))
    private Set<Performer> performers = new HashSet<>();

	public Studio(String title, String logo, StudioCategory studioCategory, String size, Set<Performer> performers) {

		this.title = title;
		this.logo = logo;
		this.studioCategory = studioCategory;
		this.size = size;
		this.performers = performers;
	}
	
	public Studio() {}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public StudioCategory getStudioCategory() {
		return studioCategory;
	}

	public void setCategory(StudioCategory studioCategory) {
		this.studioCategory = studioCategory;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}


    public Set<Performer> getPerformers() {
        return performers;
    }

    public void setPerformers(Set<Performer> performers) {
        this.performers = performers;
    }

		
}
