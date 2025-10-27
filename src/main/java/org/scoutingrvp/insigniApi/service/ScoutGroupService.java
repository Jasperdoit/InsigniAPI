package org.scoutingrvp.insigniApi.service;

import jakarta.persistence.EntityNotFoundException;
import org.scoutingrvp.insigniApi.dto.scoutGroup.CreateScoutGroupDto;
import org.scoutingrvp.insigniApi.dto.scoutGroup.ScoutGroupDto;
import org.scoutingrvp.insigniApi.exception.ScoutGroupExistsException;
import org.scoutingrvp.insigniApi.model.Scout;
import org.scoutingrvp.insigniApi.model.ScoutGroup;
import org.scoutingrvp.insigniApi.repository.ScoutGroupRepository;
import org.scoutingrvp.insigniApi.util.mapper.ScoutGroupMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoutGroupService {

    private final ScoutGroupRepository scoutGroupRepository;
    private final ScoutGroupMapper scoutGroupMapper;

    public ScoutGroupService(ScoutGroupRepository scoutGroupRepository, ScoutGroupMapper scoutGroupMapper) {
        this.scoutGroupRepository = scoutGroupRepository;
        this.scoutGroupMapper = scoutGroupMapper;
    }

    public List<ScoutGroupDto> getScoutGroups() {
        return scoutGroupRepository.findAll().stream().map(scoutGroupMapper::toDto).toList();
    }

    public ScoutGroupDto getScoutGroupById(Long id) {
        ScoutGroup scoutGroup = scoutGroupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Scout group with id " + id + " could not be found"));
        return scoutGroupMapper.toDto(scoutGroup);
    }

    public List<Scout> getScoutsByScoutGroupId(Long id) {
        ScoutGroup scoutGroup = scoutGroupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Scout group with id " + id + " could not be found"));
        return scoutGroup.getScouts();
    }

    public ScoutGroupDto createScoutGroup(CreateScoutGroupDto createDto) {
        if (scoutGroupRepository.existsByName(createDto.getName())) {
            throw new ScoutGroupExistsException("ScoutGroup with name " + createDto.getName() + " already exists");
        }
        ScoutGroup scoutGroup = new ScoutGroup();
        scoutGroup.setName(createDto.getName());

        ScoutGroup savedScoutGroup = scoutGroupRepository.save(scoutGroup);

        ScoutGroupDto scoutGroupDto = new ScoutGroupDto();
        scoutGroupDto.setId(savedScoutGroup.getId());
        scoutGroupDto.setName(savedScoutGroup.getName());
        scoutGroupDto.setScoutCount(savedScoutGroup.getScouts().size());

        return scoutGroupDto;
    }

    public ScoutGroupDto updateScoutGroup(Long id, CreateScoutGroupDto updateDto) {
        ScoutGroup scoutGroup = scoutGroupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Scout group with id " + id + " could not be found"));

        scoutGroup.setName(updateDto.getName());
        ScoutGroup updatedScoutGroup = scoutGroupRepository.save(scoutGroup);

        ScoutGroupDto scoutGroupDto = new ScoutGroupDto();
        scoutGroupDto.setId(updatedScoutGroup.getId());
        scoutGroupDto.setName(updatedScoutGroup.getName());
        scoutGroupDto.setScoutCount(updatedScoutGroup.getScouts().size());

        return scoutGroupDto;
    }

    public void deleteScoutGroup(Long id) {
        ScoutGroup scoutGroup = scoutGroupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Scout group with id " + id + " could not be found"));
        scoutGroupRepository.delete(scoutGroup);
    }
}
