package com.southwind.springboottest.entity;

        import lombok.Data;

        import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.GenerationType;
        import javax.persistence.Id;

@Entity
@Data
public class Book {
    @Id
       private Integer id;
        @GeneratedValue(strategy = GenerationType.IDENTITY)
       private String name;
        private String sex;
        private String age;
        private Integer basesalary;
        private String address;

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    private  String dept;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getBasesalary() {
        return basesalary;
    }

    public void setBasesalary(Integer basesalary) {
        this.basesalary = basesalary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
