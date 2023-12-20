package dao;

public class blog {

	private int blog_id ;

    private	String  title ;
    
    private String description ;
	
	private  String	created_at ;
	
	private String photo ;
	
	private int author_id ;
	
	public blog(int blog_id, int author_id,String title, String created_at,String description, String photo ) {
		super();
		this.blog_id = blog_id;
		this.title = title;
		this.created_at = created_at;
		this.author_id = author_id;
		this.description = description ;
		this.photo = photo;
	}
	
	public blog() {
		super();
	}


	public blog(String title, String created_at, int author_id ,String description, String photo ) {
		super();
		this.title = title;
		this.created_at = created_at;
		this.author_id = author_id;
		this.description = description ;
		this.photo = photo;
	}


	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int string) {
		this.author_id = string;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
