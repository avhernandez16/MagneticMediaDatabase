package magneticmedia.magneticmedia.repositories;

import magneticmedia.magneticmedia.models.Catalogue;
import magneticmedia.magneticmedia.models.CatalogueId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatalogueRepository extends JpaRepository<Catalogue, CatalogueId> {
    Optional<Catalogue> findByCatalogueId(CatalogueId catalogueId);
}
