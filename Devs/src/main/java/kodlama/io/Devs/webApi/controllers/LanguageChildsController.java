package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.LanguageChildService;
import kodlama.io.Devs.business.requests.languageChildRequest.CreateLanguageChildRequest;
import kodlama.io.Devs.business.requests.languageChildRequest.UpdateLanguageChildReqest;
import kodlama.io.Devs.business.responses.languageChildResponse.GetAllLanguageChildResponse;

@RestController
@RequestMapping("/api/languageChilds")
public class LanguageChildsController {
    private LanguageChildService childService;

    

    @Autowired
    public LanguageChildsController(LanguageChildService childService) {
        this.childService = childService;
    }



    @PostMapping("/add")
    public void add(CreateLanguageChildRequest request) {
        childService.add(request);
        
    }

    @PostMapping("/update")
    public void update(UpdateLanguageChildReqest childReqest) {
        childService.update(childReqest);
    }

    @PostMapping("/remove")
    public void remove(int id) {
        childService.remove(id);
    }

    @GetMapping("/getbyid")
    public GetAllLanguageChildResponse getById(int id) throws Exception {
        return childService.getById(id);
    }

    @GetMapping("/getall")
    public List<GetAllLanguageChildResponse> getAll() {
        return childService.getAll();
    }

    
}
