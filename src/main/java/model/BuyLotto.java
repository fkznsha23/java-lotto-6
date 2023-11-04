package model;

import java.util.ArrayList;
import java.util.List;

import validators.InputException;
import view.InputView;

public class BuyLotto {

	private static final int LOTTO_PRICE = 1000;
	private int amount;
	private int page;
	private List<BuyLottoNumber> numberList;
	
	public BuyLotto(String amountText) {
		int amount = changeBuyAmount(amountText);
		int page = checkRightAmount(amount);
		this.amount = amount;
		this.page = page;
		this.numberList = numberList();
	}
	
	private static void againBuyAmount() {
		System.out.println();
		InputView.getBuyAmount();
	}

	private static int changeBuyAmount(String amount) {
		try {
			InputException.checkNumber(amount);
		} catch (Exception e) {
			System.out.println(e);
			againBuyAmount();
		}
		
		return Integer.valueOf(amount);
	}
	
	private int checkRightAmount(int amount) {
		try {
			InputException.checkRightAmount(amount, LOTTO_PRICE);
		} catch (Exception e) {
			System.out.println(e);
			againBuyAmount();
		}
		
		return amount/LOTTO_PRICE;
	}
	
	private List<BuyLottoNumber> numberList() {
		List<BuyLottoNumber> buyLottoNumberList = new ArrayList<>();
		for(int i = 1; i <= page; i++) {
			BuyLottoNumber buyLottoNumber = new BuyLottoNumber();
			buyLottoNumberList.add(buyLottoNumber);
		}
		return buyLottoNumberList;
	}

	public int getPage() {
		return page;
	}

	public List<BuyLottoNumber> getNumberList() {
		return numberList;
	}
}
