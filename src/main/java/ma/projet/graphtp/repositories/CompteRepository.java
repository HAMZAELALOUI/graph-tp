package ma.projet.graphtp.repositories;

import ma.projet.graphtp.entities.Compte;
import ma.projet.graphtp.entities.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
    List<Compte> findByType(TypeCompte type);

    @Query("SELECT SUM(c.solde) FROM Compte c")
    double sumSoldes();
}
