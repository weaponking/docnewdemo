package com.mine.docdemo.strategy;

import com.mine.docdemo.common.StateNotSupportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StrategyService {

    @Autowired
    private List<IStrategy> strategyList;

    public void doService(TestVo testVo) {
        System.out.println(testVo.toString());
       Optional<IStrategy> strategyOpt = strategyList.stream()
           .filter(strategy -> strategy.support(testVo.getStates())).findAny();
       if(strategyOpt.isPresent()) {
           IStrategy strategy = strategyOpt.get();
           strategy.doService(testVo);
           return;
       }
       throw new RuntimeException("state not support");
    }
}
