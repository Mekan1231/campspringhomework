package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

    LanguageRepository  languageRepository;
    List<Language> languages;
    
    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
        this.languages=languageRepository.getAll();
    }

    

    @Override
    public boolean add(Language language) {
        if(!(language.getName()==null)){
            for (Language lng : languages) {
                if (!(lng.getName()==language.getName())) {
                    languageRepository.add(language);
                }
            }
        }
        return false;
    }

    @Override
    public boolean update(Language language) {
        if(!(language.getName()==null)){
            for (Language lng : languages) {
                if (language.getId()==lng.getId()) {
                    int index =languages.indexOf(lng);
                    languageRepository.update(language, index);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        for (Language lng : languages) {
            if (lng.getId()==id) {
                int index=languages.indexOf(lng);
                languageRepository.remove(index);

            }
        }
        return false;
    }

    @Override
    public Language getById(int id) {
        return languageRepository.getById(id);
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.getAll();
    }

    
}
