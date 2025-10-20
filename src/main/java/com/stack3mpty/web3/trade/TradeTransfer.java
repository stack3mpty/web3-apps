package com.stack3mpty.web3.trade;

import com.stack3mpty.web3.common.Web3Property;
import lombok.extern.slf4j.Slf4j;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ChainIdLong;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.math.BigDecimal;

/**
 * @author stack3mpty
 * @date 2025/10/20 22:41
 */
@Slf4j
public class TradeTransfer {
    public static void transfer(String toAddress, BigDecimal amount) {
        log.info("Transfering {} to {}", amount, toAddress);
        Credentials credentials = Credentials.create(Web3Property.PRIVATE_KEY);
        try {
            TransactionManager txManager = new RawTransactionManager(
                    Web3Property.web3, credentials, ChainIdLong.SEPOLIA);
            Transfer transfer = new Transfer(Web3Property.web3, txManager);
            TransactionReceipt receipt = transfer.sendFunds(
                    toAddress,
                    amount,
                    Convert.Unit.ETHER
            ).send();

            log.info("Tx hash: {}", receipt.getTransactionHash());
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        TradeTransfer.transfer(Web3Property.ADDRESS_2, BigDecimal.valueOf(0.01));
    }
}
