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
 * @date 2025/10/23 14:51
 */
public class DeploySimpleToken {
    /**
     *  1.注意合于只部署一次，每次部署会因为nonce的不同，产生完全不同的代币，所以不要重复部署。
     *  2.部署之后，记录下合约地址，方便后续调用。
     */
    public static void main(String[] args) throws Exception {
//        // Gas 设置
//        BigInteger gasPrice = BigInteger.valueOf(20_000_000_000L); // 20 gwei
//        BigInteger gasLimit = BigInteger.valueOf(5_000_000);
//
//        StaticGasProvider gasProvider = new StaticGasProvider(gasPrice, gasLimit);
//
//        TransactionManager txManager = new RawTransactionManager(
//                Web3Property.web3, Web3Property.credentials, ChainIdLong.SEPOLIA);
//        //部署合约
//        SimpleToken token = SimpleToken.deploy(Web3Property.web3, txManager, gasProvider).send();
//
//        System.out.println("✅ ERC20 Token deployed to address: " + token.getContractAddress());
    }
}
