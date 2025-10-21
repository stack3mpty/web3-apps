package com.stack3mpty.web3.balance;

import com.stack3mpty.web3.common.Web3Property;
import lombok.extern.slf4j.Slf4j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author ckai
 * @date 2025/10/20 21:02
 */
@Slf4j
public class BalanceInquiry {
    public static BigDecimal getBalance(String address) {
        try {
            EthGetBalance ethGetBalance = Web3Property.web3.ethGetBalance(address, DefaultBlockParameterName.LATEST).send();
            BigInteger balance = ethGetBalance.getBalance();
            log.info("Balance: " + Convert.fromWei(balance.toString(), Convert.Unit.ETHER) + " ETH");
            return Convert.fromWei(balance.toString(), Convert.Unit.ETHER) ;
        } catch (IOException e) {
            log.error("Error: " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        BigDecimal balance = getBalance(Web3Property.address1);
        System.out.println(balance);
    }
}
