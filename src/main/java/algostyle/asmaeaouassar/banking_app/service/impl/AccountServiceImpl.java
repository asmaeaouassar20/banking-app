package algostyle.asmaeaouassar.banking_app.service.impl;

import algostyle.asmaeaouassar.banking_app.dto.AccountDto;
import algostyle.asmaeaouassar.banking_app.entity.Account;
import algostyle.asmaeaouassar.banking_app.mapper.AccountMapper;
import algostyle.asmaeaouassar.banking_app.repository.AccountRepository;
import algostyle.asmaeaouassar.banking_app.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account accountFromDB=accountRepository.findById(id).orElseThrow(()->new RuntimeException("the given id does not exist in DB"));
        return AccountMapper.mapToAccountDto(accountFromDB);
    }


    @Override
    public AccountDto deposit(Long id,double amount){
        Account accountFromDB=accountRepository.findById(id).orElseThrow(()->new RuntimeException("given id does not exist"));
        accountFromDB.setAccountBalance(accountFromDB.getAccountBalance()+amount);
        Account savedAccount=accountRepository.save(accountFromDB);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id,double amount){
        Account accountFromDB=accountRepository.findById(id).orElseThrow(()->new RuntimeException("given id does not exist"));
        if(accountFromDB.getAccountBalance()<amount){
            throw new RuntimeException("unable to withdraw this amount");
        }

        accountFromDB.setAccountBalance(accountFromDB.getAccountBalance()-amount);
        Account savedAccount=accountRepository.save(accountFromDB);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts(){
        List<Account> accounts=accountRepository.findAll();
        return accounts.stream()
                .map(
                        (account)->AccountMapper.mapToAccountDto(account)
                    )
                   .collect(Collectors.toList());    // map entity to dto
    }


    @Override
    public void deleteAccountById(Long id){
        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("given id does not exist"));
        accountRepository.deleteById(id);
    }
}
