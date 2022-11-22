package ru.croc.task10;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

// класс для лота аукциона
public class aucLot {
	private Double currentPrice;
    private String name;
    private LocalDateTime auctionEndTime;
    private static final ReentrantLock lock = new ReentrantLock();

    public aucLot(Double currentPrice, LocalDateTime auctionEndTime) {
        this.currentPrice = currentPrice;
        this.auctionEndTime = auctionEndTime;
    }
    public void setCurBet(Double newPrice, String newName) {
        LocalDateTime now = LocalDateTime.now();
        if (now.isBefore(getAuctEnd())) {
            lock.lock();
            try {
                if (newPrice.compareTo(getCurrentPrice()) > 0) {
                    setCurrentPrice(newPrice);
                    authorLot(newName);
                    System.out.println("User's Bet: " + newName + " set  highest price " + newPrice + " costs.");
                }
            } finally {
                lock.unlock();
            }
        }
    }
    /*
     *Методы взаимодействия с временем аукциона
     */
    public LocalDateTime getAuctEnd() {
        return auctionEndTime;
    }

    public void setAuctEnd(LocalDateTime auctionEndTime) {
        this.auctionEndTime = auctionEndTime;
    }
    public String winner() {
        return "User: " + getAuthorName() + " take a lot.";
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getAuthorName() {
        return name;
    }

    public void authorLot(String authorName) {
        this.name= authorName;
    }


    @Override
    public String toString() {
        return "{currentPrice=" + currentPrice +
                ", authorName='" + name+ '\'' +
                ", auctionEndTime=" + auctionEndTime +
                '}';
    }
}
