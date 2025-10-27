package org.scoutingrvp.insigniApi.controller;

import org.scoutingrvp.insigniApi.dto.scout.CreateScoutDto;
import org.scoutingrvp.insigniApi.dto.scout.ScoutDto;
import org.scoutingrvp.insigniApi.dto.scout.UpdateScoutDto;
import org.scoutingrvp.insigniApi.service.ScoutGroupService;
import org.scoutingrvp.insigniApi.service.ScoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/scouts")
public class ScoutController {
    private final ScoutService scoutService;
    private final ScoutGroupService scoutGroupService;

    public ScoutController(ScoutService scoutService, ScoutGroupService scoutGroupService) {
        this.scoutService = scoutService;
        this.scoutGroupService = scoutGroupService;
    }

    @GetMapping
    public ResponseEntity<List<ScoutDto>> getScouts() {
        List<ScoutDto> scouts = scoutService.getAllScouts();
        return ResponseEntity.ok(scouts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScoutDto> getScoutById(@PathVariable Integer id) {
        ScoutDto scout = scoutService.getScoutById(id);
        return ResponseEntity.ok(scout);
    }

    @PostMapping
    public ResponseEntity<ScoutDto> createScout(@RequestBody CreateScoutDto scoutDto) {
        ScoutDto createdScout = scoutService.createScout(scoutDto);
        return ResponseEntity.ok(createdScout);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScoutDto> updateScout(@PathVariable Integer id, @RequestBody UpdateScoutDto updateDto) {
        ScoutDto updatedScout = scoutService.updateScout(id, updateDto);
        return ResponseEntity.ok(updatedScout);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScout(@PathVariable Integer id) {
        scoutService.deleteScout(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{scoutId}/groups/{groupId}")
    public ResponseEntity<ScoutDto> assignScoutToGroup(@PathVariable Integer scoutId, @PathVariable Integer groupId) {
        ScoutDto updatedScout = scoutService.assignScoutToGroup(scoutId, groupId);
        return ResponseEntity.ok(updatedScout);
    }
}
