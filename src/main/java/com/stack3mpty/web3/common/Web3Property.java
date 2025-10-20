package com.stack3mpty.web3.common;

import io.github.cdimascio.dotenv.Dotenv;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

/**
 * @author stack3mpty
 * @date 2025/10/20 23:00
 */
public class Web3Property {
    private static final Dotenv dotenv = Dotenv.load();
    public static final String PRIVATE_KEY = dotenv.get("PRIVATE_KEY");
    public static final String RPC_URL = dotenv.get("RPC_URL");
    public static final String ADDRESS_1 = dotenv.get("ACCOUNT_1_ADDRESS");
    public static final String ADDRESS_2 = dotenv.get("ACCOUNT_2_ADDRESS");
    public static final Web3j web3 = Web3j.build(new HttpService(Web3Property.RPC_URL));
}
