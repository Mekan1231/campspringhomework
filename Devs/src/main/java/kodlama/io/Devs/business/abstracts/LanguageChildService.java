package kodlama.io.Devs.business.abstracts;



import java.util.List;

import kodlama.io.Devs.business.requests.languageChildRequest.CreateLanguageChildRequest;
import kodlama.io.Devs.business.requests.languageChildRequest.UpdateLanguageChildReqest;
import kodlama.io.Devs.business.responses.languageChildResponse.GetAllLanguageChildResponse;

public interface LanguageChildService {
    void add(CreateLanguageChildRequest childRequest);
    void update(UpdateLanguageChildReqest childRequest);
    void remove(int id );
    GetAllLanguageChildResponse getById(int id) throws Exception;
    List<GetAllLanguageChildResponse> getAll();



}
