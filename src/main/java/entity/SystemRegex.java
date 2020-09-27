package entity;

public class SystemRegex {
	private String title;
	private String value;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public SystemRegex() {}
	public SystemRegex(String title, String value) {
		this.title = title;
		this.value = value;
	}
	@Override
	public String toString() {
		return "RegexProperties [title=" + title + ", value=" + value + "]";
	}
}
