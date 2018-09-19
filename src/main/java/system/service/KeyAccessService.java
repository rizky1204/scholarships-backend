package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.domain.Users;
import system.exception.Exception;
import system.repository.UserRepository;

@Service
public class KeyAccessService {

    @Autowired
    UserRepository userRepository;

    public Users checkKeyAccess(String keyAccess){
        Users checkKey = userRepository.findByKeyAccess(keyAccess);
        if(checkKey == null){
            throw new Exception("Key Access invalid");
        }

        return checkKey;
    }

}
