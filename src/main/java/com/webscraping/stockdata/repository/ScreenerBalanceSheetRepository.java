package com.webscraping.stockdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webscraping.stockdata.entity.ScreenerBalanceSheetEntity;


@Repository
public interface ScreenerBalanceSheetRepository extends JpaRepository<ScreenerBalanceSheetEntity, Long> {


}