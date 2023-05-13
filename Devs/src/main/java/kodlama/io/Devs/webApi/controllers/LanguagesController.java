package kodlama.io.Devs.webApi.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    public List<Language> getAll() {
        return languageService.getAll();
    }

    @PostMapping("/add")
    public void add(Language language) {
        if (languageService.add(language)) {
            System.out.println("Ekleme başarılı");
        }
        System.out.println("Ekleme başarısız");
        
    }

    @PostMapping("/remove")
    public void remove(int id) {
        if (languageService.remove(id)) {
            System.out.println("Silme başarılı");
        }
        System.out.println("Silme başarısız");
    }

    @PostMapping("/update")
    public void update(Language language) {
        if (languageService.update(language)) {
            System.out.println("Güncelleme başarılı");
        }
        System.out.println("Güncelleme başarısız");
    }

    @GetMapping("/getbyid")
    public Language getById(int id) {
        return languageService.getById(id);
    }





    
}
