package lt.studioControlApplication.Exam.DTO;

public class SongPutDTO {
	
	private Long id;
    private String title;
    private String album_title;
    private String duration;
    private String file_type;
    
	public SongPutDTO(Long id, String title, String album_title, String duration, String file_type) {
		this.id = id;
		this.title = title;
		this.album_title = album_title;
		this.duration = duration;
		this.file_type = file_type;
	}
    
	public SongPutDTO() {}

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
	
	
    
}
