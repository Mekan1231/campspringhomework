package kodlama.io.Devs.business.abstracts;



import java.util.List;

import kodlama.io.Devs.business.requests.languageChildRequest.CreateLanguageChildRequest;
import kodlama.io.Devs.business.requests.languageChildRequest.UpdateLanguageChildReqest;
import kodlama.io.Devs.business.responses.languageChildResponse.GetAllLanguageChildResponse;
import kodlama.io.Devs.business.responses.languageChildResponse.GetByIdLanguageChildResponse;

public interface LanguageChildService {
    void add(CreateLanguageChildRequest childRequest);
    void update(UpdateLanguageChildReqest childRequest);
    void remove(int id );
    GetByIdLanguageChildResponse getById(int id) throws Exception;
    List<GetAllLanguageChildResponse> getAll();



}
