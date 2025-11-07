package org.scoutingrvp.insigniApi.service;

import org.scoutingrvp.insigniApi.repository.InsigniaRepository;
import org.springframework.stereotype.Service;

@Service
public class InsigniaService {
    private InsigniaRepository insigniaRepository;

    public InsigniaService(InsigniaRepository insigniaRepository) {
        this.insigniaRepository = insigniaRepository;
    }
}
