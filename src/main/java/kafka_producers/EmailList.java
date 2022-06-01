package kafka_producers;

public class EmailList {

   String email;
   String password;


    public EmailList() {
    }

    public EmailList(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "kafka_producers.EmailList{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

