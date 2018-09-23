package tracker;

public class Item {
    private String id;
    private String name;
    private String desc;
    private long created;
    private String[] comments;

    //---- Constructor ----
    public Item(){}

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    //---- Setters ----
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setCreated(long created) {
        this.created = created;
    }
    public void setComments(String[] comments) {
        this.comments = comments;
    }

    //---- Getters ----
    public String getName() {
        return this.name;
    }
    public String getDesc() {
        return this.desc;
    }
    public String getId() {
        return id;
    }
    public long getCreated() {
        return created;
    }
    public String[] getComments() {
        return comments;
    }
}
