package ru.skillfactory.demo.tgbot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skillfactory.demo.tgbot.entity.Income;
import ru.skillfactory.demo.tgbot.entity.Spend;
import ru.skillfactory.demo.tgbot.repository.IncomeRepository;
import ru.skillfactory.demo.tgbot.repository.SpendRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class FinanceService {

    private static final String ADD_INCOME = "/addincome";

    private final IncomeRepository incomeRepository;
    private final SpendRepository spendRepository;

    public String addFinanceOperation(String operationType, String price, Long chatId) {
        String message;
        if (ADD_INCOME.equalsIgnoreCase(operationType)) {
            Income income = new Income();
            income.setChatId(chatId);
            income.setIncome(new BigDecimal(price));
            incomeRepository.save(income);
            message = "Доход в размере " + price + " был успешно добавлен";
        } else {
            Spend spend = new Spend();
            spend.setChatId(chatId);
            spend.setSpend(new BigDecimal(price));
            spendRepository.save(spend);
            message = "Расход в размере " + price + " был успешно добавлен";
        }
        return message;
    }
}
