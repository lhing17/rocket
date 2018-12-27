package cn.gsein.common.util;

import cn.gsein.common.config.CryptoConfigProperties;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Shiro相关的工具类
 *
 * @author G.Seinfeld
 * @date 2018/12/27
 */
public class ShiroUtil {

    /**
     * 对密码进行加密
     *
     * @param cryptoConfigProperties 加密相关的配置实体
     * @param password               未加密的密码
     * @param salt                   盐
     * @return 加密的密码
     */
    public static String hashPassword(CryptoConfigProperties cryptoConfigProperties, String password, String salt) {
        return new SimpleHash(cryptoConfigProperties.getAlgorithmName(),
                password, salt, cryptoConfigProperties.getHashIterations()).toHex();
    }

    /**
     * 使用随机数生成器生成盐
     *
     * @param cryptoConfigProperties 加密相关的配置实体
     * @return 盐
     */
    public static String generateSalt(CryptoConfigProperties cryptoConfigProperties) {
        RandomNumberGenerator generator = new SecureRandomNumberGenerator();
        return generator.nextBytes(cryptoConfigProperties.getNextBytesSize()).toHex();
    }
}
