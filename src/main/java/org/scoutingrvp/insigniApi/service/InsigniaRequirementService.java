package org.scoutingrvp.insigniApi.service;

import jakarta.persistence.EntityNotFoundException;
import org.scoutingrvp.insigniApi.dto.insigniaRequirement.CreateInsigniaRequirementDto;
import org.scoutingrvp.insigniApi.dto.insigniaRequirement.InsigniaRequirementDto;
import org.scoutingrvp.insigniApi.model.InsigniaRequirement;
import org.scoutingrvp.insigniApi.repository.InsigniaRequirementRepository;
import org.scoutingrvp.insigniApi.util.mapper.InsigniaRequirementMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsigniaRequirementService {
    private final InsigniaRequirementRepository insigniaRequirementRepository;
    private final InsigniaRequirementMapper insigniaRequirementMapper;

    public InsigniaRequirementService(
            InsigniaRequirementRepository insigniaRequirementRepository,
            InsigniaRequirementMapper insigniaRequirementMapper
    ) {
        this.insigniaRequirementRepository = insigniaRequirementRepository;
        this.insigniaRequirementMapper = insigniaRequirementMapper;
    }

    public List<InsigniaRequirementDto> getAllInsigniaRequirements() {
        return insigniaRequirementRepository.findAll()
                .stream()
                .map(insigniaRequirementMapper::toDto)
                .toList();
    }

    public Optional<InsigniaRequirementDto> getInsigniaRequirementById(Long id) {
        return insigniaRequirementRepository.findById(id)
                .map(insigniaRequirementMapper::toDto);
    }

    public List<InsigniaRequirementDto> getInsigniaRequirementsByInsigniaId(Long insigniaId) {
        return insigniaRequirementRepository.findByInsigniaId(insigniaId)
                .stream()
                .map(insigniaRequirementMapper::toDto)
                .toList();
    }

    public InsigniaRequirementDto createInsigniaRequirement(CreateInsigniaRequirementDto insigniaRequirementDto) {
        InsigniaRequirement insigniaRequirement = new InsigniaRequirement();
        insigniaRequirement.setName(insigniaRequirementDto.getName());
        insigniaRequirement.setDescription(insigniaRequirementDto.getDescription());

        InsigniaRequirement savedInsigniaRequirement = insigniaRequirementRepository.save(insigniaRequirement);
        return insigniaRequirementMapper.toDto(savedInsigniaRequirement);
    }

    public InsigniaRequirementDto updateInsigniaRequirement(Long id, CreateInsigniaRequirementDto insigniaRequirementDto) {
        InsigniaRequirement InsigniaRequirement = insigniaRequirementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("InsigniaRequirement not found"));
        InsigniaRequirement.setName(insigniaRequirementDto.getName());
        InsigniaRequirement.setDescription(insigniaRequirementDto.getDescription());

        InsigniaRequirement savedInsigniaRequirement = insigniaRequirementRepository.save(InsigniaRequirement);
        return insigniaRequirementMapper.toDto(savedInsigniaRequirement);
    }

    public void deleteInsigniaRequirement(Long id) {
        InsigniaRequirement InsigniaRequirement = insigniaRequirementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("InsigniaRequirement not found"));
        insigniaRequirementRepository.delete(InsigniaRequirement);
    }
}
