package kodlama.io.Devs.business.requests.languageChildRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateLanguageChildRequest {
    private int languageId;
    private String name;
}
