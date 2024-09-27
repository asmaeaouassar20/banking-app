package algostyle.asmaeaouassar.banking_app.mapper;

import algostyle.asmaeaouassar.banking_app.dto.AccountDto;
import algostyle.asmaeaouassar.banking_app.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto){
        Account account=new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getAccountBalance()
        );
        return account;
    }

    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto=new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getAccountBalance()
        );
        return accountDto;
    }
}
