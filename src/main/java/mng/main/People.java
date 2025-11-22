package mng.main;

public class People {


    public enum Status {
        ACTIVE("active", "ACTIVE"),
        DISABLED("disabled", "DISABLED")
        ;

        Status(String active, String active1) {
        }
    }

    private String id;
    private String name;
    private String email;
    private Status status;

    public People(String id, String name, String email, Status status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "People {" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", email='" + this.email + '\'' +
                ", status='" + this.status.name() + '\'' +
                '}';
    }




}
