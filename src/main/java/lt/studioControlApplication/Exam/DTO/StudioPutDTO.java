package lt.studioControlApplication.Exam.DTO;

import lt.studioControlApplication.Exam.configs.StudioCategory;

public class StudioPutDTO {
    private String title;
    private String logo;
    private StudioCategory studioCategory;
    private String size;

    public StudioPutDTO(String title, String logo, StudioCategory studioCategory, String size) {
        this.title = title;
        this.logo = logo;
        this.studioCategory = studioCategory;
        this.size = size;
    }

    public StudioPutDTO() {
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

	public void setStudioCategory(StudioCategory studioCategory) {
		this.studioCategory = studioCategory;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
  
}
