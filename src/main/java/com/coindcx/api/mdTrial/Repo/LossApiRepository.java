package com.coindcx.api.mdTrial.Repo;

import com.coindcx.api.mdTrial.pojo.LossMarkets;
import com.coindcx.api.mdTrial.pojo.TickerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LossApiRepository extends JpaRepository <LossMarkets,String>{

//    @Query("SELECT  s from TickerData  s where s.market=?1")
//    TickerData findByMarket(String market);

}
