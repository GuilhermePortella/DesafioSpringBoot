package dasafio.bank.springboot.controller;

import java.util.DoubleSummaryStatistics;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dasafio.bank.springboot.dto.StatisticsResponse;
import dasafio.bank.springboot.service.TransactionService;

@RestController
@RequestMapping("/estatisticas")
public class StatisticsController {
    
    private final TransactionService transactionService;

    public StatisticsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<StatisticsResponse> getStatistics () {
        DoubleSummaryStatistics stats = transactionService.getTransactionStatistics();
        return ResponseEntity.ok(new StatisticsResponse(stats));
    }
}
