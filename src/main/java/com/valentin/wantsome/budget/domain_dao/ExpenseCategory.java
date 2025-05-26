package com.valentin.wantsome.budget.domain_dao;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "expense_category")
public class ExpenseCategory {
    @Id
    @GeneratedValue
    private Long categoryId;
    private String categoryName;
    private String categoryType;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public ExpenseCategory() {
    }

    public ExpenseCategory(Long categoryId, String categoryName, String categoryType) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryType = categoryType;

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ExpenseCategory that = (ExpenseCategory) o;
        return Objects.equals(categoryId, that.categoryId) && Objects.equals(categoryName, that.categoryName) && Objects.equals(categoryType, that.categoryType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryName, categoryType);
    }

    @Override
    public String toString() {
        return "categoryOfExpense{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType='" + categoryType + '\'' +
                '}';
    }
}
