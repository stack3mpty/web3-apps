package com.stack3mpty.web3.contract;

import com.stack3mpty.web3.common.Web3Property;
import com.stack3mpty.web3.generate.SimpleStorage;
import org.web3j.tx.ChainIdLong;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;

/**
 * @author stack3mpty
 * @date 2025/10/21 23:17
 */
public class SimpleContract {

    public static void main(String[] args) throws Exception {
        System.setProperty("https.protocols", "TLSv1.2");

        TransactionManager txManager = new RawTransactionManager(
                Web3Property.web3, Web3Property.credentials, ChainIdLong.SEPOLIA);
        SimpleStorage contract = SimpleStorage.load(
                Web3Property.contractAddress,
                Web3Property.web3,
                txManager,
                new DefaultGasProvider()
        );

        contract.set(BigInteger.valueOf(100)).send();
        System.out.println("set success");

        BigInteger value = contract.get().send();
        System.out.println("value: " + value);
    }
}
