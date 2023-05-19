package kodlama.io.Devs.business.responses.languageResponse;

import java.util.List;

import kodlama.io.Devs.entities.concretes.LanguageChild;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllLanguageResponse {
    private String name;
    private int  id;
    private List<LanguageChild> child;
}
