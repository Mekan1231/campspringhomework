package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concretes.Language;

public interface LanguageService {
    boolean add(Language language);
    boolean update(Language language);
    boolean remove(int id);
    Language getById(int id);
    List<Language> getAll();
}
