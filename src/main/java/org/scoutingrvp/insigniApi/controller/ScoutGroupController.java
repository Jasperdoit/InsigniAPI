package org.scoutingrvp.insigniApi.controller;

import jakarta.validation.Valid;
import org.scoutingrvp.insigniApi.dto.scoutGroup.CreateScoutGroupDto;
import org.scoutingrvp.insigniApi.dto.scoutGroup.ScoutGroupDto;
import org.scoutingrvp.insigniApi.model.Scout;
import org.scoutingrvp.insigniApi.service.ScoutGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scout-groups")
public class ScoutGroupController {
    private final ScoutGroupService scoutGroupService;

    public ScoutGroupController(ScoutGroupService scoutGroupService) {
        this.scoutGroupService = scoutGroupService;
    }

    @GetMapping
    public ResponseEntity<List<ScoutGroupDto>> getAllScoutGroups() {
        List<ScoutGroupDto> scoutGroups = scoutGroupService.getScoutGroups();
        return ResponseEntity.ok(scoutGroups);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScoutGroupDto> getScoutGroupById(@PathVariable Long id) {
        ScoutGroupDto scoutGroup = scoutGroupService.getScoutGroupById(id);
        return ResponseEntity.ok(scoutGroup);
    }

    @GetMapping("/{id}/scouts")
    public ResponseEntity<List<Scout>> getScoutsByScoutGroupId(@PathVariable Long id) {
        List<Scout> scouts = scoutGroupService.getScoutsByScoutGroupId(id);
        return ResponseEntity.ok(scouts);
    }

    @PostMapping
    public ResponseEntity<ScoutGroupDto> createScoutGroup(@RequestBody @Valid CreateScoutGroupDto createDto) {
        ScoutGroupDto createdScoutGroup = scoutGroupService.createScoutGroup(createDto);
        return ResponseEntity.ok(createdScoutGroup);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScoutGroupDto> updateScoutGroup(@PathVariable Long id, @RequestBody @Valid CreateScoutGroupDto updateDto) {
        ScoutGroupDto updatedScoutGroup = scoutGroupService.updateScoutGroup(id, updateDto);
        return ResponseEntity.ok(updatedScoutGroup);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScoutGroup(@PathVariable Long id) {
        scoutGroupService.deleteScoutGroup(id);
        return ResponseEntity.noContent().build();
    }
}
