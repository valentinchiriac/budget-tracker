package com.valentin.wantsome.budget.domain_dao;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "expense_category")
public class ExpenseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ExpenseCategoryType categoryName;

    private String categoryType;

    @OneToMany(mappedBy = "expenseCategory",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Expense> expenses;

    public ExpenseCategory() {}

    public ExpenseCategory(Long id, ExpenseCategoryType categoryName, String categoryType) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public Long getId() {
        return id;
    }

    public ExpenseCategoryType getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(ExpenseCategoryType categoryName) {
        this.categoryName = categoryName;
    }

    public Optional<String> getCategoryType() { // ✅ Return Optional
        return Optional.ofNullable(categoryType);
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public Optional<List<Expense>> getExpenses() { // ✅ Return Optional list
        return Optional.ofNullable(expenses);
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ExpenseCategory that = (ExpenseCategory) o;
        return Objects.equals(id, that.id) && categoryName == that.categoryName && Objects.equals(categoryType, that.categoryType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName, categoryType);
    }

    @Override
    public String toString() {
        return "ExpenseCategory{" +
                "categoryId=" + id +
                ", categoryName=" + categoryName +
                ", categoryType='" + getCategoryType().orElse("Not specified") + '\'' + // ✅ Using Optional safely
                '}';
    }
}
