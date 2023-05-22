package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageChildService;
import kodlama.io.Devs.business.requests.languageChildRequest.CreateLanguageChildRequest;
import kodlama.io.Devs.business.requests.languageChildRequest.UpdateLanguageChildReqest;
import kodlama.io.Devs.business.responses.languageChildResponse.GetAllLanguageChildResponse;
import kodlama.io.Devs.business.responses.languageChildResponse.GetByIdLanguageChildResponse;
import kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import kodlama.io.Devs.dataAccess.abstracts.LanguageChildRepository;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.LanguageChild;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class LanguageChildManager implements LanguageChildService {
    LanguageChildRepository childRepository;
    LanguageRepository languageRepository;
    ModelMapperService mapperService;
    

        
        
   
    @Override
    public void add(CreateLanguageChildRequest childRequest) {
        LanguageChild child= this.mapperService.forRequest().map(childRequest, LanguageChild.class);
        this.childRepository.save(child);
    }

    @Override
    public void update(UpdateLanguageChildReqest childRequest) {
        LanguageChild child = this.mapperService.forRequest().map(childRequest, LanguageChild.class);
        this.childRepository.save(child);
        
    }
    @Override
    public void remove(int id) {
        this.childRepository.deleteById(id);
        
    }

    @Override
    public GetByIdLanguageChildResponse getById(int id) throws Exception {
        LanguageChild child = this.childRepository.findById(id).orElse(null);
        GetByIdLanguageChildResponse response = this.mapperService.forResponse()
        .map(child, GetByIdLanguageChildResponse.class);

        return response;
    }

    @Override
    public List<GetAllLanguageChildResponse> getAll() {
        List<LanguageChild> childs = this.childRepository.findAll();
        List<GetAllLanguageChildResponse> childResponses = childs.stream()
        .map(child->this.mapperService.forResponse()
        .map(child, GetAllLanguageChildResponse.class )).toList();

        return childResponses;
    }
    
}
