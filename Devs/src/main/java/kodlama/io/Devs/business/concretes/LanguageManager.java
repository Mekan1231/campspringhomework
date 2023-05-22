package kodlama.io.Devs.business.concretes;

import java.util.List;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.business.requests.languageRequest.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.languageRequest.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.languageResponse.GetAllLanguageResponse;
import kodlama.io.Devs.business.responses.languageResponse.GetByIdLanguagesResponse;
import kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import kodlama.io.Devs.dataAccess.abstracts.LanguageChildRepository;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService {

    LanguageRepository  languageRepository;
    LanguageChildRepository childRepository;
    ModelMapperService mapperService;
    


    @Override
    public void add(CreateLanguageRequest request) {
        Language lng= this.mapperService.forRequest()
        .map(request, Language.class);
        this.languageRepository.save(lng);
    }

    @Override
    public void update(UpdateLanguageRequest request) {
        Language lng= this.mapperService.forRequest().map(request, Language.class);
        this.languageRepository.save(lng);

        
    }

    @Override
    public void remove(int id) {
        this.languageRepository.deleteById(id);
    }

    @Override
    public GetByIdLanguagesResponse getById(int id) {
        Language language= this.languageRepository.findById(id).orElse(null);
        GetByIdLanguagesResponse response = this.mapperService.forResponse()
        .map(language,GetByIdLanguagesResponse.class);

        return response;
       
    }
    @Override
    public List<GetAllLanguageResponse> getAll() {

        List<Language> languages=this.languageRepository.findAll();
        List<GetAllLanguageResponse> allLanguageResponses =languages.stream()
        .map(language->mapperService.forResponse()
        .map(language, GetAllLanguageResponse.class)).toList();

        return allLanguageResponses;

    }

    

    

    
}
