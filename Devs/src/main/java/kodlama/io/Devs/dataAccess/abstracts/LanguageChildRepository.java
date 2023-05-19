package kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Devs.entities.concretes.LanguageChild;

public interface LanguageChildRepository extends JpaRepository<LanguageChild,Integer> {
    
}
