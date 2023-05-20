package kodlama.io.Devs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="languageChild")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LanguageChild {
    
    @Column(name="name")
    private String name;

    
    @Id
    @Column(name="childId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  childId;

    @ManyToOne
    @JoinColumn(name = "languageId")
    private Language language;
    
    
    
    
}
