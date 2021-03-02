package com.journal.app.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    private Collection<Student> students;

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
