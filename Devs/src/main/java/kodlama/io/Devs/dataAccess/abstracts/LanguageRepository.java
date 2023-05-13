package kodlama.io.Devs.dataAccess.abstracts;


import java.util.List;

import kodlama.io.Devs.entities.concretes.Language;

public interface LanguageRepository {
    void add(Language language);
    void update(Language language,int index);
    void remove(int index);
    Language getById(int id);
    List<Language> getAll();
}
