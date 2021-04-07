package com.coindcx.api.mdTrial.Repo;

import com.coindcx.api.mdTrial.pojo.ProfitMarkets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfitApiRepository extends JpaRepository <ProfitMarkets,String>{

//    @Query("SELECT  s from TickerData  s where s.market=?1")
//    TickerData findByMarket(String market);

}
