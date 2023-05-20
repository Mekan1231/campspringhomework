package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.business.requests.languageRequest.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.languageRequest.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.languageResponse.GetAllLanguageResponse;
import kodlama.io.Devs.dataAccess.abstracts.LanguageChildRepository;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;
import kodlama.io.Devs.entities.concretes.LanguageChild;

@Service
public class LanguageManager implements LanguageService {

    LanguageRepository  languageRepository;
    LanguageChildRepository childRepository;
    
    
    
    @Autowired
    public LanguageManager(LanguageRepository languageRepository, LanguageChildRepository childRepository) {
        this.languageRepository = languageRepository;
        this.childRepository=childRepository;
        
    }

    @Override
    public void add(CreateLanguageRequest request) {
        Language lng= new Language();
        lng.setName(request.getName());
        this.languageRepository.save(lng);
    }

    @Override
    public void update(UpdateLanguageRequest request) {
        Language lng= new Language();
        lng=this.languageRepository.findById(request.getId()).get();
        lng.setName(request.getName());
        
        this.languageRepository.saveAndFlush(lng);

        
    }

    @Override
    public void remove(int id) {
        this.languageRepository.deleteById(id);
    }

    @Override
    public GetAllLanguageResponse getById(int id) {
        Language language= this.languageRepository.findById(id).orElse(null);
        GetAllLanguageResponse response = new GetAllLanguageResponse();
        List<String> childNames= new ArrayList<String>();
        for (LanguageChild child : language.getLanguageChild()) {
            childNames.add(child.getName());
        }
        response.setId(language.getId());
        response.setName(language.getName());
        response.setChildName(childNames);
        return response;
    }

    @Override
    public List<GetAllLanguageResponse> getAll() {
        List<Language> languages=this.languageRepository.findAll();
        
        List<GetAllLanguageResponse> responses= new ArrayList<GetAllLanguageResponse>();
        for (Language language : languages) {
            List<String> childNames= new ArrayList<String>();
            for (LanguageChild child  : language.getLanguageChild()) {
                childNames.add(child.getName());
            }
            GetAllLanguageResponse response = new GetAllLanguageResponse();
            response.setId(language.getId());
            response.setName(language.getName());
            response.setChildName(childNames);
            responses.add(response);
        }

        return responses;
    }

    

    

    
}
