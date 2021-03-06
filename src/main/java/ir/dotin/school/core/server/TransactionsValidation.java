package ir.dotin.school.core.server;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TransactionsValidation {


    public  List<Response> findDeposit(List<Transaction> transactions, List<Deposit> deposits) {
        List<Response> responses = new ArrayList<Response>();
        for (int transactionCount = 0; transactionCount < transactions.size(); transactionCount++)
            for (int depositCount = 0; depositCount < deposits.size(); depositCount++) {
                if (transactions.get(transactionCount).getDepositNumber().compareTo(deposits.get(depositCount).getCustomerId()) == 0) {
                    Response resposeOfTransaction = doTransaction(transactions.get(transactionCount), deposits.get(depositCount));
                    responses.add(resposeOfTransaction);
                }
            }
        return responses;
    }

    public Response doTransaction(Transaction transaction, Deposit deposit) {
        Thread.yield();
//        synchronized (deposit) {
            Response response = null;
            if (transaction.getType().equals("deposit")) {
                BigDecimal sumDeposit = (deposit.getInitialBalance().add(transaction.getAmount()));
                if (sumDeposit.compareTo(deposit.getUpperBound()) < 0) {
                    deposit.doDepoit(transaction.getAmount());
                    response = new Response(transaction.getId(), ResponseType.SUCCESS, deposit.getInitialBalance(), "Amaliat movafaghiat amiz bod!");
                } else {
                    response = new Response(transaction.getId(), ResponseType.FAILD, deposit.getInitialBalance(), "bishtar az hade mojaz!");
                    System.out.println("bishtar az hade mojaz");
                }
            } else if (transaction.getType().equals("withdraw")) {
                BigDecimal munDeposit = (deposit.getInitialBalance().subtract(transaction.getAmount()));
                if (munDeposit.compareTo(deposit.getUpperBound()) < 0) {
                    deposit.doWithdrawl(transaction.getAmount());
                    response = new Response(transaction.getId(), ResponseType.SUCCESS, deposit.getInitialBalance(), "Amaliat movafaghiat amiz bod!");
                } else {
                    response = new Response(transaction.getId(), ResponseType.FAILD, deposit.getInitialBalance(), "mojodi kafi nis!");
                    System.out.println("mojodi kafi nis");
                }
            }
            return response;
        }

//    }
}

