package lt.studioControlApplication.Exam.DTO;

import java.util.Date;

public class PerformerPutDTO {
	private String title;
    private String name;
    private String lastName;
    private String genre;
    private String country;
    private Date birthDate;
    private String picture;

	public PerformerPutDTO(String title, String name, String lastName, String genre, String country, Date birthDate,
			String picture) {

		this.title = title;
		this.name = name;
		this.lastName = lastName;
		this.genre = genre;
		this.country = country;
		this.birthDate = birthDate;
		this.picture = picture;
	}
    
	public PerformerPutDTO() {
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
	}
	
}

