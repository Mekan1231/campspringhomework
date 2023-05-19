package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageChildService;
import kodlama.io.Devs.business.requests.languageChildRequest.CreateLanguageChildRequest;
import kodlama.io.Devs.business.requests.languageChildRequest.UpdateLanguageChildReqest;
import kodlama.io.Devs.business.responses.languageChildResponse.GetAllLanguageChildResponse;
import kodlama.io.Devs.dataAccess.abstracts.LanguageChildRepository;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;
import kodlama.io.Devs.entities.concretes.LanguageChild;


@Service
public class LanguageChildManager implements LanguageChildService {
    LanguageChildRepository childRepository;
    LanguageRepository languageRepository;
    

    @Autowired
    public LanguageChildManager(LanguageChildRepository childRepository, LanguageRepository languageRepository ) {
        this.childRepository = childRepository;
        this.languageRepository=languageRepository;
        
    }

    @Override
    public void add(CreateLanguageChildRequest childRequest) {
        LanguageChild child= new LanguageChild();
        Language language = this.languageRepository.findById(childRequest.getLanguageId()).get();
        child.setName(childRequest.getName());
        child.setLanguage(language);
        this.childRepository.save(child);
    }

    @Override
    public void update(UpdateLanguageChildReqest childRequest) {
        LanguageChild child = new LanguageChild();
        child=this.childRepository.findById(childRequest.getId()).get();
        Language language = this.languageRepository.findById(childRequest.getLanguageId()).get(); 
        child.setName(childRequest.getName());
        child.setLanguage(language);
    }

    @Override
    public void remove(int id) {
        this.childRepository.deleteById(id);
        
    }

    @Override
    public GetAllLanguageChildResponse getById(int id) throws Exception {
        LanguageChild child = new LanguageChild();
        child=this.childRepository.findById(id).orElse(null);
        if (child!=null) {
            return new GetAllLanguageChildResponse(child.getChildId(),child.getName());
        }

        throw new Exception("Bu id nolu alt teknoloji bulunamadı");
    }

    @Override
    public List<GetAllLanguageChildResponse> getAll() {
        List<LanguageChild> childs = this.childRepository.findAll();
        List<GetAllLanguageChildResponse> childResponses = new ArrayList<GetAllLanguageChildResponse>();
        for (LanguageChild child : childs) {
            GetAllLanguageChildResponse childResponse= new GetAllLanguageChildResponse();
            childResponse.setId(child.getChildId());
            childResponse.setName(child.getName());
            childResponses.add(childResponse);
        }

        return childResponses;
    }
    
}
