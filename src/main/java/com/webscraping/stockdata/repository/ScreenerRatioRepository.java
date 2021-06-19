package com.webscraping.stockdata.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webscraping.stockdata.entity.ScreenerRatioEntity;


@Repository
public interface ScreenerRatioRepository extends JpaRepository<ScreenerRatioEntity, Long> {


}
