package com.webscraping.stockdata.service;

import java.util.List;
import com.webscraping.stockdata.entity.ScreenerRatioEntity;
public interface ScreenerDataService {

    List<ScreenerRatioEntity> findAll();
    ScreenerRatioEntity save(ScreenerRatioEntity screenerRatioEntity);
    ScreenerRatioEntity findById(Long id);
    void delete(Long id);

}
