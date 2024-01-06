package com.product.chair.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.product.chair.business.bean.ChairBean;
import com.product.chair.service.ChairService;

import java.util.List;

@RestController
@RequestMapping("/chairs")
@Validated
public class ChairController {

    private final ChairService chairService;

    @Autowired
    public ChairController(ChairService chairService) {
        this.chairService = chairService;
    }

    @GetMapping
    public List<ChairBean> getAllChairs() {
        return chairService.getAllChairs();
    }

    @GetMapping("/{chairId}")
    public ResponseEntity<ChairBean> getChairById(@PathVariable Long chairId) {
        return chairService.getChairById(chairId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ChairBean createChair(@Validated @RequestBody ChairBean chair) {
        return chairService.saveChair(chair);
    }

    @PutMapping("/{chairId}")
    public ResponseEntity<ChairBean> updateChair(@PathVariable Long chairId, @Validated @RequestBody ChairBean updatedChair) {
    	return chairService.getChairById(chairId)
                .map(existingChair -> {
                    existingChair.setChairName(updatedChair.getChairName());
                    existingChair.setColor(updatedChair.getColor());
                    existingChair.setLeasePrice(updatedChair.getLeasePrice());
                    existingChair.setAvailable(updatedChair.getAvailable());
                    return ResponseEntity.ok(chairService.saveChair(existingChair));
                })
                .orElse(ResponseEntity.notFound().build());
                
    }

    @DeleteMapping("/{chairId}")
    public ResponseEntity<Void> deleteChair(@PathVariable Long chairId) {
        chairService.deleteChair(chairId);
        return ResponseEntity.noContent().build();
    }
}
