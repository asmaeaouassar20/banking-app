package algostyle.asmaeaouassar.banking_app.controller;


import algostyle.asmaeaouassar.banking_app.dto.AccountDto;
import algostyle.asmaeaouassar.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Add Account REST API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }


    // Get Account REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto=accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }
    /* La méthode ci-dessus est utilisée pour envoyer une réponse standardisée depuis un service web
     * La méthode retourne une réponse HTTP avec:
        - Le corps : Un objet "AccountDto"
        - Le statut HTTP : 200OK (succes)
    */



    // deposit REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(
            @PathVariable Long id,
            @RequestBody Map<String,Double> request
    ){
        AccountDto accountDto=accountService.deposit(id,request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    // withdraw REST API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(
            @PathVariable Long id,
            @RequestBody Map<String,Double> request
    ){
        AccountDto accountDto=accountService.withdraw(id,request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }


    // Get all accounts REST API
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accountDtoList=accountService.getAllAccounts();
        return ResponseEntity.ok(accountDtoList);
    }


    // Delete account REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccountById(@PathVariable Long id){
        accountService.deleteAccountById(id);
        return ResponseEntity.ok("account with is "+id+" is deleted successfully");
    }
}
