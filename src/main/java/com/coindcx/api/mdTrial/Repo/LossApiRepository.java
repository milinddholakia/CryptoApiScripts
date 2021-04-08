package com.coindcx.api.mdTrial.Repo;

import com.coindcx.api.mdTrial.pojo.LossMarkets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface LossApiRepository extends JpaRepository <LossMarkets,String>{

//    @Query("SELECT  s from TickerData  s where s.market=?1")
//    TickerData findByMarket(String market);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO LOSSMARKET(MARKET,PERCENTAGELOSS) values (?1,?2) ",nativeQuery = true)
    LossMarkets insertLoss(String loss,Float percentage);

}
