package c.o.m.demo.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Education {

    private long educationId;
    private long employeeId;
    private String school;
    private String major;
    private Date start;
    private Date graduate;

    public long getEducationId() {
        return educationId;
    }

    public void setEducationId(long educationId) {
        this.educationId = educationId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getGraduate() {
        return graduate;
    }

    public void setGraduate(Date graduate) {
        this.graduate = graduate;
    }

    @Override
    public String toString() {
        return "Education{" +
                "educationId=" + educationId +
                ", employeeId=" + employeeId +
                ", school='" + school + '\'' +
                ", major='" + major + '\'' +
                ", start=" + new SimpleDateFormat("yyyy-MM-dd").format(start) +
                ", graduate=" + new SimpleDateFormat("yyyy-MM-dd").format(graduate) +
                '}';
    }
}