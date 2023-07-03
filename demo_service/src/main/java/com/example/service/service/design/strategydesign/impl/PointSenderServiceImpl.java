package com.example.service.service.design.strategydesign.impl;

import com.example.service.service.design.strategydesign.IPriceSenderService;
import com.example.service.service.design.strategydesign.model.SendPriceDTO;
import org.springframework.stereotype.Service;

@Service
public class PointSenderServiceImpl implements IPriceSenderService {
    @Override
    public boolean support(SendPriceDTO dto) {
        return false;
    }

    @Override
    public void sendPrice(SendPriceDTO dto) {

    }
}
