package org.klarna;

import org.junit.Test;

import java.util.*;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RejectedTransactions {
    private static Map<Customer, Double> txMap = new HashMap<>();
    public static List<String> findRejectedTransactions(List<String> transactions, int creditLimit) {
        txMap.clear();
        List<String> rejectedTxs = new ArrayList<>();
        Set<Customer> rejectedCustomerSet = new HashSet<>();

        for (String tx:      transactions) {
            String[] txDetails = tx.split(",");
            if(txDetails.length == 5) {
                String fName = txDetails[0];
                String lName = txDetails[1];
                String email = txDetails[2];
                String amount = txDetails[3];
                String txId = txDetails[4];
                if(fName != null &&
                        lName != null &&
                        email != null) {
                    Customer customer = new Customer(fName, lName, email);
                    Double amountD = Double.valueOf(amount);
                    txMap.merge(customer, amountD, Double::sum);
                    if(!rejectedCustomerSet.contains(customer) &&
                            txMap.get(customer) > creditLimit) {
                        rejectedTxs.add(txId);
                    }
                }
            }
        }
        return rejectedTxs;
    }

    static class Customer {
        private String firstName;
        private String lastName;
        private String email;

        public Customer(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Customer customer = (Customer) o;
            return Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(email, customer.email);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName, email);
        }
    }




    @Test
    public void test00() {
        String tx = "John,Doe,john@doe.com,30,TR000";
        List<String> rejectedTransactions = findRejectedTransactions(emptyList(), 0);
        assertTrue(rejectedTransactions.isEmpty());
    }

    @Test
    public void test01() {
        String tx = "John,Doe,john@doe.com,200,TR0001";
        List<String> rejectedTransactions = findRejectedTransactions(List.of(tx), 200);
        assertTrue(rejectedTransactions.isEmpty());
    }

    @Test
    public void test02() {
        String tx1 = "Jane,Doe,jane@doe.com,199,TR0001";
        String tx2 = "Jane,Doe,jane@doe.com,2,TR0002";
        List<String> rejectedTransactions = findRejectedTransactions(List.of(tx1, tx2), 200);
        assertTrue(!rejectedTransactions.isEmpty());
        assertEquals(rejectedTransactions, List.of("TR0002"));
    }

    @Test
    public void test03() {
        String tx = "Jane,Doe,jane@doe.com,201,TR0001";
        List<String> rejectedTransactions = findRejectedTransactions(List.of(tx), 200);
        assertTrue(!rejectedTransactions.isEmpty());
        assertEquals(rejectedTransactions, List.of("TR0001"));
    }


    @Test
    public void test04() {
        String tx1 = "Jane,Doe,jane@doe.com,100,TR0001";
        String tx2 = "Jane,Doe,jane@doe.com,100,TR0002";
        String tx3 = "Jane,Doe,jane@doe.com,1,TR0003";
        String tx4 = "Janem,Doem,jane@doe.com,101,TR0004";
        String tx5 = "Janem,Doem,jane@doe.com,100,TR0005";
        String tx6 = "Kane,Doe,jane@doe.com,200,TR0006";
        List<String> rejectedTransactions = findRejectedTransactions(List.of(tx1, tx2, tx3, tx4, tx5, tx6), 200);
        assertTrue(!rejectedTransactions.isEmpty());
        assertEquals(rejectedTransactions, List.of("TR0003", "TR0005"));
    }
}
