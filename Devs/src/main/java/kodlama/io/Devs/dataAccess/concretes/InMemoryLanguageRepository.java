package kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {
    private List<Language> languages;
    


    public InMemoryLanguageRepository() {
        languages = new ArrayList<Language>();
        languages.add(new Language(1,"CSharap"));
        languages.add(new Language(2,"Python"));
        languages.add(new Language(3,"Java"));
        
    }

    
    @Override
    public void add(Language language) {
        languages.add(language);
    }

    @Override
    public void update(Language language,int index) {
        languages.set(index, language);
    }

    @Override
    public void remove(int index) {
        languages.remove(index);
    }

    @Override
    public Language getById(int id) {
        for (Language language : languages) {
            if (language.getId()==id) {
                return language;
            }
           
        }
        return null;
    }

    @Override
    public List<Language> getAll() {
        return languages;
    }

    

    
    
}


    