package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.languageRequest.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.languageRequest.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.languageResponse.GetAllLanguageResponse;
import kodlama.io.Devs.business.responses.languageResponse.GetByIdLanguagesResponse;

public interface LanguageService {
    void add(CreateLanguageRequest request);
    void update(UpdateLanguageRequest request);
    void remove(int id);
    GetByIdLanguagesResponse getById(int id);
    List<GetAllLanguageResponse> getAll();
}
