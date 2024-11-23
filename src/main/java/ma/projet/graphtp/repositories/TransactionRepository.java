package ma.projet.graphtp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.projet.graphtp.entities.Compte;
import ma.projet.graphtp.entities.Transaction;
import ma.projet.graphtp.entities.TypeTransaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
    List<Transaction> findByCompte(Compte compte);

    @Query("SELECT SUM(t.montant) FROM Transaction t WHERE t.type = :type")
    Double sumByType(@Param("type") TypeTransaction type);


}
