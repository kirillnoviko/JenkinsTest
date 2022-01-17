package domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "developers")
@Data
@NoArgsConstructor
public class Developer extends User{

    @Column(name = "programming_language")
    private String programmingLanguage;

    @Column(name ="development_experience")
    private Long developmentExperience;
}
