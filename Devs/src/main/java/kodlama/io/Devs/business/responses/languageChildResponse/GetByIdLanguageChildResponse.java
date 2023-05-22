package kodlama.io.Devs.business.responses.languageChildResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdLanguageChildResponse {
    private int id;
    private int  languageId;
    private String name;
}
