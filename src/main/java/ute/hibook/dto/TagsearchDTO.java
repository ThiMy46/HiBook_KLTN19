package ute.hibook.dto;

public class TagsearchDTO {

	private int idTag;
	private String nameTag;
	private int numOfSearch;

	public TagsearchDTO() {
	}

	public int getIdTag() {
		return this.idTag;
	}

	public void setIdTag(int idTag) {
		this.idTag = idTag;
	}

	public String getNameTag() {
		return this.nameTag;
	}

	public void setNameTag(String nameTag) {
		this.nameTag = nameTag;
	}

	public int getNumOfSearch() {
		return this.numOfSearch;
	}

	public void setNumOfSearch(int numOfSearch) {
		this.numOfSearch = numOfSearch;
	}
}
