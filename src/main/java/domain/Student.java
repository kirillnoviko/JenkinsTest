package domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
public class Student extends User {

    @Column(name="average_score")
    private Long averageScore;

}
