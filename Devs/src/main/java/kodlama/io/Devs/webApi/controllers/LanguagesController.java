package kodlama.io.Devs.webApi.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.business.requests.languageRequest.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.languageRequest.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.languageResponse.GetAllLanguageResponse;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private LanguageService languageService;


    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;

    }

   
    @GetMapping("/getall")
    public List<GetAllLanguageResponse> getAll() {
        return languageService.getAll();
    }

    @PostMapping("/add")
    public void add(CreateLanguageRequest language) {
        
        languageService.add(language);
    }

    @PostMapping("/remove")
    public void remove(int id) {
        languageService.remove(id);
    }

    @PostMapping("/update")
    public void update(UpdateLanguageRequest language) {
        languageService.update(null);
    }

    @GetMapping("/getbyid")
    public GetAllLanguageResponse getById(int id) {
        return languageService.getById(id);
    }





    
}
