package algostyle.asmaeaouassar.banking_app.repository;

import algostyle.asmaeaouassar.banking_app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
