package com.stack3mpty.web3.token;

import com.stack3mpty.web3.common.Web3Property;
import com.stack3mpty.web3.generate.SimpleToken;
import org.web3j.tx.ChainIdLong;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

/**
 * @author ckai
 * @date 2025/10/23 15:28
 */
public class SimpleTokenTest {
    public static void main(String[] args) throws Exception {

        SimpleToken token = load();

        // 转账
        String txHash = token.transfer(Web3Property.address2, BigInteger.valueOf(10000)).send().getTransactionHash();
        System.out.println("Transfer Tx Hash: " + txHash);

        // 查询余额
        BigInteger balance = token.balanceOf(Web3Property.address1).send();
        System.out.println("Recipient Balance: " + balance);
    }

    public static SimpleToken load() {
        TransactionManager txManager = new RawTransactionManager(
                Web3Property.web3, Web3Property.credentials, ChainIdLong.SEPOLIA);
        return SimpleToken.load(
                Web3Property.simpleTokenAddress,
                Web3Property.web3,
                txManager,
                new StaticGasProvider(
                        BigInteger.valueOf(20_000_000_000L), // gasPrice
                        BigInteger.valueOf(5_000_000)        // gasLimit
                )
        );
    }
}
