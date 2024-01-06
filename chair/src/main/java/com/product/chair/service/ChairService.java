package com.product.chair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.chair.business.bean.ChairBean;
import com.product.chair.repo.ChairRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ChairService {

    private final ChairRepository chairRepository;

    @Autowired
    public ChairService(ChairRepository chairRepository) {
        this.chairRepository = chairRepository;
    }

    public List<ChairBean> getAllChairs() {
        return chairRepository.findAll();
    }

    public Optional<ChairBean> getChairById(Long chairId) {
        return chairRepository.findById(chairId);
    }

    public ChairBean saveChair(ChairBean chair) {
        return chairRepository.save(chair);
    }

    public void deleteChair(Long chairId) {
        chairRepository.deleteById(chairId);
    }
}
