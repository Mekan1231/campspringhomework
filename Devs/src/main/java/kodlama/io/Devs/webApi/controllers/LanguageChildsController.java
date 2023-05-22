package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.LanguageChildService;
import kodlama.io.Devs.business.requests.languageChildRequest.CreateLanguageChildRequest;
import kodlama.io.Devs.business.requests.languageChildRequest.UpdateLanguageChildReqest;
import kodlama.io.Devs.business.responses.languageChildResponse.GetAllLanguageChildResponse;
import kodlama.io.Devs.business.responses.languageChildResponse.GetByIdLanguageChildResponse;

@RestController
@RequestMapping("/api/languageChilds")
public class LanguageChildsController {
    private LanguageChildService childService;

    

    @Autowired
    public LanguageChildsController(LanguageChildService childService) {
        this.childService = childService;
    }



    @PostMapping()
    public void add(CreateLanguageChildRequest request) {
        childService.add(request);
        
    }

    @PutMapping()
    public void update(UpdateLanguageChildReqest childReqest) {
        childService.update(childReqest);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable int id) {
        childService.remove(id);
    }

    @GetMapping("/{id}")
    public GetByIdLanguageChildResponse getById(int id) throws Exception {
        return childService.getById(id);
    }

    @GetMapping()
    public List<GetAllLanguageChildResponse> getAll() {
        return childService.getAll();
    }

    
}
