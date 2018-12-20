package dev.gabrieljbo.poc.camelpoc.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    private PaymentType type;
    private long id;
    private String description;
    private LocalDate date;
    private double amount;

    public Payment(PaymentType type, long id, String description, LocalDate date, double amount) {
	super();

	this.type = type;
	this.id = id;
	this.description = description;
	this.date = date;
	this.amount = amount;
    }

    public PaymentType getType() {
	return type;
    }

    public void setType(PaymentType type) {
	this.type = type;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public LocalDate getDate() {
	return date;
    }

    public void setDate(LocalDate date) {
	this.date = date;
    }

    public double getAmount() {
	return amount;
    }

    public void setAmount(double amount) {
	this.amount = amount;
    }

}
