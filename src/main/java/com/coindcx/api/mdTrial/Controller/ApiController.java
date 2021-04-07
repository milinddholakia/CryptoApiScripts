package com.coindcx.api.mdTrial.Controller;

import com.coindcx.api.mdTrial.Repo.CryptoApiRepository;
import com.coindcx.api.mdTrial.Repo.LossApiRepository;
import com.coindcx.api.mdTrial.Repo.ProfitApiRepository;
import com.coindcx.api.mdTrial.pojo.LossMarkets;
import com.coindcx.api.mdTrial.pojo.ProfitMarkets;
import com.coindcx.api.mdTrial.pojo.TickerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Api")
public class ApiController {



    @Autowired
    CryptoApiRepository cryptoApiRepository;

    @Autowired
    LossApiRepository lossApiRepository;

    @Autowired
    ProfitApiRepository profitApiRepository;







    @GetMapping("/coinDCX/ticker")
//    @Scheduled(cron = "* * * * * *")
    public void getData()
    {
        try {
            final String uri = "https://api.coindcx.com/exchange/ticker";

            RestTemplate restTemplate = new RestTemplate();
            TickerData[] result = restTemplate.getForObject(uri, TickerData[].class);
            assert result != null;
            System.out.println("Job Started");
            for (TickerData tickerData : result) {
                ProfitMarkets profitMarkets = new ProfitMarkets();
                LossMarkets lossMarkets = new LossMarkets();
                TickerData comparePrevious = cryptoApiRepository.findByMarket(tickerData.getMarket());

                if (Float.parseFloat(comparePrevious.getLast_price()) > Float.parseFloat(tickerData.getLast_price())) {
                    lossMarkets.setMarket(tickerData.getMarket());
                    float loss ;
                    loss = ((Float.parseFloat(comparePrevious.getLast_price())) % (Float.parseFloat(tickerData.getLast_price())));
                    lossMarkets.setPercentageLoss(loss);
                    lossApiRepository.save(lossMarkets);

                } else {
                    profitMarkets.setMarket(tickerData.getMarket());
                    float profit ;
                    profit =((Float.parseFloat(comparePrevious.getLast_price())) % (Float.parseFloat(tickerData.getLast_price())));
                    profitMarkets.setPercentageGrowth(profit);
                    profitApiRepository.save(profitMarkets);
                }
                cryptoApiRepository.save(tickerData);
            }
            System.out.println("Job Ended ,Added " + result.length + "entries");
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }


}

