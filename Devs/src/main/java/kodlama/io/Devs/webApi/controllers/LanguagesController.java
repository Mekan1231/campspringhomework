package kodlama.io.Devs.webApi.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.business.requests.languageRequest.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.languageRequest.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.languageResponse.GetAllLanguageResponse;
import kodlama.io.Devs.business.responses.languageResponse.GetByIdLanguagesResponse;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private LanguageService languageService;


    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;

    }

   
    @GetMapping()
    public List<GetAllLanguageResponse> getAll() {
        return languageService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(CreateLanguageRequest language) {
        
        languageService.add(language);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable int id) {
        languageService.remove(id);
    }

    @PutMapping()
    public void update(UpdateLanguageRequest language) {
        languageService.update(language);
    }

    @GetMapping("/{id}")
    public GetByIdLanguagesResponse getById(@PathVariable int id) {
        return languageService.getById(id);
    }





    
}
