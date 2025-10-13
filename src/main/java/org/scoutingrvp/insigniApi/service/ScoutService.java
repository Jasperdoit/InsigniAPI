package org.scoutingrvp.insigniApi.service;

import jakarta.persistence.EntityNotFoundException;
import org.scoutingrvp.insigniApi.dto.scoutGroup.scout.CreateScoutDto;
import org.scoutingrvp.insigniApi.dto.scoutGroup.scout.ScoutDto;
import org.scoutingrvp.insigniApi.dto.scoutGroup.scout.UpdateScoutDto;
import org.scoutingrvp.insigniApi.model.Scout;
import org.scoutingrvp.insigniApi.model.ScoutGroup;
import org.scoutingrvp.insigniApi.repository.ScoutGroupRepository;
import org.scoutingrvp.insigniApi.repository.ScoutRepository;
import org.scoutingrvp.insigniApi.util.ScoutMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoutService {
    private final ScoutRepository scoutRepository;
    private final ScoutGroupRepository scoutGroupRepository;
    private final ScoutMapper scoutMapper;

    public ScoutService(ScoutRepository scoutRepository, ScoutGroupRepository scoutGroupRepository, ScoutMapper scoutMapper) {
        this.scoutRepository = scoutRepository;
        this.scoutGroupRepository = scoutGroupRepository;
        this.scoutMapper = scoutMapper;
    }

    public List<ScoutDto> getAllScouts() {
        return scoutRepository.findAll().stream().map(scoutMapper::toDto).toList();
    }

    public List<ScoutDto> getScoutsByGroupId(Integer id) {
        return scoutRepository.findAllByGroupId(id).stream().map(scoutMapper::toDto).toList();
    }

    public ScoutDto getScoutById(Integer id) {
        return scoutMapper.toDto(scoutRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Scout with id " + id + " could not be found")));
    }

    public ScoutDto createScout(CreateScoutDto createDto) {
        ScoutGroup scoutGroup = scoutGroupRepository.findById(createDto.getGroupId())
                .orElseThrow(() -> new EntityNotFoundException("Scout group with id " + createDto.getGroupId() + " could not be found"));

        Scout scout = new Scout();
        scout.setFirstName(createDto.getFirstName());
        scout.setLastName(createDto.getLastName());
        scout.setAgeGroup(createDto.getAgeGroup());
        scout.setGroup(scoutGroup);

        scoutRepository.save(scout);
        return scoutMapper.toDto(scout);
    }

    public ScoutDto updateScout(Integer id, UpdateScoutDto updateDto) {
        Scout scout = scoutRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Scout with id " + id + " could not be found"));

        scout.setFirstName(updateDto.getFirstName());
        scout.setLastName(updateDto.getLastName());
        scout.setAgeGroup(updateDto.getAgeGroup());

        Scout updatedScout = scoutRepository.save(scout);
        return scoutMapper.toDto(updatedScout);
    }

    public void deleteScout(Integer id) {
        Scout scout = scoutRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Scout with id " + id + " could not be found"));
        scoutRepository.delete(scout);
    }
}
