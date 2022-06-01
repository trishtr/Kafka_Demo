package kafka_producers;

import com.opencsv.bean.CsvBindByName;

public class Patients {
    @CsvBindByName
    private int patientid;

    @CsvBindByName
    private String name;

    @CsvBindByName
    private String dept;

    @CsvBindByName
    private String dateofbirth;

    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }
}
