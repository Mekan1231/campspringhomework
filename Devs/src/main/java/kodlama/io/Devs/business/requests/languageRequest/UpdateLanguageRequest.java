package kodlama.io.Devs.business.requests.languageRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLanguageRequest {
    private int  id;
    private String name;
}
