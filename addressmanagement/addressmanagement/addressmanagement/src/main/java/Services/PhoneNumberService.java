package Services;



import Entity.PhoneNumber;
import Repositories.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneNumberService {

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    public List<PhoneNumber> getAllPhoneNumbers() {
        return phoneNumberRepository.findAll();
    }

    public Optional<PhoneNumber> getPhoneNumberById(Long id) {
        return phoneNumberRepository.findById(id);
    }

    public PhoneNumber savePhoneNumber(PhoneNumber phoneNumber) {
        return phoneNumberRepository.save(phoneNumber);
    }

    public void deletePhoneNumber(Long id) {
        phoneNumberRepository.deleteById(id);
    }
}

