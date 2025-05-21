//package com.valentin.wantsome.budget.domain_dao;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Arrays;
//
//@Configuration
//public class ExpenseCategoryInitializer {
//
//    @Bean
//    CommandLineRunner initDatabase(ExpenseCategoryRepository repository) {
//        return args -> {
//            Arrays.stream(ExpenseCategoryType.values())
//                    .map(categoryType -> new ExpenseCategory(null, categoryType))
//                    .forEach(repository::save);
//            System.out.println("Expense categories initialized!");
//        };
//    }
//}
