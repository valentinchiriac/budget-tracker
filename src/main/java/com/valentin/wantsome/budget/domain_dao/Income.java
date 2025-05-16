package com.valentin.wantsome.budget.domain_dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="income")
public class Income {
    @Id
    @GeneratedValue
    private Long incomeId;
    private Date incomeDate;
    private String incomeName;
    private double amount;
    private Long categoryId;

    public Income() {
    }

    public Income(Long incomeId, Date incomeDate, String incomeName, double amount, Long categoryId) {
        this.incomeId = incomeId;
        this.incomeDate = incomeDate;
        this.incomeName = incomeName;
        this.amount = amount;
        this.categoryId = categoryId;
    }

    public Long getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Long incomeId) {
        this.incomeId = incomeId;
    }

    public Date getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(Date incomeDate) {
        this.incomeDate = incomeDate;
    }

    public String getIncomeName() {
        return incomeName;
    }

    public void setIncomeName(String incomeName) {
        this.incomeName = incomeName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Income income = (Income) o;
        return Double.compare(amount, income.amount) == 0 && Objects.equals(incomeId, income.incomeId) && Objects.equals(incomeDate, income.incomeDate) && Objects.equals(incomeName, income.incomeName) && Objects.equals(categoryId, income.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(incomeId, incomeDate, incomeName, amount, categoryId);
    }

    @Override
    public String toString() {
        return "income{" +
                "incomeId=" + incomeId +
                ", incomeDate=" + incomeDate +
                ", incomeName='" + incomeName + '\'' +
                ", amount=" + amount +
                ", categoryId=" + categoryId +
                '}';
    }

    public void add(Income income) {
    }
}
