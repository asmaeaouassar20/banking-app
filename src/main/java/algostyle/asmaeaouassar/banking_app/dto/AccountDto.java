package algostyle.asmaeaouassar.banking_app.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

@Data
@AllArgsConstructor
public class AccountDto{
    private Long id;
    private String accountHolderName;
    private double accountBalance;
}
