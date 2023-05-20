package kodlama.io.Devs.business.responses.languageResponse;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllLanguageResponse {
    private String name;
    private int  id;
    private List<String> childName;
}
