package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.languageChildRequest.UpdateLanguageChildReqest;
import kodlama.io.Devs.business.requests.languageRequest.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.languageRequest.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.languageResponse.GetAllLanguageResponse;

public interface LanguageService {
    void add(CreateLanguageRequest request);
    void update(UpdateLanguageRequest request, UpdateLanguageChildReqest childRequest);
    void remove(int id);
    GetAllLanguageResponse getById(int id);
    List<GetAllLanguageResponse> getAll();
}
