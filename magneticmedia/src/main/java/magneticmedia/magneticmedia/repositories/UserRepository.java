package magneticmedia.magneticmedia.repositories;

import magneticmedia.magneticmedia.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
