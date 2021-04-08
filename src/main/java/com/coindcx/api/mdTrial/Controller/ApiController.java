package com.coindcx.api.mdTrial.Controller;

import com.coindcx.api.mdTrial.Repo.CryptoApiRepository;
import com.coindcx.api.mdTrial.Repo.LossApiRepository;
import com.coindcx.api.mdTrial.Repo.ProfitApiRepository;
import com.coindcx.api.mdTrial.pojo.LossMarkets;
import com.coindcx.api.mdTrial.pojo.ProfitMarkets;
import com.coindcx.api.mdTrial.pojo.TickerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

            for (int i=0;  result.length-1>i;i++) {
                TickerData tickerData = result[i];
                ProfitMarkets profitMarkets = new ProfitMarkets();
                LossMarkets lossMarkets = new LossMarkets();
                TickerData comparePrevious = cryptoApiRepository.findByMarket(tickerData.getMarket());
                float oldPrice =Float.parseFloat(comparePrevious.getLast_price());
                float newPrice =Float.parseFloat(tickerData.getLast_price());
                float percentage ;

                percentage = (((newPrice-oldPrice)*100)/oldPrice);
                if (percentage<0) {
                    lossMarkets.setMarket(tickerData.getMarket());

                    lossMarkets.setPercentageLoss(percentage);

                    lossApiRepository.save(lossMarkets);
                    System.out.println("loss saved");

                } else {
                    profitMarkets.setMarket(tickerData.getMarket());
                    profitMarkets.setPercentageGrowth(percentage);
                    profitApiRepository.save(profitMarkets);
                    System.out.println("Profit saved");

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

