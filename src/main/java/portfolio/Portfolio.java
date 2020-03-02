package portfolio;

import portfolio.investments.Investment;

import java.util.ArrayList;

public class Portfolio<T extends Investment> {

    private ArrayList<T> investments = new ArrayList<>();

    public boolean contains(T inv) {
        return investments.contains(inv);
    }

    public void buy(T inv) {
        String invTitel = inv.getTitel();
        T ownedInvestment = getShare(invTitel);
        if ( ownedInvestment == null){
           investments.add(inv);
        }
        else
        {
            ownedInvestment.setCount(ownedInvestment.getCount()+inv.getCount());
        }
    }

    public void sell(String inv, int amount) {
        T investment = getShare(inv);
        if (!(investment==null)){
            investment.setCount(investment.getCount()-amount);
            if (investment.getCount()<=0){
                investments.remove(investment);
            }
        }

    }

    public T getShare(String inv) {
        for (T investment : investments) {
            if (investment.getTitel().equals(inv)) {
                return investment;
            }
        }
        return null;
    }


    //TODO Complete this implementation and make it generic
}
