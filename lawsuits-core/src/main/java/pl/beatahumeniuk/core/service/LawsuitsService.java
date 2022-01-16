package pl.beatahumeniuk.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.beatahumeniuk.core.mapper.LawsuitMapper;
import pl.beatahumeniuk.core.model.dto.LawsuitDTO;
import pl.beatahumeniuk.core.model.entity.Lawsuit;
import pl.beatahumeniuk.core.model.entity.Plaintiff;
import pl.beatahumeniuk.core.model.enums.LawsuitCode;
import pl.beatahumeniuk.core.repository.LawsuitRepository;
import pl.beatahumeniuk.core.repository.PlaintiffRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LawsuitsService {

    private final LawsuitRepository lawsuitRepository;
    private final LawsuitMapper lawsuitMapper;
    private final PlaintiffRepository plaintiffRepository;

    public List<LawsuitDTO> getAll(){
        return lawsuitRepository.findAll().stream()
                .map(lawsuitMapper::fromDO)
                .collect(Collectors.toList());
    }

    public LawsuitDTO getOneById(Long id) {
        return lawsuitMapper.fromDO(lawsuitRepository.findById(id).orElse(null));
    }

    public LawsuitDTO getOneBySignature(String signature) {
        return lawsuitMapper.fromDO(lawsuitRepository.findBySignature(signature).orElse(null));
    }

    @Transactional
    public LawsuitDTO createLawsuit(LawsuitDTO lawsuitDTO) {
        Lawsuit lawsuit = lawsuitMapper.toDO(lawsuitDTO);
        lawsuit.setCode(LawsuitCode.CREATED);
        return lawsuitMapper.fromDO(lawsuitRepository.save(lawsuit));
    }

    public LawsuitDTO updateLawsuit(Long id, LawsuitDTO lawsuitDTO) {
        Optional<Lawsuit> lawsuitOptional = lawsuitRepository.findById(id);
        if(!lawsuitOptional.isPresent()) {
            throw new EntityNotFoundException();
        }
        updateData(lawsuitDTO, lawsuitOptional.get());
        return lawsuitMapper.fromDO(lawsuitRepository.saveAndFlush(lawsuitOptional.get()));
    }

    private void updateData(LawsuitDTO lawsuitDTO, Lawsuit lawsuit) {
        doIfValue(lawsuitDTO.getCode(), Objects::nonNull, lawsuit::setCode);
        doIfValue(lawsuitDTO.getLawsuitResponse(), Objects::nonNull, lawsuit::setLawsuitResponse);
        doIfValue(lawsuitDTO.getSignature(), Objects::nonNull, lawsuit::setSignature);
    }

    private <T> void doIfValue(T value, Predicate<T> predicate, Consumer<T> consumer) {
        if (predicate.test(value)) {
            consumer.accept(value);
        }
    }
}
