package ru.croc.task10;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;



public class AuctionProcess implements Runnable{
	private String userName;
    private aucLot  lot;
    public AuctionProcess (String userName, aucLot lot) {
        this.userName = userName;
        this.lot = lot;
    }
    /*Пользователи (как потоки),
     * которые участвуют в торгах
     */
	@Override
    public void run() {
		RandChoiceName randBuyers=new RandChoiceName();
        Random randPrice = new Random();
        while (LocalDateTime.now().isBefore(getLot().getAuctEnd())) {
            getLot().setCurBet(Double.valueOf(randPrice.nextInt()), randBuyers.getRandom());
        }
    }
	public aucLot getRandom(List<aucLot> ithemList) {
		int raindomIndex = (int)(Math.random()*ithemList.size());
		aucLot randomElement = ithemList.get(raindomIndex);
		return randomElement;
	}
	public String getUserName() {
        return userName;
    }

    public aucLot getLot() {
        return lot;
    }

    public void setLot(aucLot lot) {
        this.lot = lot;
    }
	
}
