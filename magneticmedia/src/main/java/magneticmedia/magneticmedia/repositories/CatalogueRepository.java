package magneticmedia.magneticmedia.repositories;

import magneticmedia.magneticmedia.models.Catalogue;
    import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogueRepository extends CrudRepository<Catalogue, String> {}
