package domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
@Data
@NoArgsConstructor
public class Teacher extends User {

    @Column(name = "teacher_work_time")
    Long workTime;

}
