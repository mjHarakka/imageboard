package bean;

import java.io.File;
import java.util.Date;
import java.util.List;

public class Post {

	private int id;
	private String topic;
	private String content;
	private List<Comment> comments;
	private Date date;
	private File file;

	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
}
