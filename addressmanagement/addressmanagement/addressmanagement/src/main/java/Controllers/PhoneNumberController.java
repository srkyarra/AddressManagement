package Controllers;



import Entity.PhoneNumber;
import Services.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/phoneNumbers")
public class PhoneNumberController {

    @Autowired
    private PhoneNumberService phoneNumberService;

    @GetMapping
    public List<PhoneNumber> getAllPhoneNumbers() {
        return phoneNumberService.getAllPhoneNumbers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhoneNumber> getPhoneNumberById(@PathVariable Long id) {
        Optional<PhoneNumber> phoneNumber = phoneNumberService.getPhoneNumberById(id);
        return phoneNumber.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PhoneNumber createPhoneNumber(@RequestBody PhoneNumber phoneNumber) {
        return phoneNumberService.savePhoneNumber(phoneNumber);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhoneNumber> updatePhoneNumber(@PathVariable Long id, @RequestBody PhoneNumber phoneNumber) {
        if (phoneNumberService.getPhoneNumberById(id).isPresent()) {
            phoneNumber.setId(id);
            return ResponseEntity.ok(phoneNumberService.savePhoneNumber(phoneNumber));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhoneNumber(@PathVariable Long id) {
        if (phoneNumberService.getPhoneNumberById(id).isPresent()) {
            phoneNumberService.deletePhoneNumber(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

