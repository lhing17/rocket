package cn.gsein.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 密码加密相关的配置
 *
 * @author G.Seinfeld
 * @date 2018/12/26
 */
@Component
@ConfigurationProperties(prefix = "crypto")
public class CryptoConfigProperties {
    /**
     * 加密算法名称 支持Md2、Md5、Sha1、Sha256、Sha384、Sha512
     */
    private String algorithmName;
    /**
     * 哈希循环的次数
     */
    private int hashIterations;
    /**
     * 生成用于密码加密的盐的字节长度，默认为16
     */
    private int nextBytesSize;

    /**
     * 用于加密token的盐
     */
    private String tokenSalt;

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public int getHashIterations() {
        return hashIterations;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public int getNextBytesSize() {
        return nextBytesSize;
    }

    public void setNextBytesSize(int nextBytesSize) {
        this.nextBytesSize = nextBytesSize;
    }

    public String getTokenSalt() {
        return tokenSalt;
    }

    public void setTokenSalt(String tokenSalt) {
        this.tokenSalt = tokenSalt;
    }
}
