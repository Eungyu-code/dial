package mine.dial.service;

import lombok.RequiredArgsConstructor;
import mine.dial.domain.DialNumber;
import mine.dial.repository.DialRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DialService {

    private final DialRepository dialRepository;

    public List<DialNumber> findDialData() {
        return dialRepository.findAll();
    }

    public void addDial(DialNumber dialNumber) {
        validateDuplicateDial(dialNumber);
        dialRepository.save(dialNumber);
    }

    public void updateDial(Long dialId, String number, String city, String street, String zipcode, String name, String information) {

        DialNumber findDial = dialRepository.findById(dialId);
        findDial.update(number, city, street, zipcode, name, information);
    }

    private void validateDuplicateDial(DialNumber dialNumber) {
        List<DialNumber> dialNumbers = dialRepository.findByNumberAll(dialNumber.getNumber());
        if (!dialNumbers.isEmpty()) throw new IllegalStateException("이미 존재하는 번호입니다");
    }
}
