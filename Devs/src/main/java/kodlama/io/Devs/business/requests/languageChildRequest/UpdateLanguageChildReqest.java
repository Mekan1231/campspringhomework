package kodlama.io.Devs.business.requests.languageChildRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLanguageChildReqest {
    private int  id;
    private int  languageId;
    private String name;
}
