package package1;

import org.springframework.data.mongodb.repository.MongoRepository;
/**
 * 
 * @author pasha
 *
 */
public interface UserRepository extends MongoRepository<User, String> {

    public User findOneByName(String name);

}