package kodlama.io.Devs.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.business.requests.languageChildRequest.UpdateLanguageChildReqest;
import kodlama.io.Devs.business.requests.languageRequest.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.languageRequest.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.languageResponse.GetAllLanguageResponse;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

    LanguageRepository  languageRepository;
    List<Language> languages;
    
    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
        this.languages=languageRepository.findAll();
    }

    @Override
    public void add(CreateLanguageRequest request) {
        Language lng= new Language();
        lng.setName(request.getName());
        this.languageRepository.save(lng);
    }

    @Override
    public void update(UpdateLanguageRequest request, UpdateLanguageChildReqest childRequest) {
        Language lng= new Language();
        Optional<Language> optional=this.languageRepository.findById(request.getId());

        
    }

    @Override
    public void remove(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public GetAllLanguageResponse getById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public List<GetAllLanguageResponse> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    

    

    
}
